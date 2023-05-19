package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/nav/div[1]/ul/li[5]/a")
    WebElement getLoginButton;

    @FindBy(id = "loginusername")
     WebElement usernameField;

    @FindBy(id = "loginpassword")
     WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
     WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin(){
        getLoginButton.click();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
