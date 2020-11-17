package com.imdb.stepdefinitions;

import com.imdb.common.RequestUtil;
import com.imdb.config.ApiResourceUrl;
import com.imdb.ui.pageoperation.Search;
import com.imdbui.pageoperation.ImdbHome;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchForStepDefinitions {
    Logger logger = LoggerFactory.getLogger(SearchForStepDefinitions.class);
    Response response;
    @Steps
    ImdbHome imdbHome;
    @Steps
    Search search;

    List<String> filteredMovieList;

    @When("I search for")
    public void i_search_for(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps();
        String url = String.format(ApiResourceUrl.SEARCH, list.get(0).get("s"));
        response = RequestUtil.getDetailByTitle(list.get(0));
    }

    @Then("verify response to keep only movies with titles")
    public void verify_response_to_keep_only_movies_with_titles(DataTable dt) {
        List<String> expectedList = dt.asList();
        JsonPath jsonPath = response.jsonPath();
        List<String> movieTitleArray = jsonPath.getList("Search.Title");
        filteredMovieList = new ArrayList<>();

        for (String movie : movieTitleArray)
            if (expectedList.contains(movie))
                filteredMovieList.add(movie);
        Serenity.recordReportData().withTitle("verifying filtered movie list contains expected movie list").andContents("Filtered Movie List : " + filteredMovieList + "\n" + "Expected Movie List : " + expectedList);
        logger.info("verifying filtered movie list contains expected movie list : {} : {}",expectedList,filteredMovieList);
        Assert.assertEquals("Expected and Actual List are not equal", expectedList, filteredMovieList);

    }

    @Then("open the imdb url")
    public void open_the_imdb_url() {
        imdbHome.goToHomePage();
    }

    @Then("Search for {string} in lookup input")
    public void search_for_in_lookup_input(String searchItem) {
        ImdbHome.searchItem(searchItem);
    }

    @Then("Click on Movie in Category Search box")
    public void click_on_Movie_in_Category_Search_box() throws InterruptedException {
        search.clickItem("Movie");
    }

    @And("check that Displaying results table contains movie titles from filtered response")
    public void getTheListOfMovieItems() {
        List<String> actualMovieList = search.getItemList();
        Serenity.recordReportData().withTitle("verifying actual movie list contains filtered movie list").andContents("Expected Movie List : " + filteredMovieList + "\n" + "Actual Movie List : " + actualMovieList);
        logger.info("verifying actual movie list contains filtered movie list : {} : {}",actualMovieList,filteredMovieList);
        for(String filteredMovie:filteredMovieList) {
            logger.info("actualMovieList : {} contains filteredMovie : {}",actualMovieList,filteredMovie);
            Assert.assertTrue(actualMovieList.toString().contains(filteredMovie));
        }
    }
}