package pages;

import helpers.BaseHelper;
import org.apache.log4j.pattern.ClassNamePatternConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ItalianFilterPage2 extends BaseHelper
{
    public List<WebElement> listaKlope;
    public WebElement randomJelo;



    WebDriver driver;
    public ItalianFilterPage2 (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void idiNaStranicu()
        {
            driver.get("https://www.donesi.com/dostava/beograd/stari-grad/moon-sushi-bar");

        }
    private void klikniNaKuki()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[1]/button")));
        WebElement kolac = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/button"));
        js.executeScript("arguments[0].click();",kolac);

    }
    private void kreirajListu()
    {
        listaKlope = driver.findElements(By.className("shop-profile-menu-list-item"));
        System.out.println("Lista ponudjenih jela:"+listaKlope.size());

    }
    public WebElement izaberiRandomJelo()
    {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(104);
        System.out.println("Random Number:"+randomNumber);
        randomJelo=listaKlope.get(randomNumber);
        return randomJelo;


    }

    public void naruciti()
    {
        idiNaStranicu();
        klikniNaKuki();
        kreirajListu();
    }
    private void povecaj()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("increase-quantity")));
        WebElement uvecati = driver.findElement(By.className("increase-quantity"));
        uvecati.click();
    }

    private void naruci()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("button-primary")));
        WebElement buttonNaruci = driver.findElement(By.className("button-primary"));
        buttonNaruci.click();
    }

    public void glavna()
    {
        povecaj();
        naruci();
    }

}
