package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector(".integri-chat-send-message");
    private final static By CHAT_TEXTAREA = By.cssSelector("textarea");
    private final static By ERROR_MESSAGE = By.cssSelector(".integri-notify-error");

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void isChatOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-input")));
    }

    public void writeText(String text) {
        driver.findElement(CHAT_TEXTAREA).sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(CHAT_INPUT).click();
    }

    public void clickEnter() {
        driver.findElement(CHAT_TEXTAREA).sendKeys(Keys.ENTER);
    }

    public void messageShouldExist(int messageIndex, String text) {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-message-container")));
        List<WebElement> message = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = message.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message do not exist");
    }

    public void linkShouldExist(String text) {
        boolean isExistLink = driver.findElement(By.cssSelector(".integri-chat-message-attachment")).getText().contains(text);
        assertTrue(isExistLink, "Message with link don't have attachment");
    }

    public void clickEdit(int messageIndex) {
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();

    }

    public void clearTextMessage(int messageIndex) {
        driver.findElement(By.xpath("//div[@class =\"integri-chat-message \"]/textarea")).clear();
    }

    public void changeMessageText(int messageIndex, String text) {
        driver.findElement(By.xpath("//div[@class =\"integri-chat-message \"]/textarea")).sendKeys(text);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class =\"integri-chat-message \"]/textarea"),1));
    }

    public void errorMessageShouldExist(String error) {

      /* WebElement element =  driver.findElement(ERROR_MESSAGE);
       String error_1 = element.getText();
       error_1.contains(error);*/

        boolean isEqual = driver.findElement(ERROR_MESSAGE).getText().contains(error);
        assertTrue(isEqual, "Error message didn't appear");
    }

    public void clickDelete(int messageIndex) {
        driver.findElement(By.cssSelector(".integri-chat-remove-message")).click();
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }

    public void SendMoreThanTenMessages(String text, int number) {
        for (int i = 0; i < number - 1; i++) {
            writeText(text);
            clickSend();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".integri-chat-message-text"), i + 1));
        }
        writeText(text);
        clickSend();
    }

    public void checkWarningTrialPeriod() {
        driver.findElement(By.cssSelector(".integri-demo-version"));
    }

    public void clickInvite() {
        driver.findElement(By.id("invite-users-to-chat")).click();

    }

    public void checkCopiedLink() {
        try {
            String link = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            assertEquals(driver.getCurrentUrl(), link, "Link does not match current URL");
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
