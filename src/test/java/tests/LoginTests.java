package tests;


import models.User;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
        @Test
        public void login() {
            User user = new User("nyintegrivideo@mailinator.com","qwerty-21");
            loginPage
                    .openPage()
                    .login(user);

        }
    }