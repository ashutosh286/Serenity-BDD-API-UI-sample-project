package com.imdbui.pageoperation;

import com.imdb.config.ApplicationEnvironmentVariable;
import com.imdbui.pagewebelements.ImdbHomePage;
import net.thucydides.core.annotations.Step;

public class ImdbHome  {
    ImdbHomePage imdbHomePage;
    @Step("open home page")
    public void goToHomePage(){
        imdbHomePage.openUrl(ApplicationEnvironmentVariable.IMDB_UI_BASE_URL);
    }
    @Step("search an item")
    public static void searchItem(String searchKey){
        ImdbHomePage.SEARCH_BOX.sendKeys(searchKey);
        ImdbHomePage.SEARCH_BUTTON.click();
    }
}
