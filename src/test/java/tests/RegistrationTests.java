package tests;

import org.testng.annotations.Test;

import java.util.UUID;

public class RegistrationTests extends BaseTest {
    private String text = "Message with instructions was sent";

    @Test
    public void signUp() {
        registrationPage.openPage()
                        .isPageOpened()
                        .writeEmail("project@mailinator.com")
                        .writePassword("QWERty123")
                        .clickSignUp()
                        .checkSignUp(text);
    }

}
