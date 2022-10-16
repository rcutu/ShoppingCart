package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.shopping.page.katalon.MainPage.pickNRandom;

public class SecondPage extends Base {

    @FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> secondPageCartBtns;

    @FindBy(xpath = "//*[@id='page']/header/nav/text()")
    private WebElement secondPageNumber;

    public void addTwoRandomItemsToCartSecondPage() throws InterruptedException {
        Actions action = new Actions(this.driver);
        List<WebElement> itemsToAddSecondPage = pickNRandom(secondPageCartBtns, 2);
        action.moveToElement(secondPageCartBtns.get(0));
        Thread.sleep(1000);
        itemsToAddSecondPage.get(0).click();
        action.moveToElement(secondPageCartBtns.get(1));
        Thread.sleep(1000);
        itemsToAddSecondPage.get(1).click();
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
