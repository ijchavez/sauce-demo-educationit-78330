package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import support.DriverManager;

public class CheckoutPage {

    private WebDriver driver = DriverManager.getDriver();
    private static final By CONTINUE_BUTTON = By.xpath("//input[@class = 'btn_primary cart_button']");
    
    private static final By CHECKOUT_FIRSTNAME = By.id("first-name");
    private static final By CHECKOUT_LASTNAME = By.id("last-name");
    private static final By CHECKOUT_ZIPCODE = By.id("postal-code");
    private static final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void fillCheckoutFirstName(final String firstName) {
    	driver.findElement(CHECKOUT_FIRSTNAME).sendKeys(firstName);
    }
    
    public void fillCheckoutLastName(final String lastName) {
    	driver.findElement(CHECKOUT_LASTNAME).sendKeys(lastName);
    }
    
    public void fillCheckoutZipCode(final String zipCode) {
    	driver.findElement(CHECKOUT_ZIPCODE).sendKeys(zipCode);
    }
    
    public CheckoutOverviewPage clickOnCheckoutButton() {
    	driver.findElement(CONTINUE_BUTTON).click();
    	return new CheckoutOverviewPage(driver);
    }
    
    public void checkErrorMessage(String expectedErrorMessage) {
    	Assert.assertEquals(driver.findElement(ERROR_MESSAGE).getText(), expectedErrorMessage);
    }
    
}
