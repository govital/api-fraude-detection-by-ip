package com.tal.fraudTransactionIP.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.tal.fraudTransactionIP.handler.MappingHandler;
import com.tal.fraudTransactionIP.handler.StorageHandler;
import com.tal.fraudTransactionIP.model.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private MappingHandler mapper;
    private StorageHandler storageHandler;
    private FileWriter writer;
    private StatefulBeanToCsv beanWriter;
    StatefulBeanToCsvBuilder<TransactionData> builder;
    private RestCallHandler restCallHandler;
    @Value("${csvFiles.path}")
    private String csvFilesLocalPath;
    @Value("${ipDataProvider.url}")
    private String ipDataProviderUrl;
    @Value("${ipDataProvider.accessKey}")
    private String ipDataProviderAccessKey;

    @Autowired
    public TransactionService(RestCallHandler restCallHandler, MappingHandler mapper, StorageHandler storageHandler){
        this.restCallHandler = restCallHandler;
        this.mapper = mapper;
        this.mapper.setColumnMapping();
        this.storageHandler = storageHandler;
        this.storageHandler.setFileStorageLocation();
    }

    public Resource retrieveCsvFile(String fileName) throws MalformedURLException {
        Resource resource = new UrlResource(this.storageHandler.resolve(fileName).normalize().toUri());
        if(!resource.exists()) {
            throw new MalformedURLException();
        }
        return resource;
    }

    private String getDataByIp(String ip) throws IOException {
        URL url = new URL(ipDataProviderUrl+ip+ipDataProviderAccessKey);
        return restCallHandler.stringContentCall(url, "GET");
    }

    public void processCsvFile(MultipartFile file, String fileName) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CsvToBean<TransactionData> csvToBean = new CsvToBeanBuilder(reader)
                .withType(TransactionData.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        writer = new FileWriter(fileName);
        List<TransactionData> transactionList = new ArrayList<>();
        for (TransactionData td: csvToBean.parse()){
            mapper.readerForUpdating(td, getDataByIp(td.getIp()));
            transactionList.add(td);

        }
        builder = new StatefulBeanToCsvBuilder(writer);
        beanWriter = builder.build();
        beanWriter.write(transactionList);
        writer.close();
    }
}
