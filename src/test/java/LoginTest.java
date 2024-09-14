import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginSuccessTest(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }

    @Test
    public void loginFailureTest(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("abcde");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
    }

    @Test
    public void loginTextFieldInputTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("Test");
        String username = usernameField.getAttribute("value");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(username.length() >= 6, "Username must be at least 6 characters");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
