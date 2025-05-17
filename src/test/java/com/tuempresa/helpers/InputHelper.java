package com.tuempresa.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputHelper {
    private WebDriver driver;
    private WaitHelper waitHelper;

    public InputHelper(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, timeoutInSeconds);
    }

    public void type(By locator, String text) {
        WebElement element = waitHelper.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }
}
