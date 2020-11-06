package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

public class RegisterPage extends BasePage {

    private By firstNameTextBox = By.id("input-firstname");
    private By lastNameTextBox = By.id("input-lastname");
    private By emailTextBox = By.id("input-email");
    private By phoneTextBox = By.id("input-telephone");
    private By passwordTextBox = By.id("input-password");
    private By passwordConfirmationTextBox = By.id("input-confirm");
    private By privacyPolicyCheckBox = By.xpath("//input[@type='checkbox']");
    private By submitButton = By.xpath("//input[@value='Continue']");
    private By accountCreatedContainer = By.xpath("//*[@id='content']/h1");

    public RegisterPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=account/register");
    }

    public WebElement getFirstNameTextBox() {
        return driver.findElement(this.firstNameTextBox);
    }

    public WebElement getLastNameTextBox(){
        return driver.findElement(this.lastNameTextBox);
    }

    public WebElement getEmailTextBox(){
        return driver.findElement(this.emailTextBox);
    }

    public WebElement getPhoneTextBox(){
        return driver.findElement(this.phoneTextBox);
    }

    public WebElement getPasswordTextBox(){
        return driver.findElement(this.passwordTextBox);
    }

    public WebElement getPasswordConfirmationTextBox(){
        return driver.findElement(this.passwordConfirmationTextBox);
    }

    public WebElement getPrivatePolicyCheckBox(){
        return driver.findElement(this.privacyPolicyCheckBox);
    }

    public WebElement getSubmitButton(){
        return driver.findElement(this.submitButton);
    }

    public WebElement getAccountCreated(){
        return driver.findElement(this.accountCreatedContainer);
    }

    public String getAccountCreatedMessage(){
        return driver.findElement(this.accountCreatedContainer).getText();
    }

    public void createCustomer(String firstName, String lastName, String phone, String password, String passwordConfirmation){
        this.getFirstNameTextBox().sendKeys(firstName);
        this.getLastNameTextBox().sendKeys(lastName);
        this.getEmailTextBox().sendKeys(randomEmail());
        this.getPhoneTextBox().sendKeys(phone);
        this.getPasswordTextBox().sendKeys(password);
        this.getPasswordConfirmationTextBox().sendKeys(passwordConfirmation);
        this.getPrivatePolicyCheckBox().click();
        this.getSubmitButton().click();
    }

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
}
