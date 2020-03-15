package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadModalPage extends BasePage {

    public FileUploadModalPage(WebDriver driver) {
        super(driver);
    }

    public void OpenDrugNDrop() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
    }

    public void UploadFile(String path) {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
    }

    public void ClickStart() {
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

    public void CheckUploadFile(String fileName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".integri-chat-message-attachment-file"))));
        boolean isEqualsFileName = driver.findElement(By.cssSelector(".integri-chat-message-attachment-file-name")).getText().contains(fileName);
            assertTrue( isEqualsFileName, "Upload error");
    }


    public void CheckUploadFiles(List<String> fileNames) {
        List<WebElement> message = driver.findElements(By.cssSelector(".integri-chat-message-attachment-file-name"));
        boolean isEquals;
        int coincidences = 0;
        for(int i = 0; i < message.size(); i++){
            for (int j = 0; j < fileNames.size(); j++)
            {
                String messageText = message.get(i).getText();
                String fileName = fileNames.get(j);
                isEquals = messageText.contains(fileName);

                if(isEquals)
                {
                    coincidences += 1;
                    break;
                }

            }
        }
        assertEquals(coincidences, fileNames.size(), "Not all files");
    }



}
