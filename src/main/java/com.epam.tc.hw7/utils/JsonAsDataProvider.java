package com.epam.tc.hw7.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

public class JsonAsDataProvider {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;


    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    @SneakyThrows
    @DataProvider
    public static Object[][] provideTestData() {
        JsonFactory jsonF = new JsonFactory();
        JsonParser jp = jsonF.createJsonParser(new File("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonAsDataProvider> testDataList = new ArrayList<>();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            jp.nextToken();
            testDataList.add(objectMapper.readValue(jp, JsonAsDataProvider.class));
        }
        jp.close();
        Object[][] result = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            result[i][0] = testDataList.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Summary: ").append(summary.stream().reduce(0, Integer::sum))
                                  .append(", Elements: ").append(StringUtils.join(elements, ", "))
                                  .append(", Color: ").append(color).append(", Metal: ").append(metals)
                                  .append(", Vegetables: ").append(StringUtils.join(vegetables, ", "))
                                  .toString();
    }
}
