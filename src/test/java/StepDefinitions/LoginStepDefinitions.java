package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @When("the user enters correct username")
    public void the_user_enters_correct_username() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("the user enters correct password")
    public void the_user_enters_correct_password() {
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @Then("the user should be logged in sucessfully")
    public void the_user_should_be_logged_in_sucessfully() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }

    @When("the user enters wrong {string} and {string}")
    public void the_user_enters_wrong_username(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
