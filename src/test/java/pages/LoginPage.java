package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn-primary")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage openPage() {
        driver.get("https://dev.integrivideo.com/login");
        return this;
    }

    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public LoginPage writeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage writePassword(String password) {
        emailField.sendKeys(password);
        return this;
    }
    public ProjectPage clickLogin() {
        loginButton.click();
        ProjectPage projects = new ProjectPage(driver);
        driver.findElement(By.cssSelector(".iv-icon-enter-right")).click();
        return projects;
    }
    public void login(User user){
        writeEmail(user.getEmail());
        writePassword(user.getPassword());
        clickLogin();
    }
    }