package com.pm.designpatternspractice;

import java.util.List;
import java.util.Map;

public class CsvExportStrategy implements  ExportStrategy{
    @Override
    public String export(List<Map<String, String>> records) {
        StringBuilder sb = new StringBuilder();
        if (!records.isEmpty()) {
            sb.append(String.join(",", records.get(0).keySet())).append("\n");
        }
        for (Map<String, String> record : records) {
            sb.append(String.join(",", record.values())).append("\n");
        }
        return sb.toString();
    }
}
