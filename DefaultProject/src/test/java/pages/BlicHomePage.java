package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlicHomePage extends BaseHelper
{
    @FindBy (className = "fa-search")
    WebElement lupa;

    WebDriver driver;
    public BlicHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private  void navigateToBlicHomePage()
    {
        driver.get("http://www.blic.rs");

    }
    private  void clickOnMagnifierIcon()
    {
        wdWait.until(ExpectedConditions.visibilityOf(lupa));
        lupa.click();
    }
    private void enterTermInSearchBox(String term)
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(term);

    }
    private  void clickOnMagnifierButtonTrazi()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-angle-double-right")));
        WebElement trazi = driver.findElement(By.className("fa-angle-double-right"));
        trazi.click();
    }
    public  void blicSearch(String term)
    {
        navigateToBlicHomePage();
        clickOnMagnifierIcon();
        enterTermInSearchBox(term);
        clickOnMagnifierButtonTrazi();

    }

}
