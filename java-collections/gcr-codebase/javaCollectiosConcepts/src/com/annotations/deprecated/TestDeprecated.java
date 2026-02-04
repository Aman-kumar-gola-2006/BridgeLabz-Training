package com.annotations.deprecated;

public class TestDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Compiler warning
        api.newFeature();
    }
}