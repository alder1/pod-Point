package base;

import config.Settings;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class FrameworkInitialize extends Base {
    public static void InitializeBrowser(BrowserType browserType) throws MalformedURLException {
        RemoteWebDriver driver = null;
        //This will open the browser
        switch (browserType) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
//                DesiredCapabilities cap = new DesiredCapabilities().chrome();
//                driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub), cap);
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub), chromeOptions);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", "src/Drivers/geckodriver.exe");
//                DesiredCapabilities cap = new DesiredCapabilities().firefox();
//                driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub), cap);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL(Settings.SeleniumGridHub), firefoxOptions);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case IE:
            case Safari: {
                break;
            }
            default:
                System.out.println("Failed to initialize Browser!");
                break;
        }
    }


}
