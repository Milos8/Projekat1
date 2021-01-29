package pages;


import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KlasaHomePage extends BaseHelper
{
    @FindBy(className="address-form-component-search-input")
    WebElement searchBox;

    @FindBy (className = "address-form-component-list")
    WebElement addressHolder;

    @FindBy (className = "btn-primary")
    WebElement orderButton;

    WebDriver driver;
    public KlasaHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToDonesiHomePage()
    {
        driver.get("https://www.donesi.com/");
    }

    private void enterAddressInSearchBox(String address)
    {
        wdWait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(address);
    }

    private void confirmAddressFromDropDown()
    {
        wdWait.until(ExpectedConditions.visibilityOf(addressHolder));
        List<WebElement> addresses = addressHolder.findElements(By.tagName("li"));
        WebElement address = addresses.get(0);
        System.out.println("");
        System.out.println("Chosen address:"+address.getText());
        address.click();
    }

    private void clickOnOrderButton()
    {
        orderButton.click();
    }


    public void donesiComFilter(String address)
    {
        navigateToDonesiHomePage();
        enterAddressInSearchBox(address);
        confirmAddressFromDropDown();
        clickOnOrderButton();
    }
}