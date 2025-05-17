package com.tuempresa.pages.tab1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tab1Page {

    private WebDriver driver;

    // Elemento para el texto "Tab 1 page"
    @FindBy(xpath = "//android.view.View[@text=\"Tab 1 page\"]")
    public WebElement tab1Text;

    public Tab1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Método para verificar si el texto está visible
    public boolean isTab1TextVisible() {
        String text = tab1Text.getText();
        System.out.println("Valor: " + text);
        if(text.isEmpty()){
            return false;
        }
        return true;
    }
}
