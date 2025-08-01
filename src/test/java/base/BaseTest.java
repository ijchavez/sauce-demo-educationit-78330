package base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.FinishPage;
import pages.InventoryPage;
import pages.LoginPage;
import support.DriverManager;
import utilities.Constants;

public class BaseTest {
	public WebDriver driver;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public FinishPage finishPage;
    
    Faker faker;
    
    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        driver.get(Constants.SAUCEDEMO_URL);

        loginPage = new LoginPage(driver);
        
    }
    
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
