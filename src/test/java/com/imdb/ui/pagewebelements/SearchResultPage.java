package com.imdb.ui.pagewebelements;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageObject {
    @FindBy(xpath = "//*[@id='sidebar']//a[contains(text(),'Movie')]")
    public  WebElement MOVIE;
    @FindAll(@FindBy(xpath = "//*[@id='main']//table//tr/td[@class='result_text']/a"))
    public List<WebElement> resultList;
}
