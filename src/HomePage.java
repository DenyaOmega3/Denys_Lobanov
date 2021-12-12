import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    Actions onDoing;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.onDoing = new Actions(driver);
    }

    @FindBy(className = "main-menu-first-level-list-item")
    private WebElement buttonAdmin;

    @FindBy(id = "menu_admin_Job")
    private WebElement textJob;

    @FindBy(id = "menu_admin_viewJobTitleList")
    private WebElement buttonJobTitle;


    public void hoverAdmin() {
        onDoing.moveToElement(buttonAdmin);
    }

    public void hoverJob() {
        onDoing.moveToElement(textJob);
    }

    public void clickJobTitle() {
        hoverAdmin();
        hoverJob();
        onDoing.moveToElement(buttonJobTitle).click().perform();
    }

    public void openPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }
}
