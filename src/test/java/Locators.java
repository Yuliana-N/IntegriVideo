import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Locators {
    private WebDriver driver;
    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/5e5c2a8ad9ad324fea889ac4");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    @AfterTest
    public void doAfterTest(){
        driver.quit();
    }
    @Test
    public void FindElements(){
        driver.findElement(By.cssSelector("#invite-users-to-chat"));
        driver.findElement(By.cssSelector("textarea"));
        driver.findElement(By.cssSelector(".integri-chat-send-message.integri-chat-action-button"));
        driver.findElement(By.cssSelector(".integri-chat-start-video.integri-chat-action-button"));

        driver.findElement(By.cssSelector(".integri-chat-settings")).click();
        driver.findElement(By.name("userName"));
        driver.findElement(By.name("userEmail"));
        driver.findElement(By.name("userPic"));
        driver.findElement(By.cssSelector(".integri-user-settings-save"));
        driver.findElement(By.cssSelector(".integri-button.integri-user-settings-reset"));
        
        driver.findElement(By.cssSelector(".integri-chat-message-text"));
        driver.findElement(By.cssSelector(".integri-chat-message-date"));
        driver.findElement(By.cssSelector(".iv-icon-pencil.integri-chat-edit-message"));
        driver.findElement(By.cssSelector(".iv-icon-trash2.integri-chat-remove-message"));

        driver.findElement(By.cssSelector(".integri-chat-manual-upload"));
        driver.findElement(By.cssSelector(".integri-file-upload-head-message.integri-text-center iv-icon.iv-icon-upload2"));
        driver.findElement(By.cssSelector(".integri-file-upload-manual-init"));
        driver.findElement(By.cssSelector(".integri-file-upload-cancel"));
        driver.findElement(By.cssSelector(".integri-file-upload-start"));

    }
}
