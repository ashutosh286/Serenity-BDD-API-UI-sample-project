package com.imdb.common;

import com.imdb.config.ApplicationEnvironmentVariable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imdb.templates.FieldValues;
import com.imdb.templates.MergeFrom;

import java.io.IOException;
import java.util.Map;

public class RequestUtil {
private static Logger logger= LoggerFactory.getLogger(RequestUtil.class);
private static final String baseUrl=String.format(ApplicationEnvironmentVariable.IMDB_API_BASE_URL,ApplicationEnvironmentVariable.IMDB_API_KEY);

    public static Response getDetailByTitle(Map reqParam) {
        return SerenityRest.given().header("Content-Type", "application/json").queryParams(reqParam).when().log().all().get(baseUrl).then().log().all().contentType(ContentType.JSON).extract().response();
    }

    public static Response getDetailByTitle(String url) {
        return SerenityRest.given()
                .when().log().all()
                .get(baseUrl.concat(url))
                .then().log().all().contentType(ContentType.JSON).extract().response();

    }


    public static String requestMaker(Map<String,String> map) throws IOException {
        logger.info("MAP : {}",map);
        return MergeFrom.template("templates/searchParameter.json")
                .withDefaultValuesFrom(FieldValues.in("templates/imdb.properties"))
                .withFieldsFrom(map);
    }
}