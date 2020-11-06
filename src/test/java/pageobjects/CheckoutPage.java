package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

    private By checkoutButton = By.xpath("//div//a[text() = 'Checkout']");
    private By failCheckoutModal = By.xpath("//div[contains(@class,'alert alert-danger')]");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(this.checkoutButton);
    }

    public String getFailCheckoutModalText(){
        return driver.findElement(this.failCheckoutModal).getText().replaceAll("\n", "");
    }

    public void doCheckout(){
        getCheckoutButton().click();
    }
}
