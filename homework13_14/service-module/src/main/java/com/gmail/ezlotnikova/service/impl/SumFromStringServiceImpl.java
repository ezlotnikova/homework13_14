package com.gmail.ezlotnikova.service.impl;

import java.lang.invoke.MethodHandles;

import com.gmail.ezlotnikova.service.SumFromStringService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import static com.gmail.ezlotnikova.service.constant.PatternConstant.SPLIT_PATTERN;

@Service
public class SumFromStringServiceImpl implements SumFromStringService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public SumFromStringServiceImpl() {
    }

    @Override
    public int add(String numbers) throws IllegalArgumentException {
        String[] numbersArray = numbers.split(SPLIT_PATTERN);
        if (numbersArray.length > 2) {
            throw new IllegalArgumentException("More then 2 numbers found in one line");
        } else if (numbersArray.length == 0) {
            return 0;
        } else {
            int sum = 0;
            for (int i = 0; i < numbersArray.length; i++) {
                sum = sum + Integer.parseInt(numbersArray[i]);
            }
            return sum;
        }
    }

}