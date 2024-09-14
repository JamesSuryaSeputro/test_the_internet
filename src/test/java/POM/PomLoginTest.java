package POM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PomLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdrive.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginSuccessTest() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickSubmitButton();
        Assertions.assertTrue(loginPage.isLoginSuccess());
    }

    @Test
    public void loginFailureTest() {
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("abcde");
        loginPage.clickSubmitButton();
        Assertions.assertTrue(loginPage.isLoginError());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
