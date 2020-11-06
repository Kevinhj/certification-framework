package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private By searchTextBox = By.xpath("//input[@name='search']");

    public HomePage(WebDriver driver, String url){
        super(driver, url);
    }

    public WebElement getSearchTextBox(){
        return driver.findElement(this.searchTextBox);
    }

    public void search(String productName){
        this.getSearchTextBox().sendKeys(productName);
        this.getSearchTextBox().sendKeys(Keys.ENTER);
    }
}
