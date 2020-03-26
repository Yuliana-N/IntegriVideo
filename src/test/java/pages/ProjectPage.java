package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertEquals;


public class ProjectPage extends BasePage {
    By addProject = By.cssSelector(".iv-icon-file-add");
    By clickCreate = By.xpath("//button[text() = 'Create']");
    private final static By PROJECT = By.cssSelector(".project");
    int numberOfProjects = 0;

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
        numberOfProjects = driver.findElements(PROJECT).size();
        driver.findElement(addProject).click();
        return this;
    }

    public ProjectPage addProject(String name, String description, String... domains) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.tagName("textarea")).sendKeys(description);
        //вписать в соответствующий веб элемент, соответствующий текст
        for (int i = 0; i < domains.length; i++) {
            driver.findElements(By.name("domains[]")).get(i).sendKeys(domains[i]);
        }
        return this;
    }
    public ProjectPage clickCreate() {
        driver.findElement(clickCreate).click();
        return this;
    }
    public ProjectPage checkAddedProject(){
        int numberOfProductsAfter = driver.findElements(PROJECT).size();
        assertEquals(numberOfProductsAfter,numberOfProjects + 1,"Project hasn't been added");

        return this;

    }
}
