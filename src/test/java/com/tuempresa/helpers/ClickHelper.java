package com.tuempresa.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickHelper {
    private WebDriver driver;
    private WaitHelper waitHelper;

    public ClickHelper(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, timeoutInSeconds);
    }

    public void click(WebElement element) {
        waitHelper.waitForElementToBeClickable(element);
        element.click();
    }
}
