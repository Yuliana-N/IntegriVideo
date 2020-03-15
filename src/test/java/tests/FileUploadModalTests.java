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
        fileUploadModalPage.UploadFile("D:\\work2\\TechMe\\Testing\\IntegriVideo_\\src\\main\\resources\\TextFileIntegrivideo.txt");
        fileUploadModalPage.ClickStart();
        fileUploadModalPage.CheckUploadFile(textFile);
    }

    @Test
    public void checkTwoFilesUpload() {
        chatPage.openPage();
        chatPage.isChatOpened();
        fileUploadModalPage.OpenDrugNDrop();
        fileUploadModalPage.UploadFile("D:\\work2\\TechMe\\Testing\\IntegriVideo_\\src\\main\\resources\\TextFileIntegrivideo.txt");
        fileUploadModalPage.UploadFile("D:\\work2\\TechMe\\Testing\\IntegriVideo_\\src\\main\\resources\\TextFileIntegrivideo_2.txt");
        fileUploadModalPage.ClickStart();
        fileUploadModalPage.CheckUploadFiles(createCollection());
    }
}