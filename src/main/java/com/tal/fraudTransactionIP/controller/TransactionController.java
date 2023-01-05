package com.tal.fraudTransactionIP.controller;


import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.tal.fraudTransactionIP.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping(path = "/fraud")
public class TransactionController {
    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction/{fileName}")
    public ResponseEntity downloadFile(@PathVariable String fileName) {
        try {
            Resource resource = transactionService.retrieveCsvFile(fileName);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .contentType(MediaType.parseMediaType("application/csv"))
                    .body(resource);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("File not found " + fileName);
        }
    }


    @PostMapping("/transaction/{fileName}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity uploadTransactions(@RequestParam("file") MultipartFile file, @PathVariable("fileName") String fileName) {

        if (file.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("transactions file provided must not be empty");
        }
        try {
            transactionService.processCsvFile(file, fileName);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing csv file");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("file was processed successfully");
    }



}
