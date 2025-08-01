package loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;


public class LoginTests extends BaseTest{

    @Test
    public void testLoginWithValidCredentials() {
       
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Assert successful login
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

    }

    @Test
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

       loginPage.verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLoginWithEmptyFields() {
        loginPage.clickLogin();

        // Assert error message
        loginPage.verifyErrorMessage("Epic sadface: Username is required");

    }

    @Test
    public void testLoginWithInvalidPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        // Assert error message
        loginPage.verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

}
