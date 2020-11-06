package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage{

    private By productTitle = By.xpath("//div[contains(@class,'product-layout')]//h4[contains(a,'MacBook')]");
    private By productNameLink = By.xpath("//h4//a[text() = 'MacBook']");

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public WebElement getProductTitle(){
        return driver.findElement(this.productTitle);
    }

    public WebElement getProductNameLink(){
        return driver.findElement(this.productNameLink);
    }

    public void openProductDetails(){
        getProductNameLink().click();
    }
}
