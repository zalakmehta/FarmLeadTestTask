import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private String CHROME_DRIVER_PATH = ClassLoader.getSystemResource("chromedriver-86.0.4240.22.exe").getPath();

    // Page URLs
    private String LOGIN_PAGE_URL = "https://demo.combyne.ag/login";

    // Element Locators
    private String emailInputXPath = "//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input";
    private String passwordInputXPath = "//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input";
    private String nextBtnXPath = "//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input";

    private String emailInputAlert = "//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[2]";

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        // Do something
    }

    @Test
    public void verifyEmailPasswordWizardWithInput() throws InterruptedException {
        WebElement emailInput = driver.findElement(By.xpath(emailInputXPath));
        WebElement passwordInput = driver.findElement(By.xpath(passwordInputXPath));
        WebElement nextButton = driver.findElement(By.xpath(nextBtnXPath));

        emailInput.sendKeys("abc@example.com");
        passwordInput.sendKeys("Password123");

        nextButton.click();

        // Assertions here
    }

    @Test
    public void verifyEmailPasswordWizardWithoutInput() throws InterruptedException {
        WebElement emailInput = driver.findElement(By.xpath(emailInputXPath));
        WebElement passwordInput = driver.findElement(By.xpath(passwordInputXPath));
        WebElement nextButton = driver.findElement(By.xpath(nextBtnXPath));

        // empty email and password input
        emailInput.sendKeys("");
        passwordInput.sendKeys("");
        nextButton.click();

        // assertions
        WebElement emailAlert = driver.findElement(By.xpath(emailInputAlert));
        String actualEmailAlertText = emailAlert.getText();
        String expectedEmailAlertText = "Either a phone number or email is required.";
        Assert.assertEquals(actualEmailAlertText, expectedEmailAlertText);
    }

    @Test
    public void createAccount() throws InterruptedException {
        WebElement createAccountlink = driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]"));
        createAccountlink.click();

        // assertions
        WebElement AccountPageText = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[2]"));
        String actualaccountpageText = AccountPageText.getText();
        String expectedaccountpageText = "Let's Get Started!";
        Assert.assertEquals(actualaccountpageText, expectedaccountpageText);
    }

    @Test
    public void navigateBackToLogin() {
        // forgot password
        WebElement forgotPassword = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[6]"));
        forgotPassword.click();

        WebElement backtoLoginlink = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/form/div[6]"));
        backtoLoginlink.click();

        // assertions
        WebElement LoginpageText = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[2]"));
        String actualLoginpageText = LoginpageText.getText();
        String expectedLoginpageText = "Welcome to Combyne";
        Assert.assertEquals(actualLoginpageText, expectedLoginpageText);
    }

    @Test
    public void verifyCreateNewUserWizardWithoutInput() {
        // create an account
        WebElement createAnAccount = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[7]/span"));
        createAnAccount.click();

        // empty email and password input
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input"));
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[1]/fieldset/div/input"));
        WebElement nextButton = driver.findElement(By.xpath(nextBtnXPath));
        firstNameInput.sendKeys("");
        lastNameInput.sendKeys("");
        emailInput.sendKeys("");
        nextButton.click();

        // assertions

        WebElement firstNameAlert = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[2]"));
        String actualFirstNameAlertText = firstNameAlert.getText();
        String expectedFirstNameAlertText = "First name is required.";
        Assert.assertEquals(actualFirstNameAlertText, expectedFirstNameAlertText);

        WebElement lastNameAlert = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[2]/div[2]"));
        String actualLastNameAlertText = lastNameAlert.getText();
        String expectedLastNameAlertText = "Last name is required.";
        Assert.assertEquals(actualLastNameAlertText, expectedLastNameAlertText);

        WebElement emailAlert = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[2]/div[2]"));
        String actualEmailAlertText = emailAlert.getText();
        String expectedEmailAlertText = "An email is required.";
        Assert.assertEquals(actualEmailAlertText, expectedEmailAlertText);
    }
}





