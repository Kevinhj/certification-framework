package tests;

import dataproviders.ProductsCurrencyDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;
import pojo.ProductCurrencyData;
import utilities.Waits;

public class ProductTest extends BaseTest{

    public ProductTest(){
        super("Chrome");
    }

    @Test(groups = { "regression" }, dataProvider = "getProductsCurrencyFromJson", dataProviderClass = ProductsCurrencyDataProviders.class)
    public void checkOutFail(ProductCurrencyData _currencyProduct) throws InterruptedException {
        HomePage home = new HomePage(driver, getBaseUrl());
        SearchResultPage searchResult = new SearchResultPage(driver);
        ProductPage product = new ProductPage(driver);
        Waits wait = new Waits(driver);

        home.goToPage();
        home.search("MacBook");
        wait.untilElementExists(searchResult.getProductTitle());
        searchResult.openProductDetails();

        wait.untilElementExists(product.getCurrencyButton());
        product.expandCurrencyOptions();
        wait.waitForElementToBeClickable(product.getUsDollarButton());
        product.selectUsDollarCurrency();
        Assert.assertEquals(_currencyProduct.getUsDollar(), "$602.00");

        product.expandCurrencyOptions();
        wait.waitForElementToBeClickable(product.getEuroButton());
        product.selectEuroCurrency();
        Assert.assertEquals(_currencyProduct.getEuro(), "518.16€");

        product.expandCurrencyOptions();
        wait.waitForElementToBeClickable(product.getPoundSterlingButton());
        product.selectPoundSterlingCurrency();
        Assert.assertEquals(_currencyProduct.getPoundSterling(), "£454.10");
    }
}
