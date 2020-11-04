package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {


    public RegisterTest(){
        super("Chrome");
    }

    @Test(groups = {"regression"})
    public void testCreateCustomer() throws InterruptedException {
        RegisterPage register = new RegisterPage(driver, getBaseUrl());
        register.goToPage();
        register.createCustomer("Kev","Test", "kevinandres.hernandez.jimenez@ucreativa.com",
                "8005541965","test12345", "test12345");

        Thread.sleep(5000);
        Assert.assertEquals(register.getAccountCreatedMessage(), "Your Account Has Been Created!");
    }
}
