package com.pm.designpatternspractice.Strategy;

import java.util.List;
import java.util.Map;

public class JsonExportStrategy implements ExportStrategy {

    @Override
    public String export(List<Map<String, String>> records) {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < records.size(); i++) {
            sb.append("  {");
            int j = 0;
            for (Map.Entry<String, String> entry : records.get(i).entrySet()) {
                sb.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\"");
                if (j < records.get(i).size() - 1) sb.append(", ");
                j++;
            }
            sb.append("}");
            if (i < records.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
