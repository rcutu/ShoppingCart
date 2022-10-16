package com.shopping.steps;

import com.shopping.page.katalon.MainPage;
import com.shopping.page.katalon.SecondPage;
import io.cucumber.java.en.Given;

public class CartSteps {

    MainPage mainPage = new MainPage();
    SecondPage secondPage;

    @Given("I add four random items to my cart")
    public void userAddsFourRandomItemsInTheCart() throws InterruptedException {
        mainPage.initChrome();
        mainPage.goToMainPageUrl();
        mainPage.isAt();
        mainPage.addTwoRandomItemsToCart();
        mainPage.moveToSecondPage();
        secondPage = new SecondPage(mainPage.driver);
        secondPage.initChromeInstance();
        secondPage.isAt();
        secondPage.addTwoRandomItemsToCartSecondPage();
    }
}
