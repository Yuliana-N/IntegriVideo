package tests;

import org.testng.annotations.Test;
import pages.ChatPage;

public class ChatTests extends BaseTest {
    @Test
    public void sendMessageByClick(){
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.messageShouldExist(1,"Text");
    }
    @Test
    public void sendMessageByEnter(){
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1,"Text");
    }
    @Test
    public void checkInvite(){
        chatPage.openPage();
        chatPage.clickInvite();
    }


}
