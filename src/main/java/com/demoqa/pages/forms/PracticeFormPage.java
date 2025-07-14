package com.demoqa.pages.forms;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;
    //    @FindBy(id = "currentAddress")
//    WebElement address;
    public PracticeFormPage enterPersonalData(String name, String surname, String email, String phone) {
        type(firstName, name);
        type(lastName, surname);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if(gender.equals("Female")) {
            click(female);
        } else if(gender.equals("Male")) {
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PracticeFormPage enterDateOfBirthday(String date) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if(os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "A");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "A");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;
    public PracticeFormPage addSubject(String[] subject) {
        for (int i = 0; i < subject.length; i++) {
            if(subject[i] != null) {
                type(subjectsInput, subject[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

}
