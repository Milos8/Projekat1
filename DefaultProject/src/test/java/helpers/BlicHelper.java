package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHelper extends BaseHelper
{
    public static void navigateToBlicHomePage(String url)
    {
        driver.get(url);

    }
    private static void clickOnMagnifierIcon()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-search")));
        WebElement lupa = driver.findElement(By.className("fa-search"));
        lupa.click();
    }
    private static void enterTermInSearchBox(String term)
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(term);

    }
    private static void clickOnMagnifierButtonTrazi()
    {
       wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-angle-double-right")));
        WebElement trazi = driver.findElement(By.className("fa-angle-double-right"));
        trazi.click();
    }
    public static void blicSearch(String term)
    {
        clickOnMagnifierIcon();
        enterTermInSearchBox(term);
        clickOnMagnifierButtonTrazi();

    }
}

