package FirstPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class VerifyPageTitle {
    @Test
    public void VerifyPageTitle () {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com";
        driver.get(url);
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle= "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        driver.close();


    }

}
