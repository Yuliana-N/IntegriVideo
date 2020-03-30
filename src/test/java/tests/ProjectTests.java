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
        User user = new User("project@mailinator.com","QWERty123");
        loginSteps
                .login(user);
        projectPage
                .isPageOpened()
                .clickAddProject()
                .addProject("onliner","description","http://onliner.by","http://tut.by")
                .clickCreate()
                .checkAddedProject();
    }
}
