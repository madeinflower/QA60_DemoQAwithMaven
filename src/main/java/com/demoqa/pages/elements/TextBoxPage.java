package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage enterDataWithJS(String name, String email) {
        js.executeScript("document.getElementById('userName').value='"+name+"';");
        js.executeScript("document.getElementById('userName').style.border='5px solid red';"); //can be used for bug reports
        js.executeScript("document.getElementById('userEmail').value='"+email+"';");
        js.executeScript("document.getElementById('userEmail').style.border='2px solid green';"); //can be used for bug reports
        return this;
    }


    public TextBoxPage clickOnSubmitWithJS() {
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        js.executeScript("document.querySelector('#submit').click();");
        return this;
    }

    public TextBoxPage refreshWithJS() {
        js.executeScript("history.go(0);");
        return this;
    }

    public TextBoxPage getInnerTextWithJS() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        return this;
    }

    public TextBoxPage navigateToNewPageWithJS() {
        js.executeScript("window.location='https://ilcarro.web.app'");
        return this;
    }

    public TextBoxPage verifyTitleOfPageWithJS() {
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Title of page is " + title);
        return this;
    }

    public TextBoxPage generateAlertWithJS() {
        js.executeScript("alert('Hello, World!');");
        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    public TextBoxPage enterData(String name, String email) {
        typeWithJS(userName, name,0,300);
        typeWithJS(userEmail, email,0,300);
        return this;
    }
    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage keyBoardEvent(String address) {
        typeWithJS(currentAddress, address,0,300);
        Actions actions = new Actions(driver);
        // select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        // copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press tab to switch to Permanent address
        actions.sendKeys(Keys.TAB).perform();
        // paste Current to Permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage submit() {
        clickWithJS(submit,0,300);
        return this;
    }

    @FindBy(css = ".border>#currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = ".border>#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyCopyPasteTest() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assert.assertEquals(permanent[1], current[1]);
        return this;
    }
}
