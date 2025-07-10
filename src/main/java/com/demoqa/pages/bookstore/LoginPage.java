package com.demoqa.pages.bookstore;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement user;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;


    public LoginPage enterUserData(String userName, String password) {
        type(user,userName);
        type(passwordField,password);
        return this;
    }

    public ProfilePage clickOnLoginButton() {
        loginButton.click();
        return new ProfilePage(driver);
    }
}
