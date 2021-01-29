package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Zadatak1 extends BaseHelper {

    public List<WebElement> results;

    @FindBy ( xpath ="//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div[2]/div/div")
    WebElement  lista50;

    WebDriver driver;
    public Zadatak1 (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void NavigateTo()
    {
        driver.get("https://coinmarketcap.com/");

    }
    private void clickOnKuki()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.className("cmc-button-plain")));
        WebElement kuki = driver.findElement(By.className("cmc-button-plain"));
        js.executeScript("arguments[0].click();",kuki);

    }
    private void showRows()
    {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div[2]/div/div")));
        lista50.click();

    }
    private void klik50()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tippy-2\"]/div/div[1]/div/div/button[2]")));
        WebElement itemUlisti = driver.findElement(By.xpath("//*[@id=\"tippy-2\"]/div/div[1]/div/div/button[2]"));
        js.executeScript("arguments[0].click();",itemUlisti);
    }
    private void kreirajListu()
    {

        WebElement table = driver.findElement(By.className("cmc-table"));
        WebElement body = table.findElement(By.tagName("tbody"));
        results = body.findElements(By.tagName("tr"));
        System.out.println("Lista kripto valuta:" +results.size());
        results.removeIf(p -> p.getAttribute("class").contains("sc-15ks4ej-1 fENxkl"));
        System.out.println("Lista kripto valuta bez reklame:" +results.size());




    }
        public void finalna()
    {
        NavigateTo();
        clickOnKuki();
        showRows();
        klik50();
        kreirajListu();

    }
}


