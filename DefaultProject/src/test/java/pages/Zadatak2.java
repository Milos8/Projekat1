package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Zadatak2 extends BaseHelper
{
    public WebElement polja;

    @FindBy (className = "table-control-filter")
    WebElement filter;

    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[3]/span/div/button")
    WebElement price;


    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[1]/span/span")
     WebElement prvi;
    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[2]/td[1]/span/span")
    WebElement drugi;
    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[3]/td[1]/span/span")
    WebElement treci;
    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[4]/td[1]/span/span")
    WebElement cetvrti;
    @FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[5]/td[1]/span/span")
    WebElement peti;


    WebDriver driver;
    public Zadatak2 (WebDriver driver)
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
    private void klikniNaFiltere()
    {
        filter.click();

    }
    private void klikNaCenu()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[3]/span/div/button")));
        price.click();

    }
    private void inputPolja() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tippy-35\"]/div/div[1]/div/div/div/div[1]/input[1]")));
        polja = driver.findElement(By.xpath("//*[@id=\"tippy-35\"]/div/div[1]/div/div/div/div[1]/input[1]"));
        polja.sendKeys("2000");
    }
    private void inputPolja2()
    {
       // wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tippy-89\"]/div/div[1]/div/div/div/div[1]/input[2]")));
        WebElement polja2 = driver.findElement(By.xpath("//*[@id=\"tippy-35\"]/div/div[1]/div/div/div/div[1]/input[2]"));
        polja2.sendKeys("99999");
    }
    private void apply()
    {
        WebElement potvrdi = driver.findElement(By.className("sc-1ejyco6-0"));
        potvrdi.click();
    }
    private void logInName()
    {
        WebElement milos = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/form/div[2]/input"));
        milos.sendKeys("milosh.king@gmail.com");
    }
    private void logInPassword()
    {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/form/div[5]/input"));
        password.sendKeys("WAU7890");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/main/form/button")));
        WebElement log = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/form/button"));
        log.click();
    }
    private void dodavanjeKriptoValuta()  {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[1]/span/span")));
        js.executeScript("arguments[0].click();",prvi);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[2]/td[1]/span/span")));
        js.executeScript("arguments[0].click();",drugi);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[3]/td[1]/span/span")));
        js.executeScript("arguments[0].click();",treci);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[4]/td[1]/span/span")));
        js.executeScript("arguments[0].click();",cetvrti);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/table/tbody/tr[5]/td[1]/span/span")));
        js.executeScript("arguments[0].click();",peti);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div[1]/a[1]/button")));
        WebElement watchlist = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div[1]/a[1]/button"));
        js.executeScript("arguments[0].click();",watchlist);

       /* wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/svg")));
        WebElement iks = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/svg"));
        js.executeScript("arguments[0].click();",iks);*/

    }


    public void glavna()
    {
        NavigateTo();
        clickOnKuki();
        klikniNaFiltere();
        klikNaCenu();
        inputPolja();
        inputPolja2();
        apply();
        logInName();
        logInPassword();
        dodavanjeKriptoValuta();
    }



}
