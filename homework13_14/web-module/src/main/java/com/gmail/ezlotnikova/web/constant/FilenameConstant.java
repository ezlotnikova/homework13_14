package com.gmail.ezlotnikova.web.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilenameConstant {

    @Value("${testFileName}")
    private String testFileName;

    public String getTestFileName() {
        return testFileName;
    }

}