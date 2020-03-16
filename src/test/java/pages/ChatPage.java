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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {
    private final static By SEND_BUTTON = By.cssSelector(".integri-chat-send-message");
    private final static By EDIT_BUTTON = By.cssSelector(".integri-chat-edit-message");
    private final static By DELETE_BUTTON = By.cssSelector(".integri-chat-remove-message");
    private final static By INVITE_USER_BUTTON = By.id("invite-users-to-chat");
    private final static By CHAT_TEXTAREA = By.cssSelector("textarea");
    private final static By ERROR_MESSAGE = By.cssSelector(".integri-notify-error");
    private final static By TEXT_IN_MESSAGE = By.cssSelector(".integri-chat-message-text");
    private final static By ATTACHMENT_IN_MESSAGE = By.cssSelector(".integri-chat-message-attachment");
    private final static By EDIT_AREA = By.xpath("//div[@class =\"integri-chat-message \"]/textarea");
    private final static By DEMO = By.cssSelector(".integri-demo-version");


    public ChatPage(WebDriver driver) {
        super(driver);
    }

    public ChatPage openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        return this;
    }

    public BasePage isPageOpened() {
        return null;
    }

    public void isChatOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHAT_TEXTAREA));
    }

    public void writeText(String text) {
        driver.findElement(CHAT_TEXTAREA).sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(SEND_BUTTON).click();
    }

    public void clickEnter() {
        driver.findElement(CHAT_TEXTAREA).sendKeys(Keys.ENTER);
    }

    public void messageShouldExist(String text) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), '" + text + "')]"))));
        WebElement message = driver.findElement(TEXT_IN_MESSAGE);
        String mes = message.getText();
        boolean isExist = message.getText().contains(text);
        assertTrue(isExist, "Message do not exist");

    }

    public void linkShouldExist(String text) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), '" + text + "')]"))));
        WebElement message = driver.findElement(TEXT_IN_MESSAGE);
        String mes = message.getText();
        boolean isExist = message.getText().contains(text);
        assertTrue(isExist, "Message do not exist");

    }

    public void linkShouldExistAttachment(String text) {
        boolean isExistLink = driver.findElement(ATTACHMENT_IN_MESSAGE).getText().contains(text);
        assertTrue(isExistLink, "Message with link don't have attachment");
    }

    public void clickEdit() {
        driver.findElement(EDIT_BUTTON).click();
    }

    public void clearTextMessage() {
        driver.findElement(EDIT_AREA).clear();
    }

    public void changeMessageText(String text) {
        driver.findElement(EDIT_AREA).sendKeys(text);
    }

    public void errorMessageShouldExist(String error) {

      /* WebElement element =  driver.findElement(ERROR_MESSAGE);
       String error_1 = element.getText();
       error_1.contains(error);*/

        boolean isEqual = driver.findElement(ERROR_MESSAGE).getText().contains(error);
        assertTrue(isEqual, "Error message didn't appear");
    }

    public void clickDelete() {
        driver.findElement(DELETE_BUTTON).click();
    }

    public void confirmAlert() {
        driver.switchTo().alert().accept();
    }

    public void SendMoreThanTenMessages(String text, int number) {
        for (int i = 0; i < number - 1; i++) {
            writeText(text);
            clickSend();
            wait.until(ExpectedConditions.numberOfElementsToBe(TEXT_IN_MESSAGE, i + 1));
        }
        writeText(text);
        clickSend();
    }

    public void checkWarningTrialPeriod() {
        driver.findElement(DEMO);
    }

    public void clickInvite() {
        driver.findElement(INVITE_USER_BUTTON).click();

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
