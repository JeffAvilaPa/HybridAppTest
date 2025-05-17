package com.tuempresa.tests.tab1;

import com.tuempresa.base.BaseTest;
import com.tuempresa.pages.tab1.Tab1Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tab1Test extends BaseTest {

    @Test
    public void testTab1TextVisible() {
        Tab1Page tab1Page = new Tab1Page(driver);
        Assert.assertTrue(tab1Page.isTab1TextVisible(), "✅ El texto 'Tab 1 page'  se encontró.");
        System.out.println("✅ El texto 'Tab 1 page' está visible.");
    }
}

