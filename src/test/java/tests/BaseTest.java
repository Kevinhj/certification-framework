package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    private String browser;
    private  ChromeOptions chromeOptions;

    public BaseTest(String browser){
        this.browser = browser;
    }

    public String getBaseUrl(){
        return "https://demo.opencart.com/";
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        this.setWebDriverConfiguration(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    private void setWebDriverConfiguration(String browser) {
        switch (browser){
            case "Chrome":
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }
}
