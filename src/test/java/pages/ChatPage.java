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
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector(".integri-chat-send-message");
    private final static By CHAT_TEXTAREA = By.cssSelector("textarea");

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-message-container")));
        List<WebElement> message = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = message.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message do not exist");
    }

    public void linkShouldExist(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-message-attachment-link")));
        boolean isExistLink = driver.findElement(By.xpath("//div[@class=\"integri-chat-message-attachment integri-chat-message-attachment-link\"]")).getText().contains(text);
        assertTrue(isExistLink, "Message do not exist");
    }

    public void clickEdit(int messageIndex) {
        List<WebElement> iconEdit = driver.findElements(By.cssSelector(".integri-chat-edit-message"));
        iconEdit.get(messageIndex-1).click();
    }
    public void changeTextMessage(int messageIndex, String text) {
        List<WebElement> messageEdit = driver.findElements(By.xpath("//div[@class =\"integri-chat-message \"]/textarea"));
        messageEdit.get(messageIndex-1).clear();
        messageEdit.get(messageIndex-1).sendKeys(text);
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class =\"integri-chat-message \"]/textarea"), text));
        clickEnter();
    }

    public void SendElevenMessages(String text) {
        for (int i = 0; i < 11; i++) {
            writeText(text);
            wait.until(ExpectedConditions.textToBe(CHAT_TEXTAREA, text));
            clickSend();
        }
    }

    public void clickInvite() {
        driver.findElement(By.id("invite-users-to-chat")).click();
        try {
            String link = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            assertEquals(driver.getCurrentUrl(),link,"Link does not match current URL");
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
