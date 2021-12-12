import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByChained;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

public class JobTitlePage {
    WebDriver driver;

    public JobTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "btnAdd")
    private WebElement buttonAdd;

    @FindBy(id = "btnDelete")
    private WebElement buttonDelete;

    @FindBy(id = "dialogDeleteBtn")
    private WebElement submitOK;


    public void clickAdd() {
        buttonAdd.click();
    }

    public void clickDelete() {
        buttonDelete.click();
    }

    public void submitOK() {
        submitOK.click();
    }

    public void openPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
    }

    public void clickJobTitle(String jobTitleName) {
        WebElement element2 = driver.findElement(By.linkText(jobTitleName));
        element2.click();
    }

    public void checkJobTitle(String jobTitleName) {
        System.out.println("happen");
        WebElement checkbox = driver.findElement(By.linkText(jobTitleName));
        String href = checkbox.getAttribute("href");
        System.out.println(href);
        String value =href.substring(href.indexOf('=')+1);

        checkbox = driver.findElement(By.xpath("//input[@value='"+value+"']"));
        checkbox.click();
    }
}
