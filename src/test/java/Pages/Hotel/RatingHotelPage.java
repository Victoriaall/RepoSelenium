package Pages.Hotel;

import Drives.Web;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RatingHotelPage extends BasePage{
    By star = By.xpath("//h3[contains(text(),'Star rating')]");
    By starResult = By.xpath("//div[@class='additional-details resp-module']/span[1]");
        public void scrollToStarRating () throws InterruptedException {
            scrollToElement(star);

        }
    public void clickOnStarRating (int starRating) {
        String starsRating = "//span[@class='star-rating'][contains(text(),'"+starRating+"-star')]";
        By starRatingLocator = By.xpath(starsRating);
        clickElement(starRatingLocator);
    }
    public boolean starResultCheck ( int checkFor){
          return elementCheck(starResult, String.valueOf(checkFor));

    }
}
