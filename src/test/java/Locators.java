import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators {
    private WebDriver driver;
    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/5e5c2a8ad9ad324fea889ac4");
    }
    @AfterTest
    public void doAfterTest(){
        driver.quit();
    }

}
