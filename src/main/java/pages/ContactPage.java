package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/nav/div[1]/ul/li[2]/a")
    WebElement contact;

    @FindBy(id = "recipient-email")
    WebElement emailInput;

    @FindBy(id = "recipient-name")
    WebElement nameInput;

    @FindBy(id = "message-text")
    WebElement messageInput;

    @FindBy(xpath = "//button[contains(text(), 'Send message')]")
    WebElement sendMessageButton;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContact(){
        contact.click();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterMessage(String message) {
        messageInput.sendKeys(message);
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }
}