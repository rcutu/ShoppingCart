package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

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
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            addToCartBtns.get(random.nextInt(addToCartBtns.size())).click();
            Thread.sleep(1000);
        }
    }

    public void moveToSecondPage() throws InterruptedException {
        this.nextPageBtn.click();
        Thread.sleep(2000);
    }

    public void goToMainPageUrl() {
        this.driver.get(url);
    }

}

