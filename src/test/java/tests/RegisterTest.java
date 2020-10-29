package tests;

import org.testng.annotations.Test;
import pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {


    public RegisterTest(){
        super("Chrome");
    }

    @Test(groups = {"regression"})
    public void testCreateCustomer(){
        RegisterPage register = new RegisterPage(driver, getBaseUrl());
        register.goToPage();
        register.createCustomer("Kevin","Hernandez");
    }
}
