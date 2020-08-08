package Pages;

import Drives.Web;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BasePage {
    public void sendText(By locator, String text){
        findElementUsingFluentWait(locator).sendKeys(text);

    }
    public void clickElement(WebElement element){
       element.click();
    }
    public void clickElement( By locator) {
        findElementUsingFluentWait(locator).click();
    }
    public String getText(By locator){
         return Web.getDrive().findElement(locator).getText();
    }
    public int getTotalElementsInList (By locator){
        List<WebElement> results = findElementsUsingFluentWait(locator);
        int total;
        return total = results.size();
    }
    public List <WebElement> findElementsUsingFluentWait(By locator){
        Wait fluentWait = new FluentWait<>(Web.getDrive())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Element is not found within 25 seconds");
        List<WebElement> e = (List<WebElement>) fluentWait.until((Function<WebDriver, List<WebElement>>) driver -> driver.findElements(locator));
        return e;
    }

    public WebElement findElementUsingFluentWait(By locator){
        Wait fluentWait = new FluentWait<>(Web.getDrive())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Element is not found within 25 seconds");
        WebElement e = (WebElement) fluentWait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply (WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return e;
    }
    public void waitForElementVisible(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Web.getDrive(),timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void selectFromAutoSuggestions (By locator, String textToSelect) {
        List<WebElement> autoSuggestions = Web.getDrive().findElements(locator);
        for (WebElement autoSuggestion : autoSuggestions) {
            String text = autoSuggestion.getText();
            if (text.equalsIgnoreCase(textToSelect)) {
                clickElement(autoSuggestion);
                break;
            }
        }
    }
    public void scrollToElement (By locator) {
        WebElement element = Web.getDrive().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) Web.getDrive();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public  boolean elementCheck (By locator, String checkFor) {
        List<WebElement> results = findElementsUsingFluentWait(locator);
        boolean answer = false;
        for (WebElement result : results) {
            String text = result.getText();
            if (text.startsWith(checkFor)) {
                clickElement(result);
                answer= true;
                break;
            }
        }return answer;
    }
    public boolean timeIncrement (By locator , int increment) {
        List<WebElement> results = findElementsUsingFluentWait(locator);
        String[] time = null;
        int hr = 0;
        int hr2 = 0;
        boolean hour = false;
        for (WebElement element : results) {
            if (element.getText().contains("am") | element.getText().contains("pm")) {
                time = element.getText().split("(am|pm)");
                hr = Integer.parseInt(time[0].toString());
                if (hr - hr2 == increment) {
                   hour = true;
                    break;
                }else {
                    hr2 = hr;
                }
            }
        }
        return hour;
    }
}
