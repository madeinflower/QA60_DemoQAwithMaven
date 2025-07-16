package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIFrames();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addNewStudentWithCsv")
    public void createStudentAccount(String name, String lastName, String email, String phone) {
        new PracticeFormPage(driver).enterPersonalData(name, lastName, email, phone)
                .selectGender("Female")
                .enterDateOfBirthday("16 Aug 1987")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Music"})
                .uploadFile("C:/Tools/Kotovnik.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }

    @Test
    public void createStudentAccountWithSelectDate() {
        new PracticeFormPage(driver).enterPersonalData("Ana", "Smith", "test@gmail.com", "1234567890")
                .selectGender("Female")
                .selectDate("August", "1987", "16")
                .addSubject(new String[]{"Maths", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Music"})
                .uploadFile("C:/Tools/Kotovnik.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
}