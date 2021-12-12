import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverConfiguration {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setupTest() {
        String projectPath = "C:\\Users\\Denya_Alpha\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", projectPath);
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
        System.out.println("Test done");
    }
}
