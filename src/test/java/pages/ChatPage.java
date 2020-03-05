package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

   public ChatPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }
    public void writeText(String text){
        driver.findElement(CHAT_TEXTAREA).sendKeys(text);
    }
    public void clickSend() {
        driver.findElement(CHAT_INPUT).click();
    }
    public void clickEnter() {
        driver.findElement(CHAT_TEXTAREA).sendKeys(Keys.ENTER);
    }
    public void messageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> message = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = message.get(messageIndex -1).getText().equals(text);
        assertTrue(isExist, "Message do not exist");
    }
    public void clickInvite(){
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
