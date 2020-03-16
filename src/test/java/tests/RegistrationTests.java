package tests;

import org.testng.annotations.Test;

import java.util.UUID;

public class RegistrationTests extends BaseTest {

    @Test
    public void signUp() {
        registrationPage.openPage()
                        .isPageOpened()
                        .writeEmail(UUID.randomUUID().toString()+"@gmail.com")
                        .writePassword("QWERty123")
                        .clickSignUp();
    }

}
