package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private By addToCardButton = By.id("button-cart");
    private By successModal = By.xpath("//div[contains(@class,'alert alert-success')]");
    private By checkoutButton = By.xpath("//a[@href = 'https://demo.opencart.com/index.php?route=checkout/checkout']");
    private By currencyButton = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    private By usDollarButton = By.xpath("//ul//li//button[text()='$ US Dollar']");
    private By euroButton = By.xpath("//ul//li//button[text()='€ Euro']");
    private By poundSterlingButton = By.xpath("//ul//li//button[text()='£ Pound Sterling']");

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

    public WebElement getCurrencyButton(){
        return driver.findElement(this.currencyButton);
    }

    public WebElement getUsDollarButton(){
        return driver.findElement(this.usDollarButton);
    }

    public WebElement getEuroButton(){
        return driver.findElement(this.euroButton);
    }

    public WebElement getPoundSterlingButton(){
        return driver.findElement(this.poundSterlingButton);
    }

    public void addProductToCard(){
        getAddToCartButton().click();
    }

    public void goToCheckout(){
        getCheckoutButton().click();
    }

    public void expandCurrencyOptions(){
        getCurrencyButton().click();
    }

    public void selectUsDollarCurrency(){
        getUsDollarButton().click();
    }

    public void selectEuroCurrency(){
        getEuroButton().click();
    }

    public void selectPoundSterlingCurrency(){
        getPoundSterlingButton().click();
    }
}
