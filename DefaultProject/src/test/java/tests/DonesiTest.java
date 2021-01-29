package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DonesiHomePage;
import pages.ItalianFilterPage;
import pages.ItalianFilterPage2;

import java.util.List;

public class DonesiTest extends BaseTest
{
    @Test
    public void restaurantFilterTest() throws InterruptedException
    {
        DonesiHomePage homePage = new DonesiHomePage(driver);
        homePage.restaurantiFilter("Takovska 2");


        ItalianFilterPage restorani = new ItalianFilterPage(driver);
        restorani.itaHrana();


        int allRestaurants = Integer.parseInt(restorani.rezultatiSvihObjekata);
        int italianRestaurants = Integer.parseInt(restorani.numberOfItalianRestaurants);
        System.out.println("All int:"+allRestaurants+"  italian int:"+italianRestaurants);

        Assert.assertTrue("problem with filters...",italianRestaurants<allRestaurants);


       /* List<WebElement> restoraniLista = driver.findElements(By.className("shops-listing-shop-cover"));
        System.out.println("Broj restorana u listi: "+restoraniLista.size()); -Deklarisana je u ItalianFilterPage*/

        List<WebElement> restaurantsList= restorani.restaurantsList;
        System.out.println("");
        System.out.println("Duzina liste je:"+restaurantsList.size());


        Assert.assertTrue("Lista nije jednaka prikazanom broju", restaurantsList.size()==italianRestaurants);

        WebElement randomRestaurant = restorani.izaberiRandomRestoran();
        js.executeScript("arguments[0].scrollIntoView();",randomRestaurant);
        randomRestaurant.click();

        Thread.sleep(6000);
    }


    @Test public void drugiZadatak() throws InterruptedException
    {
        ItalianFilterPage2 restorani2 = new ItalianFilterPage2(driver);
        restorani2.naruciti();
        Thread.sleep(6000);

        WebElement randomJelo = restorani2.izaberiRandomJelo();
        js.executeScript("arguments[0].scrollIntoView();",randomJelo);
        js.executeScript("arguments[0].click();",randomJelo);

        ItalianFilterPage2 restorani3 = new ItalianFilterPage2(driver);
        restorani3.glavna();

        WebElement izabranoMealIme = driver.findElement(By.className("cart-product-list-item-name"));
        System.out.println("Ime jela:" + izabranoMealIme.getText());

        WebElement izabranoMealCena = driver.findElement(By.className("cart-product-list-item-price"));
        System.out.println("Cena dve porcije izabranog jela:" + izabranoMealCena.getText());



        Thread.sleep(4000);
    }
}
