package com.imdb.stepdefinitions;

import com.imdb.common.ProductEnum;
import com.imdb.config.ApplicationEnvironmentVariable;
import com.imdb.status.ApplicationStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static com.imdb.status.AppStatus.RUNNING;

public class ApplicationStatusStepDefinitions {
Logger logger=LoggerFactory.getLogger(ApplicationStatusStepDefinitions.class);
    @Steps
    ApplicationStatus theApplication;

    @Given("the {string} application is running")
    public void the_application_is_running(String product) {
        switch (ProductEnum.valueOf(product.toUpperCase())) {
            case IMDB:
                assertThat(theApplication.currentStatus(String.format(ApplicationEnvironmentVariable.IMDB_API_BASE_URL,ApplicationEnvironmentVariable.IMDB_API_KEY))).isEqualTo(RUNNING);
                break;
            default:
                logger.warn("{} not matched !",product.toUpperCase());
        }

    }
}