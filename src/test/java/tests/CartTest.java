package tests;

import dataproviders.ProductsDataProviders;
import org.testng.annotations.Test;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;
import pojo.ProductData;
import utilities.Waits;
import org.testng.Assert;

public class CartTest extends BaseTest{

    public CartTest(){
        super("Chrome");
    }


    @Test(groups = { "regression" }, dataProvider = "getProductsFromJson", dataProviderClass = ProductsDataProviders.class)
    public void checkOutFail(ProductData _product) {
        HomePage home = new HomePage(driver, getBaseUrl());
        SearchResultPage searchResult = new SearchResultPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        ProductPage product = new ProductPage(driver);
        Waits wait = new Waits(driver);

        home.goToPage();
        home.search(_product.getName());
        wait.untilElementExists(searchResult.getProductTitle());

        searchResult.openProductDetails();
        product.addProductToCard();
        wait.waitForJSandJQueryToLoad();
        Assert.assertEquals(product.getSuccessModalText(), "Success: You have added " + _product.getName() + " to your shopping cart!×");

        product.goToCheckout();
        wait.untilElementExists(checkout.getCheckoutButton());
        checkout.doCheckout();
        Assert.assertEquals(checkout.getFailCheckoutModalText(), "Products marked with *** are not available in the desired quantity or not in stock!×");
    }
}
