package tests;


import models.User;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTests extends BaseTest {

        @Test
        public void login() {
            User user = new User("project@mailinator.com","QWERty123");
            loginSteps
                    .login(user);
        }
    }