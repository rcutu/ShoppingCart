package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class CartPage extends Base {

    public void initChromeInstance(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='page_item page-item-8']")
    private WebElement cartBtn;

    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement cartTitle;

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void checkCartTitle() {
        assertEquals(cartTitle.getAccessibleName(), "Cart");
    }



}
