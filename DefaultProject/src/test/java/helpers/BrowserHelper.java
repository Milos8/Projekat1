package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserHelper extends BaseHelper
{
    public static void googleSearch()
    {
        driver.get("https://www.google.com/");// Idi na Google homepage. //driver.get uzima iz Seleniuma.
        WebElement SearchBox = driver.findElement(By.name("q")); //ucukaj Comtrade u search box. //definisanje WebElementa i trazenje njegovog "name" u inspect-u.
        SearchBox.sendKeys("Comtrade"); //sendKeys-nova metoda za ucukavanje texta sa tastature u nas search Box.
        WebElement SearchButton = driver.findElement(By.name("btnK"));
        wdWait.until(ExpectedConditions.elementToBeClickable(SearchButton)); //da saceka da se padajuca lista koja je izasla pri ukucavanju comtrade vrati jer se dugme google pretraga pomerilo i zato jetest pao.
        SearchButton.click(); //posle ukucanog Comtrade texta da se klikne sa google search.
    }
}
