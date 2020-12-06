package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class seleniumLocators {
    public static void main(String[] args) throws InterruptedException {
        //String baseURL = "https://www.linkedin.com/login?";
        String baseURL = "https://www.facebook.com/";
        System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriverOld.exe");
        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       //Always add implicit wait once in your com.framework
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get(baseURL);
       Thread.sleep(3000);
       //driver.findElement(By.name("session_key")).sendKeys("london");
       //driver.findElement(By.xpath("//*[@type='password']")).sendKeys("naija");
       //Thread.sleep(3000);
      // driver.findElement(By.className("login__form_action_container")).click();
      //driver.findElement(By.partialLinkText("Forgot")).click();
      // driver.findElement(By.cssSelector("a#join_now")).click();

        //how to select dropdown
        Select selYear = new Select(driver.findElement(By.id(("year"))));
        selYear.selectByVisibleText("2019");

        //using explicit wait to click radio button element
       WebDriverWait wait = new WebDriverWait(driver, 3);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Male']"))).click();
      String elementText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Male']"))).getText();

       List<WebElement> radioBtn = driver.findElements(By.name("sex"));
       //print out the text or value
        System.out.println(elementText);
        System.out.println(radioBtn.get(0).getAttribute("Value"));

        //checking if radio button is clicked
        System.out.println(radioBtn.get(1).getAttribute("checked"));

        radioBtn.get(0).click();
        System.out.println(radioBtn.get(0).getAttribute("checked"));

        Thread.sleep(3000);
       driver.quit();

    }
}
