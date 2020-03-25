package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.ChatPage;
import pages.FileUploadModalPage;
import pages.SettingsModalPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    ChatPage chatPage;
    SettingsModalPage settingsModalPage;
    FileUploadModalPage fileUploadModalPage;

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        chatPage = new ChatPage(driver);
        settingsModalPage = new SettingsModalPage(driver);
        fileUploadModalPage = new FileUploadModalPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
