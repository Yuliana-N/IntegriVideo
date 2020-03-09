package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://www.integrivideo.com/login");

    }
    public void writeEmail(String email){
        driver.findElement(By.name("email")).sendKeys(email);

    }
    public void writePassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(By.cssSelector(".iv-icon-enter-right")).click();
    }
}
