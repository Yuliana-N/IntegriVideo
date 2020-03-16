package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;

public class ProjectTests extends BaseTest {
    LoginPage login;
    ProjectPage project;
    @Test
    public void createProject() {
        User user = new User("nyintegrivideo@mailinator.com","qwerty-21");
            loginPage
                    .openPage()
                    .login(user);
        projectPage
                .isPageOpened()
                .clickAddProject();
    }
}
