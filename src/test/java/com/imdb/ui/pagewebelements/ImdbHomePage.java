package com.imdbui.pagewebelements;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("page:imdb.homePage")
public class ImdbHomePage extends PageObject {
    @FindBy(xpath = "//*[@id='suggestion-search']")
    public static WebElement SEARCH_BOX;

    @FindBy(xpath = "//*[@id='suggestion-search-button']")
    public static WebElement SEARCH_BUTTON;
}
