package base;

import config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverContext {

    public static void GoToUrl(String url){
        LocalDriverContext.getRemoteWebDriver().get(url);
    }
    public static void Maximize(){
        LocalDriverContext.getRemoteWebDriver().manage().window().maximize();
    }
    public static void QuitDriver(){
        LocalDriverContext.getRemoteWebDriver().quit();
    }
    public static void WaitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
        var jsExecutor = LocalDriverContext.getRemoteWebDriver();
        ExpectedCondition<Boolean> jsLoad = WebDriver -> (LocalDriverContext.getRemoteWebDriver())
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");

        //Get JavaScript Ready
        boolean jsReady = jsExecutor.executeScript("return document.readyState")
                .toString()
                .equals("complete");
        if(!jsReady)
            wait.until(jsLoad);
        else
            //System.out.println("Page is ready !");
            Settings.Logs.Write("Page is ready !");
    }
    public static void WaitForElementVisible(final WebElement elementFindBy){
        WebDriverWait wait = new WebDriverWait(LocalDriverContext.getRemoteWebDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }
    public static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text){
        return WebDriver -> WebDriver.findElement(elementFindBy).getText().contains(text);
    }
}