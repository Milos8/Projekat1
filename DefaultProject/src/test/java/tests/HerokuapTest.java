package tests;

import helpers.HerokuapHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HerokuapTest extends BaseTest
{
    @Test
    public  void positiveLogIn() throws InterruptedException
    {
        HerokuapHelper.goToHerokuapLoginPage("https://the-internet.herokuapp.com/login");
        HerokuapHelper.logIn("tomsmith" ,"SuperSecretPassword!");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        WebElement poruka = driver.findElement(By.id("flash-messages"));
        Assert.assertTrue(poruka.getText().contains("You logged into a secure area!"));
        WebElement button = driver.findElement(By.className("button"));
        Assert.assertTrue(button.isDisplayed());
        Thread.sleep(4000);


}
    @Test
    public  void badUsernameLogIn()
    {
        HerokuapHelper.goToHerokuapLoginPage("https://the-internet.herokuapp.com/login");
        HerokuapHelper.logIn("skm" ,"SuperSecretPassword!");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));
        WebElement nporuka = driver.findElement(By.id("flash-messages"));
        Assert.assertTrue(nporuka.getText().contains("Your username is invalid!"));




    }

}
