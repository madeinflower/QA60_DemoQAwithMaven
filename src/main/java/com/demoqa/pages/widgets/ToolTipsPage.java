package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ToolTipsPage extends BasePage {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "toolTipButton")
    WebElement toolTipsButton;

    public ToolTipsPage hoverToToolTips() {
        pause(1000);
        moveWithJS(0, 200);
        new Actions(driver).moveToElement(toolTipsButton).perform();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> toolTipsButton.getDomAttribute("aria-describedby") != null);
        pause(1000);
        return this;
    }

    public ToolTipsPage verifyToolTips(String value) {
        Assert.assertEquals(toolTipsButton.getDomAttribute("aria-describedby"), value);
        return this;
    }
}