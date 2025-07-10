package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DropablePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDropable().hideIFrames();
    }
    @Test
    public void actionDragMeTest(){
        new DropablePage(driver).actionDragMe()
                .verifyDropped("Dropped!");
    }
}

