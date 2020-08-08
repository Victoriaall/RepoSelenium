package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import javax.xml.xpath.XPath;


public class HomeWork {
    @Test
    public void UsingLocator() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By signEmail = By.xpath("//input[@data-testid='royal_email']");
        WebElement signInEmailInput = driver.findElement(signEmail);
        signInEmailInput.sendKeys(" helloMe@test.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By signPass = By.xpath("//input[contains(@data-testid,'_pas')]");
        WebElement signPassword = driver.findElement(signPass);
        signPassword.sendKeys("1234!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By firstName = By.xpath("//input[@name= 'firstname']");
        WebElement firstNameAdd = driver.findElement(firstName);
        firstNameAdd.sendKeys("First name");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By lastName = By.xpath("//input[@name= 'lastname']");
        WebElement lastNameAdd = driver.findElement(lastName);
        lastNameAdd.sendKeys("Last name");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By mobileNumber = By.xpath("//input[contains(@ aria-label,'Mobile number or email')]");
        WebElement mobileNumberAdd = driver.findElement(mobileNumber);
        mobileNumberAdd.sendKeys("12342342323");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
