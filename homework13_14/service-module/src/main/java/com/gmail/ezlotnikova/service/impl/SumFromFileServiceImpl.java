package com.gmail.ezlotnikova.service.impl;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;

import com.gmail.ezlotnikova.repository.ReaderRepository;
import com.gmail.ezlotnikova.service.SumFromFileService;
import com.gmail.ezlotnikova.service.SumFromStringService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumFromFileServiceImpl implements SumFromFileService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ReaderRepository readerRepository;
    private final SumFromStringService sumFromStringService;

    @Autowired
    public SumFromFileServiceImpl(ReaderRepository readerRepository, SumFromStringService sumFromStringService) {
        this.readerRepository = readerRepository;
        this.sumFromStringService = sumFromStringService;
    }

    @Override
    public int sumFromFile(String filename) throws IllegalArgumentException{
        int sum = 0;
        try {
            List<String> stringsForSum = readerRepository.getStringsFromFile(filename);
            for (String stringForSum : stringsForSum) {
                sum = sum + sumFromStringService.add(stringForSum);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return sum;
    }

}