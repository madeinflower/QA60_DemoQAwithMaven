package com.demoqa.pages.bookstore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#userName-value")
    private WebElement user;

    public ProfilePage verifyUserName(String text) {
        Assert.assertTrue(user.isDisplayed());
        return this;
    }

    @FindBy(id = "searchBox") //input[@id='searchBox']
    WebElement searchBox;



    public ProfilePage typeKeyInSearchInput(String text) {
        type(searchBox,text);
        return this;
    }

    @FindBy(css = ".mr-2 a")
    WebElement nameBook;

    public ProfilePage verifyNameOfBook(String text) {
        //Assert.assertTrue(nameBook.isDisplayed());
        Assert.assertTrue(shouldHaveText(nameBook, text, 5));
        return this;
    }


}
