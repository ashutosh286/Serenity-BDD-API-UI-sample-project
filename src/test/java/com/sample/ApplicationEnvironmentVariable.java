package com.sample;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class ApplicationEnvironmentVariable {
    private static EnvironmentVariables environmentVariables;
    public static final String API_STATUS_BASE_URL =  EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("environments.qa.api.status.base.url");
    public static final String API_TRADE_BASE_URL =  EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("environments.qa.api.trade.base.url");
}
