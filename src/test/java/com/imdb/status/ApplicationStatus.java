package com.imdb.status;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationStatus {
    Logger logger= LoggerFactory.getLogger(ApplicationStatus.class);
    @Step("Get current status Status of Application")
    public AppStatus currentStatus(String url) {
        logger.info("URL : {}",url);
        int statusCode = RestAssured.get(url).statusCode();
        return (statusCode == 200) ? AppStatus.RUNNING : AppStatus.DOWN;
    }

    @Step("Get current status message")
    public void readStatusMessage(String url) {
        SerenityRest.get(url);
    }
}
