package tests;


import models.User;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    User user = new User("project@mailinator.com","QWERty123");
        @Test
        public void login() {

            loginPage
                    .openPage()
                    .login(user);
        }
    }