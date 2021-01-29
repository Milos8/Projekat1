package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ItalianFilterPage extends BaseHelper
{
    public String rezultatiSvihObjekata;
    public String numberOfItalianRestaurants;
    public List<WebElement> restaurantsList;
    public WebElement randomRestaurant;

    @FindBy(className="shops-listing-counter")
    WebElement kaunter;

    WebDriver driver;
    public ItalianFilterPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void counterSvi()
    {
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"),""));
        rezultatiSvihObjekata = kaunter.getText();
        System.out.println("Nasli smo: "+rezultatiSvihObjekata +" objekata ");

        WebElement italianKlik = driver.findElement(By.id("italijanska-hrana"));
        js.executeScript("arguments[0].click();",italianKlik);
        //js.executeScript("windows.scrollBy(0,300)"); - skrolovanje na dole.

        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"), rezultatiSvihObjekata));
        numberOfItalianRestaurants = kaunter.getText();
        System.out.println("Nasli smo: "+numberOfItalianRestaurants +" objekata sa italijanskom hranom ");

    }
    private void kreiranjeListe()
    {
        restaurantsList = driver.findElements(By.className("shops-listings-shops-list-item"));
    }

    public WebElement izaberiRandomRestoran()
    {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(116);
        System.out.println("Random Number:"+randomNumber);
        randomRestaurant=restaurantsList.get(randomNumber);
        return randomRestaurant;
    }
    public void itaHrana()
    {
        counterSvi();
        kreiranjeListe();
    }
}


