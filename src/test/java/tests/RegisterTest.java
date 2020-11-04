package tests;

import dataproviders.CustomersDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RegisterPage;
import pojo.CustomerData;
import utilities.Waits;

public class RegisterTest extends BaseTest {


    public RegisterTest(){
        super("Chrome");
    }

    @Test(groups = { "regression" }, dataProvider = "getCustomerDataFromJson", dataProviderClass = CustomersDataProviders.class)
    public void testCreateCustomer(CustomerData _customerData) {
        RegisterPage register = new RegisterPage(driver, getBaseUrl());
        register.goToPage();
        register.createCustomer(_customerData.getFistName(), _customerData.getLastName(),
                _customerData.getPhone(), _customerData.getPassword(), _customerData.getPasswordConfirmation());

        Waits wait = new Waits(driver);
        wait.untilElementExists(register.getAccountCreated());
        Assert.assertEquals(register.getAccountCreatedMessage(), "Your Account Has Been Created!");
    }
}
