package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddItemPage {
     WebDriver driver;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
     WebElement chooseProduct;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div[2]/div/a")
     WebElement addToCart;



    public AddItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProduct() {
        chooseProduct.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }
}