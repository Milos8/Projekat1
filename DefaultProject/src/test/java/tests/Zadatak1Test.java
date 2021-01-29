package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.Zadatak1;
import pages.Zadatak2;

import java.util.List;

public class Zadatak1Test extends BaseTest {

    @Test public void zadatak1Test() throws InterruptedException
    {
        Zadatak1 noviZadatak = new Zadatak1(driver);
        noviZadatak.finalna();

        List<WebElement> results = noviZadatak.results;
        Assert.assertEquals("There is no 50 results on screen!", results.size(), 50);


        Thread.sleep(6000);
    }
    @Test public void zadatak2Test() throws InterruptedException
    {
        Zadatak2 sledeciZadatak = new Zadatak2(driver);
        sledeciZadatak.glavna();



        Thread.sleep(6000);
    }

}

