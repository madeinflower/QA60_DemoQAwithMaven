package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookstore.LoginPage;
import com.demoqa.pages.bookstore.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    private LoginPage loginPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).hideFixedBanner().selectLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).enterUserData("loveoflive", "t101520A_%").clickOnLoginButton();
        new ProfilePage(driver).verifyUserName("loveoflive");
    }


}
