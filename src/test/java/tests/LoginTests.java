package tests;


import models.User;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

        @Test
        public void login() {
            User user = new User("project@mailinator.com","QWERty123");
            loginPage
                    .openPage()
                    .login(user);
        }
    }