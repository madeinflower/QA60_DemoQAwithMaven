package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement>iframe;

    public FramePage returnListOfFrames() {
        //iframe.size(); // by finding all web elements
        System.out.println("The total size: "+ iframe.size());
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,1));
        return this;
    }


    @FindBy(id = "frame1")
    WebElement frame1;

    public FramePage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }


    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement mainPageTitle;

    public FramePage verifyMainPageByTitle(String title) {
        Assert.assertTrue(mainPageTitle.getText().contains(title));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public FramePage handleNestedFrame() {
        driver.switchTo().frame(frame1); //switch to frame1
        System.out.println("IFrame is " + body.getText()); //get text from parent frame
        System.out.println("IFrames quantity inside IFrame is " + iframe.size()); // number of iframes in parent
        driver.switchTo().frame(0);
        System.out.println("IFrame is " + body.getText());
        driver.switchTo().parentFrame(); //switch to parent
        return this;
    }




}
