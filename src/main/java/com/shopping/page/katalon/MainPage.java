package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends Base {

    private SecondPage secondpage;

    final String url = "https://cms.demo.katalon.com/";
    @FindBy(xpath = "//*[@class='site-title']")
    private WebElement title;

    @FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> addToCartBtns;

    @FindBy(xpath = "//*[@class='next page-numbers']")
    private WebElement nextPageBtn;

    @Override
    public void isAt() {
        this.wait.until(driver -> this.title.isDisplayed());
    }

    public void addTwoRandomItemsToCart() throws InterruptedException {
        Actions action = new Actions(this.driver);
        List<WebElement> itemsToAdd = pickNRandom(addToCartBtns, 2);
        Thread.sleep(1000);
        action.moveToElement(itemsToAdd.get(0));
        itemsToAdd.get(0).click();
        action.moveToElement(itemsToAdd.get(1));
        Thread.sleep(1000);
        itemsToAdd.get(1).click();
    }

    public static List<WebElement> pickNRandom(List<WebElement> lst, int n) {
        List<WebElement> copy = new ArrayList<WebElement>(lst);
        Collections.shuffle(copy);
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }

    public void moveToSecondPage() throws InterruptedException {
        this.nextPageBtn.click();
        Thread.sleep(2000);
    }

    public void goToMainPageUrl() {
        this.driver.get(url);
    }

}

