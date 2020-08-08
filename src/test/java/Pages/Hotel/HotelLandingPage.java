package Pages.Hotel;

import Drives.Web;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HotelLandingPage extends BasePage {

By childDropDownLocator = By.xpath("//select[@name='q-room-0-children']");
By childrenCountBox = By.xpath("//div[@class='widget-query-room-options-children']");
By searchBarLocator = By.id("qf-0q-destination");
By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
By searchButton = By.xpath("//button[@type='submit']");
By joinNow = By.xpath("//div[@id='header-full']//div[2]//span[3]");


    public void clickOnChildDropDown(int arg) {

        clickElement(childDropDownLocator);
        WebElement childDropDown= Web.getDrive().findElement(childDropDownLocator);
        Select childDrop = new Select(childDropDown);
        childDrop.selectByValue(String.valueOf(arg));//Intiger.parse// (float)1
    }
    public int getTotalChildDropDownInList (){
     return getTotalElementsInList(childrenCountBox);
    }
    public void typedCity ( String city){
       sendText(searchBarLocator, city);
    }
    public void autoSug ( String textToSelect){
        waitForElementVisible(autoSuggestionsLocator, 5);
        selectFromAutoSuggestions(autoSuggestionsLocator, textToSelect);
    }
    public void submit (){
        clickElement(searchButton);
    }
    public void closeJoinNowPopUp () {clickElement(joinNow);
    }

}
