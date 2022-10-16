package com.shopping.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {

    ChromeDriver driver;
    WebDriverWait waitDriver;
    private ChromeDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
    //System.getProperty("user.dir") + "\resources\drivers\chromedriver.exe"

    private void init() {
        this.driver = chromeDriver();
        PageFactory.initElements(this.driver, this);
    }

}
