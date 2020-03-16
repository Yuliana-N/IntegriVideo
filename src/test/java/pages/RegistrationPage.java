package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openPage() {
        driver.get("https://www.integrivideo.com/signup");
        return this;
    }

    public RegistrationPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".iv-icon-user-plus")));
        return this;
    }

    public RegistrationPage writeEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public RegistrationPage writePassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public RegistrationPage clickSignUp() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        return this;
    }
   /* public void verifySignUp(){
        driver.findElement(By.cssSelector())

    }*/
}
