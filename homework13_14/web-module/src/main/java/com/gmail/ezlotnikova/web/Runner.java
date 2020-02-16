package com.gmail.ezlotnikova.web;

import java.lang.invoke.MethodHandles;

import com.gmail.ezlotnikova.service.SumFromFileService;
import com.gmail.ezlotnikova.web.config.WebConfig;
import com.gmail.ezlotnikova.web.constant.FilenameConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(WebConfig.class);
        ctx.refresh();

        FilenameConstant fileConstant = ctx.getBean(FilenameConstant.class);
        SumFromFileService sumFromFileService = ctx.getBean(SumFromFileService.class);

        String testFileName = fileConstant.getTestFileName();

        try {
            int sum = sumFromFileService.sumFromFile(testFileName);
            logger.info("sum = " + sum);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
        }
    }

}