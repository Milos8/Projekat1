package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DonesiHomePage;
import pages.KlasaHomePage;
import pages.MapPage;

public class VeksTest extends BaseTest
{
    String address="Beogradska 10";

    @Test
    public void donesiComFiltertest() throws InterruptedException
    {
        KlasaHomePage homepage = new KlasaHomePage(driver);
        homepage.donesiComFilter(address);

        MapPage map = new MapPage(driver);
        map.continueFromMap();

        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"),""));
        WebElement restaurantCounter = driver.findElement(By.className("shops-listing-counter"));
        System.out.println("Number of restaurants:"+restaurantCounter.getText());

        WebElement italianFoodCheckbox = driver.findElement(By.id("italijanska-hrana"));
        js.executeScript("arguments[0].click();",italianFoodCheckbox);

        String numberOfAllRestaurants = restaurantCounter.getText();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"),numberOfAllRestaurants));
        String numberOfItalianRestaurants = restaurantCounter.getText();
        System.out.println("Number of italian restaurants:"+numberOfItalianRestaurants);

        int allRestaurants = Integer.parseInt(numberOfAllRestaurants);
        int italianRestaurants = Integer.parseInt(numberOfItalianRestaurants);
        System.out.println("All int:"+allRestaurants+"  italian int:"+italianRestaurants);

        Assert.assertTrue("Nije veci broj Italijana",italianRestaurants<allRestaurants);
        Thread.sleep(4000);

    }
}