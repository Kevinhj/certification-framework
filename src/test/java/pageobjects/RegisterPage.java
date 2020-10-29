package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private By firstNameTextBox = By.id("input-firstname");
    private By lastNameTextBox = By.id("input-lastname");

    public RegisterPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=account/register");
    }

    public WebElement getFirstNameTextBox() {
        return driver.findElement(this.firstNameTextBox);
    }

    public WebElement getLastNameTextBox(){
        return driver.findElement(this.lastNameTextBox);
    }

    public void createCustomer(String firstName, String lastName){
        this.getFirstNameTextBox().sendKeys(firstName);
        this.getLastNameTextBox().sendKeys(lastName);
    }
}
