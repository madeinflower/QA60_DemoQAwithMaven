package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(6)")
    WebElement bookstore;

    public SidePanel getBookStore() {
        //clickWithJS (bookstore, 0, 300) - use this line instead of the next if JavaExecutor is used in HomePage class
        click(bookstore);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        clickWithJS(alertsFrameWindows,0,600);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJS(widgets, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJS(interactions,0,300);
        return new SidePanel(driver);
    }



}
