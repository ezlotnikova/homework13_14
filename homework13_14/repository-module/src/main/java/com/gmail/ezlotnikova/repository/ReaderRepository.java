package com.gmail.ezlotnikova.repository;

import java.io.IOException;
import java.util.List;

public interface ReaderRepository {

    List<String> getStringsFromFile(String filename) throws IOException;

}