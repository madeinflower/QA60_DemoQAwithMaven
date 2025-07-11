package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.LinksPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();

    }

    @Test
    public void checkAllLinksTest () {
        new SidePanel(driver).selectLinks().hideIFrames();
        new LinksPage(driver).checkAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        new SidePanel(driver).selectBrokenLinksImages();
        new LinksPage(driver).checkBrokenLinks();
    }
}