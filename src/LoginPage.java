import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "txtUsername")
    private WebElement usernameForm;

    @FindBy(id = "txtPassword")
    private WebElement passwordForm;

    @FindBy(id = "btnLogin")
    private WebElement submitButton;

    public void openPage() {
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    public void fillUsername(String username) {
        usernameForm.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordForm.sendKeys(password);
    }

    public void submitForm() {
        submitButton.click();
    }
}
