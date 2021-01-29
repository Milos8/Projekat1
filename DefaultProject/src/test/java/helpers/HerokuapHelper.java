package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HerokuapHelper extends BaseHelper
{
    public static void goToHerokuapLoginPage(String url)

    {
        driver.get(url);
    }
    public static void logIn(String username, String password)
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement logInButton = driver.findElement(By.className("radius"));
        logInButton.click();

    }

}

