package com.shopping.page.katalon;

import com.shopping.page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartPage extends Base {

    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);

    public void initChromeInstance(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='page_item page-item-8']")
    private WebElement cartBtn;


    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement cartTitle;

    @FindBy(xpath = "//*[@class='woocommerce-cart-form__cart-item cart_item']")
    private List<WebElement> cartItems;
    public WebElement smallestPriceItem;

    String priceXPath = "//*[@class='product-subtotal']//*[@class='woocommerce-Price-amount amount']";
    String removeXPath = "//*[@class='remove']";

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void checkCartTitle() {
        assertEquals(cartTitle.getAccessibleName(), "Cart");
    }

    public void checkTotalItemsInTheCart(int itemsNumber) throws InterruptedException {
        Thread.sleep(1500);
        assertEquals(cartItems.size(), itemsNumber);
    }

    public void findSmallestPriceItem() {
        smallestPriceItem = cartItems.get(0);
        //to update with regex
        Double smallestPriceAmount = Double.parseDouble(String.format(smallestPriceItem.findElement(By.xpath(priceXPath)).getText()).replace("$", ""));
        for (WebElement item : cartItems) {
            Double price = Double.parseDouble(item.findElement(By.xpath(priceXPath)).getText().replace("$", ""));
            if (price < smallestPriceAmount)
                smallestPriceItem = item;
        }
        logger.info("smallest price item with the price " + smallestPriceItem.findElement(By.xpath(priceXPath)));
    }

    public void removeSmallestPriceItem() {
        logger.info("this item price is too cheap for me: " + smallestPriceItem.findElement(By.xpath(priceXPath)));
        smallestPriceItem.findElement(By.xpath(removeXPath)).click();
        logger.info("it was removed");
    }


}
