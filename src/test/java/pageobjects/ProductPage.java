package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private By addToCardButton = By.id("button-cart");
    private By successModal = By.xpath("//div[contains(@class,'alert alert-success')]");
    private By checkoutButton = By.xpath("//a[@href = 'https://demo.opencart.com/index.php?route=checkout/checkout']");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public String getSuccessModalText(){
        return driver.findElement(this.successModal).getText().replaceAll("\n", "");
    }

    public WebElement getAddToCartButton(){
        return driver.findElement(this.addToCardButton);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(this.checkoutButton);
    }

    public void addProductToCard(){
        getAddToCartButton().click();
    }

    public void goToCheckout(){
        getCheckoutButton().click();
    }
}
