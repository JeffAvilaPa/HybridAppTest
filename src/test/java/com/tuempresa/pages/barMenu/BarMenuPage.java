package com.tuempresa.pages.barMenu;

import com.tuempresa.helpers.ClickHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BarMenuPage {

    private WebDriver driver;
    ClickHelper clickHelper;

    @FindBy(xpath = "//android.view.View[@text=\"Tab 1\"]")
    public WebElement tab1Button;

    @FindBy(xpath = "//android.view.View[@text=\"Tab 2\"]")
    public WebElement tab2Button;

    @FindBy(xpath = "//android.view.View[@text=\"Tab 3\"]")
    public WebElement tab3Button;

    public BarMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTab1() {
        clickHelper = new ClickHelper(driver, 10);
        clickHelper.click(this.tab1Button);
    }

    public void clickTab2() {
        clickHelper = new ClickHelper(driver, 10);
        clickHelper.click(this.tab2Button);
    }

    public void clickTab3() {
        clickHelper = new ClickHelper(driver, 10);
        clickHelper.click(this.tab3Button);
    }

}
