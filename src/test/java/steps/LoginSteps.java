package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage page;

    public LoginSteps(WebDriver driver) {
        page = new LoginPage(driver);
    }

    @Step("Login by user {user.email}")
    public void login(User user) {

            page
                .openPage()
                .login(user);
    }
}

