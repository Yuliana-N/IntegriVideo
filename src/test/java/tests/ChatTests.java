package tests;

import org.testng.annotations.Test;
import pages.ChatPage;

public class ChatTests extends BaseTest {
    @Test
    public void sendMessage(){
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.messageShouldExist(1,"Text");

    }
    @Test
    public void checkInvite(){
        chatPage.clickInvite();
    }


}
