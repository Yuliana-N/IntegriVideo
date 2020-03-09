package tests;

import org.testng.annotations.Test;

import java.util.UUID;

public class RegistrationTests extends BaseTest {

    @Test
    public void signUp() {
        registrationPage.openPage();
        registrationPage.writeEmail(UUID.randomUUID().toString()+"@gmail.com");
        registrationPage.writePassword("QWERty123");
        registrationPage.clickSignUp();
    }

}
