package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private WebDriver driver;

   private By usernameField = By.id("username");
   private By passwordField = By.id("password");
   private By submitButton = By.cssSelector("button[type='submit']");
   private By successFlash = By.cssSelector(".flash.success");
   private By errorFlash = By.cssSelector(".flash.error");

   public LoginPage(WebDriver driver) {
       this.driver = driver;
   }

   public void enterUsername(String username){
       driver.findElement(usernameField).sendKeys(username);
   }

   public void enterPassword(String password){
       driver.findElement(passwordField).sendKeys(password);
   }

   public void clickSubmitButton(){
       driver.findElement(submitButton).click();
   }

   public boolean isLoginSuccess(){
       return driver.findElement(successFlash).isDisplayed();
   }

   public boolean isLoginError(){
       return driver.findElement(errorFlash).isDisplayed();
   }
}
