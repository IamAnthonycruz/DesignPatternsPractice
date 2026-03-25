package com.pm.designpatternspractice.Strategy;

import java.util.List;
import java.util.Map;

public class XmlExportStrategy implements ExportStrategy {
    @Override
    public String export(List<Map<String, String>> records) {
        StringBuilder sb = new StringBuilder("<records>\n");
        for (Map<String, String> record : records) {
            sb.append("  <record>\n");
            for (Map.Entry<String, String> entry : record.entrySet()) {
                sb.append("    <").append(entry.getKey()).append(">")
                        .append(entry.getValue())
                        .append("</").append(entry.getKey()).append(">\n");
            }
            sb.append("  </record>\n");
        }
        sb.append("</records>");
        return sb.toString();
    }
}
