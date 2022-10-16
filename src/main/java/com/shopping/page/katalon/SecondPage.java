package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

public class SecondPage extends Base {

    @FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> addToCartBtns;

    @FindBy(xpath = "//*[@id='page']/header/nav/text()")
    private WebElement secondPageNumber;

    public void addTwoRandomItemsToCartSecondPage() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Collections.shuffle(addToCartBtns);
            addToCartBtns.get(0).click();
            Thread.sleep(1000);
        }
    }

    public void isAt() {
        this.wait.until(driver -> this.secondPageNumber.isDisplayed());
    }
}
