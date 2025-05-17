package com.tuempresa.pages.tab2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Tab2Page{
    private WebDriver driver;

    @FindBy(xpath = "//android.view.View[@text=\"Tab 2 page\"]")
    public WebElement tab2Text;

    public Tab2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTab2TextVisible() {
        String text = tab2Text.getText();
        System.out.println("Valor: " + text);
        if(text.isEmpty()){
            return false;
        }
        return true;
    }


}
