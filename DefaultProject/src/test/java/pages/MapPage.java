package pages;


import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MapPage extends BaseHelper
{
    @FindBy(id="address-confirm-component")
    WebElement map;
    @FindBy (id="address-confirm-form-city")
    WebElement mapCity;
    @FindBy (id="address-confirm-form-area")
    WebElement mapRegion;
    @FindBy (id="address-confirm-form-street")
    WebElement mapAddress;
    @FindBy (id="address-confirm-form-street-number")
    WebElement mapNumber;
    @FindBy (id="address-confirm-form-zip")
    WebElement mapZipCode;
    @FindBy (className = "button-map-submit")
    WebElement submitMapButton;

    WebDriver driver;
    public MapPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void waitMapForShowsUp()
    {
        wdWait.until(ExpectedConditions.visibilityOf(map));
        System.out.println("");
        System.out.println("Map data");
        System.out.println("------------");
    }

    private void printCity()
    {
        System.out.println("City:"+mapCity.getText());
    }

    private void printRegion()
    {
        System.out.println("Region:"+mapRegion.getText());
    }

    private void printAddress()
    {
        System.out.println("Address:"+mapAddress.getAttribute("value"));
    }

    private void printNumber()
    {
        System.out.println("Number:"+mapNumber.getAttribute("value"));
    }

    private void printZipCode()
    {
        System.out.println("ZipCode:"+mapZipCode.getAttribute("value"));
        System.out.println("");
    }

    private void clickOnSubmitMapButton()
    {
        wdWait.until(ExpectedConditions.visibilityOf(submitMapButton));
        submitMapButton.click();
    }

    public void continueFromMap()
    {
        waitMapForShowsUp();
        printCity();
        printRegion();
        printAddress();
        printNumber();
        printZipCode();
        clickOnSubmitMapButton();
    }
}



