package com.shopping.steps;

import com.shopping.page.katalon.CartPage;
import com.shopping.page.katalon.MainPage;
import com.shopping.page.katalon.SecondPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CartSteps {

    MainPage mainPage = new MainPage();
    SecondPage secondPage = new SecondPage();

    CartPage cartPage = new CartPage();

    @Given("I add four random items to my cart")
    public void userAddsFourRandomItemsInTheCart() throws InterruptedException {
        mainPage.initChrome();
        mainPage.goToMainPageUrl();
        mainPage.isAt();
        mainPage.addTwoRandomItemsToCart();
        mainPage.moveToSecondPage();
        secondPage.initChromeInstance(mainPage.driver);
        secondPage.addTwoRandomItemsToCartSecondPage();
    }

    @When("I view my cart")
    public void iViewMyCart() {
        cartPage.initChromeInstance(mainPage.driver);
        cartPage.clickCartBtn();
        cartPage.checkCartTitle();
    }
}
