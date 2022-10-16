package com.shopping.steps;

import com.shopping.page.katalon.CartPage;
import com.shopping.page.katalon.MainPage;
import com.shopping.page.katalon.SecondPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Then("I find total four items listed in my cart")
    public void iFindTotalFourItemsListedInMyCart() throws InterruptedException {
        cartPage.checkTotalItemsInTheCart(4);
    }

    @When("I search for lowest price item")
    public void iSearchForLowestPriceItem() {
        cartPage.findSmallestPriceItem();
    }

    @And("I am able to remove the lowest price item from my cart")
    public void iAmAbleToRemoveTheLowestPriceItemFromMyCart() {
        cartPage.removeSmallestPriceItem();
    }

    @Then("I am able to verify three items in my cart")
    public void iAmAbleToVerifyThreeItemsInMyCart() throws InterruptedException {
        cartPage.checkTotalItemsInTheCart(3);
    }
}
