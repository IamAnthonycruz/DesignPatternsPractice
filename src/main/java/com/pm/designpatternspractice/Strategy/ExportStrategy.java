package com.pm.designpatternspractice.Strategy;

import java.util.List;
import java.util.Map;

public interface ExportStrategy {
    String export(List<Map<String, String>> records);
}
