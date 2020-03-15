package tests;

import org.testng.annotations.Test;

public class SettingsModalTests extends BaseTest{

    String name = "Yuliana";
    String email = "yu@tut.by";
    String photoURL = "http://developer.alexanderklimov.ru/blocks/header-cat.png";
    @Test
    public void RenameName(){
        chatPage.openPage();
        chatPage.isChatOpened();
        settingsModalPage.openSettingsModal();
        settingsModalPage.isSettingsModalOpened();
        settingsModalPage.writeName(name);
        settingsModalPage.clickSave();
        settingsModalPage.isSettingsModalClosed();
        settingsModalPage.checkNameRenamed(name);
    }
    @Test
    public void RenameEmail(){
        chatPage.openPage();
        chatPage.isChatOpened();
        settingsModalPage.openSettingsModal();
        settingsModalPage.isSettingsModalOpened();
        settingsModalPage.writeEmail(email);
        settingsModalPage.clickSave();
        settingsModalPage.isSettingsModalClosed();
//        settingsModalPage.checkEmailRenamed(email);
    }

    @Test
    public void ChangePhotoURL(){
        chatPage.openPage();
        chatPage.isChatOpened();
        settingsModalPage.openSettingsModal();
        settingsModalPage.isSettingsModalOpened();
        settingsModalPage.setPhotoURL(photoURL);
        settingsModalPage.clickSave();
        settingsModalPage.isSettingsModalClosed();
        settingsModalPage.checkPhotoChanged(photoURL);
    }
}
