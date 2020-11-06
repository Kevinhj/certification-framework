package pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;
    public String url;

    public BasePage(WebDriver driver, String url){
        this.driver = driver;
        this.url = url;
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToPage(){
        driver.get(this.url);
    }
}
