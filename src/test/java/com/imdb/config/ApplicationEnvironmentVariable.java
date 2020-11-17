package com.imdb.config;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ApplicationEnvironmentVariable {
    private static EnvironmentVariables environmentVariables= SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String IMDB_API_ID=environmentVariables.getProperty("environments.qa.api.id");
    public static final String IMDB_API_KEY=environmentVariables.getProperty("environments.qa.api.key");
    public static final String IMDB_API_BASE_URL = environmentVariables.getProperty("environments.qa.imdb.api.base.url");
    public static final String IMDB_UI_BASE_URL = environmentVariables.getProperty("environments.qa.imdb.ui.base.url");
}
