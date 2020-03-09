package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import java.util.UUID;

public class LoginTests extends BaseTest{
    @Test
    public void login() {
        loginPage.openPage();
        loginPage.writeEmail("ertyr@mailinator.com");
        loginPage.writePassword("qwerty-21");
        loginPage.clickLogin();
    }
}
