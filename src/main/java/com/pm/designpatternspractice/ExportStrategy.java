package com.pm.designpatternspractice;

import java.util.List;
import java.util.Map;

public interface ExportStrategy {
    String export(List<Map<String, String>> records);
}
