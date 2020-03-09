package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddProject(){
        driver.findElement(By.cssSelector(".iv-icon-file-add")).click();
    }
    public void addProject(){
        driver.findElement(By.name("name")).sendKeys("onliner");
        driver.findElement(By.name("domains[]")).sendKeys("https://onliner.by");
        driver.findElement(By.xpath("//button[text()='Create']")).click();
    }
}
