package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.ChatPage;
import pages.LoginPage;
import pages.ProjectPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    ChatPage chatPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ProjectPage projectPage;

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);
    }
//    @AfterTest(alwaysRun = true)
//    public void closeDriver(){
//        driver.quit();
//    }
}
