package com.kainos.example.helpers;

import com.kainos.example.ExternalConfiguration;

public class ConfigurationHelper {

    private static ExternalConfiguration configuration;

    public static ExternalConfiguration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(ExternalConfiguration configuration) {
        ConfigurationHelper.configuration = configuration;
    }
}
