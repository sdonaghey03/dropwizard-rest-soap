package com.kainos.example.helpers;

import com.kainos.example.ExternalConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHelper {

    private static ExternalConfiguration configuration;


    public static ExternalConfiguration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(ExternalConfiguration configuration) {
        ConfigurationHelper.configuration = configuration;
    }
}
