package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://www.integrivideo.com/signup");

    }
    public void writeEmail(String email){
        driver.findElement(By.name("email")).sendKeys(email);

    }
    public void writePassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);

    }
    public void clickSignUp() {
        driver.findElement(By.cssSelector(".btn-primary")).click();

    }
   /* public void verifySignUp(){
        driver.findElement(By.cssSelector())

    }*/
}
