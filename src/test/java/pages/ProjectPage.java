package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {
    By addProject = By.cssSelector(".iv-icon-file-add");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public BasePage openPage() {
        return null;
    }

    public ProjectPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProject));
        return this;
    }

    public ProjectPage clickAddProject() {
        driver.findElement(addProject).click();
        return this;
    }

    public void addProject(String name, String description, String... domains) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("textarea")).sendKeys(description);
        //вписать в соответствующий веб элемент, соответствующий текст
        for (int i = 0; i < domains.length; i++) {
            driver.findElements(By.name("domains[]")).get(i).sendKeys(domains[i]);
        }
        driver.findElement(By.xpath("//button[text() = 'Create']")).click();
    }
}
