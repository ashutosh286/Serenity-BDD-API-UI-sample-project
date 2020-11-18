package com.imdb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags={"@imdb"},
        plugin = {"pretty"},
        features = "src/test/resources/features"
)
public class CucumberTestSuite {}
