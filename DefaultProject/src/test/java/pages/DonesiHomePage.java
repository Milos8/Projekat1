package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DonesiHomePage extends BaseHelper
{
    @FindBy ( className ="form-control")
    WebElement  addressBox;
    @FindBy (className="btn-primary")
    WebElement naruciButton;

    WebDriver driver;
    public DonesiHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private void navigateToDonesiHomepage()
    {
        driver.get("https://www.donesi.com/");
    }
    private void  enterAddressInAddressBar(String address)
    {
        wdWait.until(ExpectedConditions.visibilityOf(addressBox));
        addressBox.sendKeys(address);
    }
    private void klikOnKuki()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/button")));
        WebElement kolacic = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/button"));
        kolacic.click();
    }
    private void  chooseAddress()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-form-component\"]/div[2]/div[1]/ul/li[1]/span[3]/span[2]")));
        WebElement biranaUlica = driver.findElement(By.xpath("//*[@id=\"address-form-component\"]/div[2]/div[1]/ul/li[1]/span[3]/span[2]"));
        biranaUlica.click();

    }
    private void  clickNaruciButton()
    {
        naruciButton.click();
    }
    private void clickNastaviButton()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("button-map-submit")));
        WebElement samoNastavi = driver.findElement(By.className("button-map-submit"));
        samoNastavi.click();

    }

    public void restaurantiFilter(String address)
    {
        navigateToDonesiHomepage();
        enterAddressInAddressBar(address);
        klikOnKuki();
        chooseAddress();
        clickNaruciButton();
        clickNastaviButton();

    }
}

