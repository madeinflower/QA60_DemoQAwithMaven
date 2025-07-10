package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".range-slider")
    WebElement sliderInput;

    public SliderPage moveSliderInHorizontalDir() {
        pause(1000);
        moveWithJS(0,300);
        new Actions(driver).dragAndDropBy(sliderInput,230,0).perform();
        return this;
    }

    public SliderPage verifySliderValue(String number) {
        Assert.assertEquals(sliderInput.getDomAttribute("value"),number);
        return this;
    }
}
