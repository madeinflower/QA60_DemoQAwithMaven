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
        typeWithJS(user,userName,0,300);
        typeWithJS(passwordField,password,0,300);
        return this;
    }

    public ProfilePage clickOnLoginButton() {
        clickWithJS(loginButton,0,300);
        return new ProfilePage(driver);
    }
}
