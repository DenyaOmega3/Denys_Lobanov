import graphql.relay.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestNG_Demo extends WebDriverConfiguration {
    @Test(priority = 1)
    public void Login() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openPage();
        loginPage.fillUsername("Admin");
        loginPage.fillPassword("admin123");
        loginPage.submitForm();
    }

    @Test(priority = 2)
    public void addJob() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.openPage();
        homePage.clickJobTitle();

        JobTitlePage jobTitlePage = PageFactory.initElements(driver, JobTitlePage.class);
        jobTitlePage.clickAdd();

        JobTitleFormPage jobTitleFormPage = PageFactory.initElements(driver, JobTitleFormPage.class);
        jobTitleFormPage.fillJobTitle("Game developer");
        jobTitleFormPage.fillJobDescription("Unity 3D developer");
        jobTitleFormPage.fillNote(
                "If you have 1 year experience of Unity, capable of creating own scripts or assets, then welcome"
        );
        jobTitleFormPage.clickSave();
    }

    @Test(priority = 3)
    public void modifyJob() {
        JobTitlePage jobTitlePage = PageFactory.initElements(driver, JobTitlePage.class);
        jobTitlePage.openPage();
        jobTitlePage.clickJobTitle("Game developer");

        JobTitleFormPage jobTitleFormPage = PageFactory.initElements(driver, JobTitleFormPage.class);
        jobTitleFormPage.clickEdit();
        jobTitleFormPage.fillJobDescription(
                "New description"
        );
        jobTitleFormPage.clickSave();
    }

    @Test(priority = 4)
    public void removeJob() {
        JobTitlePage jobTitlePage = PageFactory.initElements(driver, JobTitlePage.class);
        jobTitlePage.openPage();
        jobTitlePage.checkJobTitle("Game developer");
        jobTitlePage.clickDelete();
        jobTitlePage.submitOK();
    }
}
