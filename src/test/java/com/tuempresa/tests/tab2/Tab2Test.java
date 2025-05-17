package com.tuempresa.tests.tab2;

import com.tuempresa.base.BaseTest;
import com.tuempresa.pages.barMenu.BarMenuPage;
import com.tuempresa.pages.tab2.Tab2Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tab2Test extends BaseTest {

    @Test
    public void testTab2TextVisible() {
        BarMenuPage barMenuPage = new BarMenuPage(driver);
        Tab2Page tab2Page = new Tab2Page(driver);
        barMenuPage.clickTab2();
        Assert.assertTrue(tab2Page.isTab2TextVisible(),"El texto de Tab 2 está visible.");
    }

}
