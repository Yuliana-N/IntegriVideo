package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage {
    String s = "//*[(text()='%s')]";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openPage() {
        driver.get("https://dev.integrivideo.com/signup");
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

    public RegistrationPage checkSignUp(String text) {
        boolean isOK = driver.findElement(By.xpath(String.format(s, text))).isDisplayed();
        assertTrue(isOK, "Registration failed");
        return this;

    }
}
