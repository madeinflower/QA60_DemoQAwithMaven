package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIFrames();
    }

    @Test
    public void createStudentAccount(){
        new PracticeFormPage(driver).enterPersonalData("Anna", "Smith", "anna@gmail.com", "1234567890")
                .selectGender("Male")
                .enterDateOfBirthday("16 Aug 1987")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobbies(new String[]{"Sports","Music"})
                .apployedFile("C:\\Tools")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
    @Test
    public void createStudentAccountWithSelectDate(){
        new PracticeFormPage(driver).enterPersonalData("Anna", "Smith", "anna@gmail.com", "1234567890")
                .selectGender("Male")
                .selectDate("August","1987","16")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobbies(new String[]{"Sports","Music"})
                .apployedFile("C:\\Tools")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
}
