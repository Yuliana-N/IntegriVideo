package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class SettingsModalPage extends BasePage {
    public SettingsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    public void openSettingsModal() {
        driver.findElement(By.cssSelector(".integri-chat-settings")).click();
    }

    public void isSettingsModalOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Settings')]")));
    }

    public void isSettingsModalClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Settings')]")));
    }

    public void writeName(String name) {
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys(name);
    }

    public void writeEmail(String email) {
        driver.findElement(By.name("userEmail")).clear();
        driver.findElement(By.name("userEmail")).sendKeys(email);
    }

    public void setPhotoURL(String photoURL) {
        driver.findElement(By.name("userPic")).clear();
        driver.findElement(By.name("userPic")).sendKeys(photoURL);
    }

    public void clickSave() {
        driver.findElement(By.cssSelector(".integri-user-settings-save")).click();
    }

    public void checkNameRenamed(String name) {
        boolean isNameRenamed = driver.findElement(By.cssSelector(".integri-session-user-name")).getText().equals(name);
        assertTrue(isNameRenamed, "Name has't been changed");
    }


    public void checkPhotoChanged(String URL) {
        boolean isEqualURL = driver.findElement(By.cssSelector(".integri-user-pic")).getAttribute("style").contains(URL);
        assertTrue(isEqualURL, "Photo has't been changed");
    }
}

