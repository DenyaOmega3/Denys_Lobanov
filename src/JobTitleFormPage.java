import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobTitleFormPage {
    WebDriver driver;

    public JobTitleFormPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "jobTitle_jobTitle")
    private WebElement formJobTitle;

    @FindBy(id = "jobTitle_jobDescription")
    private WebElement formJobDescription;

    @FindBy(id = "jobTitle_note")
    private WebElement formNote;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement buttonSave;

    @FindBy(xpath = "//input[@value='Edit']")
    private WebElement buttonEdit;

    public void fillJobTitle(String jobTitle) {
        formJobTitle.sendKeys(jobTitle);
    }

    public void fillJobDescription(String jobDescription) {
        formJobDescription.sendKeys(jobDescription);
    }

    public void fillNote (String note) {
        formNote.sendKeys(note);
    }

    public void clickSave() {
        buttonSave.click();
    }

    public void clickEdit() {
        System.out.println("happens");
        buttonEdit.click();
    }

    public void openPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/saveJobTitle");
    }
}
