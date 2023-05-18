package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
     WebDriver driver;

    @FindBy(xpath = "/html/body/nav/div[1]/ul/li[8]/a")
    WebElement getRegisrationButton;

    @FindBy(id = "sign-username")
     WebElement usernameField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/form/div[2]/input")
     WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/button[2]")
     WebElement signUpButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegistration(){
        getRegisrationButton.click();
    }

    public void enterUsernamee(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
