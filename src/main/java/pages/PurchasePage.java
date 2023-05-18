package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {

    WebDriver driver;

    @FindBy(id = "cartur")
    WebElement iconCart;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/button")
    WebElement placeorder;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "country")
    WebElement countryField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "card")
    WebElement creditCardField;

    @FindBy(id = "month")
    WebElement monthField;

    @FindBy(id = "year")
    WebElement yearField;

    @FindBy(xpath = "//button[contains(text(), 'Purchase')]")
    WebElement purchaseButton;

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    WebElement okButton;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCart(){
        iconCart.click();
    }

    public void clickPlaceOrder(){
        placeorder.click();
    }

    public void enterShippingDetails(String name, String country, String city) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
    }

    public void enterPaymentDetails(String creditCard, String month, String year) {
        creditCardField.sendKeys(creditCard);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    public void clickOkButton(){ okButton.click(); }
}