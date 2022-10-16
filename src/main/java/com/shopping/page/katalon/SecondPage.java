package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class SecondPage extends Base {

    @FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> secondPageCartBtns;

    @FindBy(xpath = "//*[@id='page']/header/nav/text()")
    private WebElement secondPageNumber;

    public void addTwoRandomItemsToCartSecondPage() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Collections.shuffle(secondPageCartBtns);
            secondPageCartBtns.get(0).click();
            Thread.sleep(1000);
        }
    }

    public void initChromeInstance(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @Override
    public void isAt() {
        this.wait.until(driver -> this.secondPageNumber.isDisplayed());
    }
}
