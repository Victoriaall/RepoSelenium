package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class UsingLocator {
    @Test
    public void UsingLocator() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.naukri.com/");
        Thread.sleep(5000);
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(" Current handle: "  + currentWindowHandle);
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(" All handle " + allHandles);
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (!driver.equals(currentWindowHandle)) {
                driver.close();
            }

        }
    }
}
