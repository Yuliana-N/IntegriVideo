package tests;

import org.testng.annotations.Test;

public class ChatTests extends BaseTest {
    @Test
    public void sendMessageByClick() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "Text");
    }

    @Test
    public void sendMessageByEnter() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Text");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "Text");
    }

    @Test
    public void sendLongMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ligula est, ultrices sodales mi eu, accumsan efficitur nisl. Mauris rutrum magna id justo malesuada, nec dapibus est faucibus. In hac habitasse platea dictumst. Suspendisse velit ligula, fermentum sit amet erat ut, fringilla dapibus leo. Integer sagittis nibh lectus, commodo convallis lorem facilisis id. Suspendisse sit amet mollis est, sed condimentum sapien. Suspendisse semper, libero et egestas tempor, odio enim rutrum massa, sit amet posuere nisl mi venenatis eros. Nulla commodo, risus id pulvinar suscipit, odio enim tristique magna, eget dapibus tortor libero vitae ante. Donec enim turpis, malesuada eget viverra a, convallis eu ante. Donec dolor elit, consectetur sed felis ac, euismod pellentesque nunc. Praesent posuere risus quis pellentesque placerat. Quisque enim ante, luctus eu lectus eu, hendrerit congue massa. Curabitur diam arcu, pellentesque eget velit et, porta suscipit erat. Vivamus semper cursus rutrum.12");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ligula est, ultrices sodales mi eu, accumsan efficitur nisl. Mauris rutrum magna id justo malesuada, nec dapibus est faucibus. In hac habitasse platea dictumst. Suspendisse velit ligula, fermentum sit amet erat ut, fringilla dapibus leo. Integer sagittis nibh lectus, commodo convallis lorem facilisis id. Suspendisse sit amet mollis est, sed condimentum sapien. Suspendisse semper, libero et egestas tempor, odio enim rutrum massa, sit amet posuere nisl mi venenatis eros. Nulla commodo, risus id pulvinar suscipit, odio enim tristique magna, eget dapibus tortor libero vitae ante. Donec enim turpis, malesuada eget viverra a, convallis eu ante. Donec dolor elit, consectetur sed felis ac, euismod pellentesque nunc. Praesent posuere risus quis pellentesque placerat. Quisque enim ante, luctus eu lectus eu, hendrerit congue massa. Curabitur diam arcu, pellentesque eget velit et, porta suscipit erat. Vivamus semper cursus rutrum.12");
    }

    @Test
    public void sendLink() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("http://onliner.by");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "http://onliner.by");
        chatPage.linkShouldExist("Onliner посещают сотни тысяч белорусов, чтобы покупать в каталоге, размещать объявления, общаться на форуме, а также читать новости и статьи!");
    }

    @Test
    public void sendHTMLcode() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("<html><body><p>test</p></body></html>");
        chatPage.clickEnter();
        chatPage.messageShouldExist(1, "<html><body><p>test</p></body></html>");
    }

    @Test
    public void editMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Hello");
        chatPage.clickEnter();
        chatPage.clickEdit(1);
        chatPage.changeTextMessage(1,"GoodBuy");
        chatPage.messageShouldExist(1, "GoodBuy");
    }

    @Test //done
    public void clearMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Hello");
        chatPage.clickEnter();
        chatPage.clickEdit(1);
        chatPage.clearTextMessage(1);
        chatPage.clickEnter();
        chatPage.errorMessageShouldExist("Message cannot be empty!");
    }

    @Test //done
    public void deleteMessage() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.writeText("Hello");
        chatPage.clickEnter();
        chatPage.clickDelete(1);
        chatPage.confirmAlert();
        chatPage.messageShouldExist(1, "removed...");
    }

    @Test //do not done
    public void checkElevenMessages() {
        chatPage.openPage();
        chatPage.isChatOpened();
        chatPage.SendMoreThanTenMessages("Hello", 11);
        chatPage.checkWarningTrialPeriod();
    }

    @Test
    public void checkInvite() {
        chatPage.openPage();
        chatPage.clickInvite();
        chatPage.checkCopiedLink();
    }
}
