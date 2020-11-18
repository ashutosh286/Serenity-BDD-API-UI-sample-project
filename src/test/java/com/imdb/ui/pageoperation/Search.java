package com.imdb.ui.pageoperation;

import com.imdbui.pagewebelements.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imdb.stepdefinitions.SearchForStepDefinitions;

import java.util.ArrayList;
import java.util.List;

public class Search {
   private static Logger logger = LoggerFactory.getLogger(Search.class);

   @Steps
    SearchResultPage searchResultPage;
    @Step("select item from side bar")
    public  void clickItem(String item){
        searchResultPage.MOVIE.click();
    }
    @Step("item list from result page")
    public  List<String> getItemList(){
        List<WebElement> itemList=searchResultPage.resultList;
        List<String> actualItemList=new ArrayList<>();
        for(WebElement element:itemList){
            actualItemList.add(element.getText());
        }
       return actualItemList;
    }
}
