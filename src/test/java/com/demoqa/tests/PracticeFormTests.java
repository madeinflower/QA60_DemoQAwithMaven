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
    public void createStudentAccount() {
        new PracticeFormPage(driver).enterPersonalData("Ana", "Smith", "test@gmail.com", "1234567890")
                .selectGender("Female")
                .enterDateOfBirthday("16 Aug 1987")
                .addSubject(new String[]{"Maths", "Chemistry"})
//                .selectHobby(new String[]{"Sport", "Music"})
//                .uploadFile("C:/Tools/cat_img.jpg")
//                .inputState("NCR")
//                .inputCity("Delhi")
//                .submit()
//                .verifySuccessRegistration("")
        ;


    }
}
