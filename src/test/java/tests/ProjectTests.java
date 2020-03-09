package tests;

import org.testng.annotations.Test;

public class ProjectTests extends BaseTest {
    @Test
    public void createProject() {
        loginPage.openPage();
        loginPage.writeEmail("ertyr@mailinator.com");
        loginPage.writePassword("qwerty-21");
        loginPage.clickLogin();
        projectPage.clickAddProject();
        projectPage.addProject();
    }

}
