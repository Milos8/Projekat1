package tests;

import helpers.BlicHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BlicHomePage;

import static java.lang.Thread.*;

public class BlicTest extends BaseTest
{
    @Test
    public void blicSearchTest() throws InterruptedException
    {
        BlicHelper.navigateToBlicHomePage("http://www.blic.rs");
        String term = "ComTrade";
        BlicHelper.blicSearch(term);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search__results")));
        WebElement results = driver.findElement(By.className("search__results"));
        Assert.assertTrue(results.getText().contains(term));
        Thread.sleep(6000);

    }

    @Test
    public void blicSearchPOMTest() throws InterruptedException {

        String term = "ComTrade";
        BlicHomePage homePage = new BlicHomePage(driver);
        homePage.blicSearch(term);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("search__results")));
        WebElement results = driver.findElement(By.className("search__results"));
        Assert.assertTrue(results.getText().contains(term));
        Thread.sleep(6000);


    }
}
