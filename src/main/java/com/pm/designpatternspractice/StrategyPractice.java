package com.pm.designpatternspractice;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * STRATEGY PATTERN PRACTICE
 * 
 * Scenario: Your team's DataExporter class works, but it's painful to maintain.
 * Every new format means adding another branch to the if/else chain inside export().
 * Last sprint someone added XML and broke CSV because they forgot a "return".
 * 
 * Your job: Refactor this into the Strategy pattern.
 * 
 * Rules:
 *   - No if/else or switch on format type in the exporter
 *   - Adding a new format (e.g. YAML) should require ZERO changes to DataExporter
 *   - Each format is independently testable
 */

// ============ THIS IS THE CODE YOU'RE REFACTORING ============

class DataExporter {
    private ExportStrategy exportStrategy;
    public DataExporter(){}
    public DataExporter(ExportStrategy exportStrategy){
        this.exportStrategy = exportStrategy;
    }
    public void setExportStrategy(ExportStrategy exportStrategy){
        this.exportStrategy = exportStrategy;
    }

    public String export(List<Map<String,String>> data){
        return this.exportStrategy.export(data);
    }
    /*
    public String export(String format, List<Map<String, String>> records) {
        if (format.equals("json")) {
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

        } else if (format.equals("csv")) {
            StringBuilder sb = new StringBuilder();
            if (!records.isEmpty()) {
                sb.append(String.join(",", records.get(0).keySet())).append("\n");
            }
            for (Map.Entry<String, String> entry : records.get(0).entrySet()) {
                // header already added above
            }
            for (Map.Entry<String, String> entry : records.get(0).entrySet()) {
                // dead code from a bad merge, nobody removed it
            }
            for (Map<String, String> record : records) {
                sb.append(String.join(",", record.values())).append("\n");
            }
            return sb.toString();

        } else if (format.equals("xml")) {
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

        } else {
            throw new IllegalArgumentException("Unknown format: " + format);
        }
    }*/
}

// ============ YOUR REFACTORED VERSION GOES BELOW ============

// TODO: Define an ExportStrategy interface

// TODO: Implement JsonExportStrategy

// TODO: Implement CsvExportStrategy

// TODO: Implement XmlExportStrategy

// TODO: Rewrite DataExporter to use a strategy instead of if/else


// ============ TEST — DON'T MODIFY ============

class StrategyPractice {
    public static void main(String[] args) {
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> row1 = new LinkedHashMap<>();
        row1.put("name", "Alice");
        row1.put("role", "Engineer");
        Map<String, String> row2 = new LinkedHashMap<>();
        row2.put("name", "Bob");
        row2.put("role", "Designer");
        data.add(row1);
        data.add(row2);

        /*:
        DataExporter oldExporter = new DataExporter();
        System.out.println("=== OLD JSON ===");
        System.out.println(oldExporter.export("json", data));
        System.out.println("=== OLD CSV ===");
        System.out.println(oldExporter.export("csv", data));
        System.out.println("=== OLD XML ===");
        System.out.println(oldExporter.export("xml", data));
    */
        //TODO: Uncomment your refactored version:
        // System.out.println("=== NEW JSON ===");
         DataExporter jsonExporter = new DataExporter(new JsonExportStrategy());
         System.out.println(jsonExporter.export(data));
        //
         System.out.println("=== NEW CSV ===");
         DataExporter csvExporter = new DataExporter(new CsvExportStrategy());
         System.out.println(csvExporter.export(data));
        //
        System.out.println("=== NEW XML ===");
         DataExporter xmlExporter = new DataExporter(new XmlExportStrategy());
        System.out.println(xmlExporter.export(data));

        // The real win: adding YAML means writing ONE new class. Zero changes elsewhere.
    }
}
