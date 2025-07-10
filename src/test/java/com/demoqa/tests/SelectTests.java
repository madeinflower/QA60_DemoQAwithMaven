package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SelectMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getSelectMenu().hideIFrames();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Red")
                .verifyColor();
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(driver).multiSelect(new String[]{"Green", "Blue"});
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).standardMultiSelect(new String[]{"Audi", "Volvo"});
    }




}