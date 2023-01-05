package com.tal.fraudTransactionIP.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.tal.fraudTransactionIP.model.TransactionData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MappingHandler {
    private ObjectMapper mapper;
    private ColumnPositionMappingStrategy mappingStrategy;
    @Value("${csvFile.columns}")
    private String[] csvFileColumns;
    public MappingHandler(){
        mapper = new ObjectMapper();
        mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(TransactionData.class);
    }
    public void setColumnMapping(){
        mappingStrategy.setColumnMapping(csvFileColumns);
    }

    public void readerForUpdating(TransactionData td, String ipData) throws JsonProcessingException {
        mapper.readerForUpdating(td).readValue(ipData);
    }



}
