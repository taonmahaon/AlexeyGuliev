package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entities.MetalColor;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class DataProvider {
    @SneakyThrows
    @org.testng.annotations.DataProvider
    public static Object[][] provideTestData() {
        JsonFactory jsonF = new JsonFactory();
        JsonParser jp = jsonF.createJsonParser(new File("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<MetalColor> testDataList = new ArrayList<>();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            jp.nextToken();
            testDataList.add(objectMapper.readValue(jp, MetalColor.class));
        }
        jp.close();
        Object[][] result = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            result[i][0] = testDataList.get(i);
        }
        return result;
    }
}
