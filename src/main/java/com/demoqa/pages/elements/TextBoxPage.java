package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;

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
}
