package com.tuempresa.pages.tab3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tab3Page {

    private WebDriver driver;

    @FindBy(xpath = "//android.view.View[@text=\"Tab 3 page\"]")
    public WebElement tab3Text;

    public Tab3Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTab3TextVisible() {
        String text = tab3Text.getText();
        System.out.println("Valor: " + text);
        if(text.isEmpty()){
            return false;
        }
        return true;
    }
}
