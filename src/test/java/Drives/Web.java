package Drives;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    private static WebDriver driver;

    public static void initDriver(String URL) {

    System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
    driver = new ChromeDriver();
    driver.get(URL);
}
 public static WebDriver getDrive(){
        return driver;
 }
 public static void close(){
        driver.close();
 }
 @After
    public static void quitB(){
        driver.quit();
 }

}
