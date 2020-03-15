package tests;

import org.testng.annotations.Test;

public class ChatTests extends BaseTest {
    private String longMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ligula est, ultrices sodales mi eu, accumsan efficitur nisl. Mauris rutrum magna id justo malesuada, nec dapibus est faucibus. In hac habitasse platea dictumst. Suspendisse velit ligula, fermentum sit amet erat ut, fringilla dapibus leo. Integer sagittis nibh lectus, commodo convallis lorem facilisis id. Suspendisse sit amet mollis est, sed condimentum sapien. Suspendisse semper, libero et egestas tempor, odio enim rutrum massa, sit amet posuere nisl mi venenatis eros. Nulla commodo, risus id pulvinar suscipit, odio enim tristique magna, eget dapibus tortor libero vitae ante. Donec enim turpis, malesuada eget viverra a, convallis eu ante. Donec dolor elit, consectetur sed felis ac, euismod pellentesque nunc. Praesent posuere risus quis pellentesque placerat. Quisque enim ante, luctus eu lectus eu, hendrerit congue massa. Curabitur diam arcu, pellentesque eget velit et, porta suscipit erat. Vivamus semper cursus rutrum.12";
    private String link = "http://onliner.by";
    private String siteDescription = "Onliner посещают сотни тысяч белорусов, чтобы покупать в каталоге, размещать объявления, общаться на форуме, а также читать новости и статьи!";
    private String htmlCode  = "<html><body><p>test</p></body></html>";
    private String textMessage  = "Text";

    @Test // done
    public void sendMessageByClick() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(textMessage);
        chatPage.clickSend();
        chatPage.messageShouldExist(textMessage);
    }

    @Test //done
    public void sendMessageByEnter() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(textMessage);
        chatPage.clickEnter();
        chatPage.messageShouldExist(textMessage);
    }

    @Test //done
    public void sendLongMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(longMessage);
        chatPage.clickEnter();
        chatPage.messageShouldExist(longMessage);
    }

    @Test // done
    public void sendLink() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(link);
        chatPage.clickEnter();
        chatPage.messageShouldExist(link);
        chatPage.linkShouldExist(siteDescription);
    }

    @Test //done
    public void sendHTMLcode() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(htmlCode);
        chatPage.clickEnter();
        chatPage.messageShouldExist( htmlCode);
    }

    @Test //do not done
    public void editMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(textMessage);
        chatPage.clickEnter();
        chatPage.clickEdit();
        chatPage.clearTextMessage();
        chatPage.changeMessageText(textMessage + "change");
        chatPage.clickEnter();
        chatPage.messageShouldExist(textMessage + "change");
    }

    @Test //done
    public void clearMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(textMessage);
        chatPage.clickEnter();
        chatPage.clickEdit();
        chatPage.clearTextMessage();
        chatPage.clickEnter();
        chatPage.errorMessageShouldExist("Message cannot be empty!");
    }

    @Test //done
    public void deleteMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText(textMessage);
        chatPage.clickEnter();
        chatPage.clickDelete();
        chatPage.confirmAlert();
        chatPage.messageShouldExist( "removed...");
    }

    @Test //do not done
    public void checkElevenMessages() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.SendMoreThanTenMessages(textMessage, 11);
        chatPage.checkWarningTrialPeriod();
    }

    @Test
    public void checkInvite() {
        chatPage.openPage();
        chatPage.clickInvite();
        chatPage.checkCopiedLink();
    }
}
