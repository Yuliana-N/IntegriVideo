package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileUploadModalTests extends BaseTest {
    String textFile = "TextFileIntegrivideo.txt";
    String textFile2 = "TextFileIntegrivideo_2.txt";

    private List<String> createCollection() {
        List<String> fileList = new ArrayList<String>();
        fileList.add(textFile);
        fileList.add(textFile2);
        return fileList;
    }

    @Test
    public void checkFileUpload() {
        chatPage.openPage();
        chatPage.isChatOpened();
        fileUploadModalPage.OpenDrugNDrop();
        fileUploadModalPage.UploadFile(File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "TextFileIntegrivideo.txt");
        fileUploadModalPage.ClickStart();
        fileUploadModalPage.CheckUploadFile(textFile);
    }

    @Test
    public void checkTwoFilesUpload() {
        chatPage.openPage();
        chatPage.isChatOpened();
        fileUploadModalPage.OpenDrugNDrop();
        fileUploadModalPage.UploadFile(File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "TextFileIntegrivideo.txt");
        fileUploadModalPage.UploadFile(File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "TextFileIntegrivideo_2.txt");
        fileUploadModalPage.ClickStart();
        fileUploadModalPage.CheckUploadFiles(createCollection());
    }
}