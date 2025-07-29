package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import support.DriverManager;

public class FinishPage {

    private WebDriver driver = DriverManager.getDriver();
    private static final By COMPLETE_HEADER = By.xpath("//h2[@class='complete-header']");
    private static final By COMPLETE_TEXT = By.xpath("//div[@class='complete-text']"); 
       
    
    public FinishPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkCompleteHeader(final String expectedHeader) {
    	System.out.println(driver.findElement(COMPLETE_HEADER).getText());
    	Assert.assertEquals(driver.findElement(COMPLETE_HEADER).getText(), expectedHeader);
    	
    }
    
    public void checkCompleteText(final String expectedText) {
    	System.out.println(driver.findElement(COMPLETE_TEXT).getText());
    	Assert.assertEquals(driver.findElement(COMPLETE_TEXT).getText(), expectedText);
    	
    }

}
