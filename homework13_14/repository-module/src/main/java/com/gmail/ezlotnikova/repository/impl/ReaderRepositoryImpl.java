package com.gmail.ezlotnikova.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gmail.ezlotnikova.repository.ReaderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public ReaderRepositoryImpl() {
    }

    @Override
    public List<String> getStringsFromFile(String filename) {
        List<String> strings = new ArrayList<>();
        try (InputStream inputStream = MethodHandles.lookup().lookupClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream != null) {
                Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
                while (scanner.hasNext()) {
                    strings.add(scanner.nextLine());
                }
            } else {
                throw new IOException("Resource file not found");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return strings;
    }

}