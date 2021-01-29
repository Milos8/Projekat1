package tests;

import com.sun.org.apache.xml.internal.security.utils.IgnoreAllErrorHandler;
import helpers.BrowserHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest extends BaseTest   //jedna klasa poziva drugu BaseTest klasu.

{
    @Test               //Ubacujemo Metodu iz Junit-a za prepoznavanje testne metode ispod od strane sistema.
    public void googleSearchTest() throws InterruptedException
    {
        BrowserHelper.googleSearch();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("rcnt")));//kad se promeni izgled stranice mora wdWait da nam ne bi pucao test bez potrebe jer ce se pre izvrsiti test nekad nego sto ce se stranica otvoriti...
        WebElement results = driver.findElement(By.id("rcnt"));
        //System.out.println(results.getText()); izlistace nam u Log-u dole sav text sa pretrage.
        Assert.assertTrue(results.getText().contains("Comtrade"));//proveravamo da li u nasem elementu results se sadrzi trazeni text "Comtrade".
        //metoda getText() pokupi sav text sa stranice i izlista ga a contains proverava da li sadrzi trazenu rec.
        Thread.sleep(6000);         //da produzi vreme testa i zadrzavanja Chrome prozora da bi videli sta se desava.
        //System.out.println("ovo je moj srecan broj-->"+8);      //ispisuje string u log-u.

    }
    @Test               //GIGATRON
            public void LoginPageTest() throws InterruptedException
    {
        driver.get("https://gigatron.rs/login");
        WebElement ButtonCookie = driver.findElement(By.xpath("//*[@id=\"gdpr-cookie-settings\"]/div[2]/button"));
        ButtonCookie.click();

        WebElement EmailField = driver.findElement(By.id("email"));
        EmailField.sendKeys("milos18813@its.edu.rs");

        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("Ameba123");
        Thread.sleep(6000);

        //Assert.assertTrue(results.getText().contains("milos18813@its.edu.rs"));
        //Assert.assertTrue(results.getText().contains("Ameba123"));
        WebElement Prijava = driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]"));
        Prijava.click();

        Thread.sleep(6000);



    }
    @Test
            public void LoginHeroPageTest() throws InterruptedException
    {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("tomsmith");

        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("SuperSecretPassword!");
        Thread.sleep(4000);

        WebElement LoginButton = driver.findElement(By.className("radius"));
        LoginButton.click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));//button, ono dugme sto se pojavi na kraju za vracanje (nova stranica) ,logged in.
        WebElement poruka = driver.findElement(By.id("flash"));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("icon-signout")));
        WebElement logout = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue(logout.isDisplayed());       //proverava da li je prikazano ili ne
        Assert.assertTrue(poruka.getText().contains("You logged into a secure area!"));

        Thread.sleep(4000);



        /*String actualUrl = "https://the-internet.herokuapp.com/secure";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);*/

    }

    @Test
    public void LoginHeroPageInvalidKeysTest() throws InterruptedException
    {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("skm");

        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("SuperSecretPassword!");
        Thread.sleep(4000);

        WebElement LoginButton = driver.findElement(By.className("radius"));
        LoginButton.click();


        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement results = driver.findElement(By.id("flash"));
        Assert.assertTrue(results.getText().contains("Your username is invalid! "));


        Thread.sleep(4000);

    }
}

