package com.shopping.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Base {

    protected ChromeDriver driver;
    protected WebDriverWait wait;
    //System.getProperty("user.dir") + "\resources\drivers\chromedriver.exe"

    public void initChrome() {
        String path = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds((long) 10.00));
    }

    protected void isAt() {
    }

}
