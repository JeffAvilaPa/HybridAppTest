package com.tuempresa.tests.tab3;

import com.tuempresa.base.BaseTest;
import com.tuempresa.pages.barMenu.BarMenuPage;
import com.tuempresa.pages.tab3.Tab3Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tab3Test extends BaseTest {

    @Test
    public void testTab3TextVisible() {
        BarMenuPage barMenuPage = new BarMenuPage(driver);
        Tab3Page tab3Page = new Tab3Page(driver);
        barMenuPage.clickTab3();
        Assert.assertTrue(tab3Page.isTab3TextVisible(),"El texto de Tab 3 está visible.");
    }


}
