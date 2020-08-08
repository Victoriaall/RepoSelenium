package Pages.Darksky;

import Pages.BasePage;
import org.openqa.selenium.By;

public class DarkskyLandingPage extends BasePage {

 By timeLine = By.xpath("//span[@class='hour']");
 public boolean twoHour(int hour){
     return timeIncrement( timeLine,hour);
 }

}
