package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class TestCases {

    WebDriver driver;

    RegistrationPage registrationPage;
    LoginPage loginPage;
    AddItemPage addItemPage;
    PurchasePage purchasePage;
    ContactPage contactPage;
    String alertText;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        addItemPage = new AddItemPage(driver);
        purchasePage = new PurchasePage(driver);
        contactPage = new ContactPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void registrationTest() throws InterruptedException{
        registrationPage.clickRegistration();
        registrationPage.enterUsernamee("zhiibeekk");
        registrationPage.enterPassword("togzhan09");
        registrationPage.clickSignUpButton();
        Thread.sleep(3000);
        handleAlert();
        Assert.assertEquals(alertText, "Sign up successful.");
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException{
        loginPage.clickLogin();
        loginPage.enterUsername("atibek0va");
        loginPage.enterPassword("togzhan09");
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        WebElement welcomeMessageElement = driver.findElement(By.id("nameofuser"));
        Thread.sleep(2000);
        String welcomeMessage = welcomeMessageElement.getText();
        String expectedWelcomeMessage = "Welcome atibek0va";
        Assert.assertEquals(welcomeMessage, expectedWelcomeMessage, "Login was not completed with the expected welcome message.");
        }

    @Test(priority = 3)
    public void addToCartTest() throws InterruptedException {
        addItemPage.clickProduct();
        addItemPage.clickAddToCart();
        Thread.sleep(3000);
        handleAlert();
        String expectedAlertText = "Product added.";
        Assert.assertEquals(alertText, expectedAlertText, "Product was not added to the cart successfully.");
    }
    private void handleAlert() throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void purchaseTest() throws InterruptedException{
        purchasePage.clickCart();
        purchasePage.clickPlaceOrder();
        String name = "Atibek Togzhan";
        String country = "Kazakhstan";
        String city = "Almaty";
        String creditCard = "1234567890123456";
        String month = "01";
        String year = "2024";
        purchasePage.enterShippingDetails(name, country, city);
        purchasePage.enterPaymentDetails(creditCard, month, year);
        purchasePage.clickPurchaseButton();
        Thread.sleep(4000);

        WebElement thankYouMessageElement = driver.findElement(By.xpath("/html/body/div[10]/h2"));
        String thankYouMessage = thankYouMessageElement.getText();
        String expectedThankYouMessage = "Thank you for your purchase!";
        Assert.assertTrue(thankYouMessage.contains(expectedThankYouMessage), "Thank you message does not contain the expected value.");
        purchasePage.clickOkButton();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void contactTest() {
        contactPage.clickContact();
        contactPage.enterEmail("togzhanatibekova@gmail.com");
        contactPage.enterName("Togzhan Atibek");
        contactPage.enterMessage("I can't view the my order history");

        contactPage.clickSendMessageButton();
    }

}
