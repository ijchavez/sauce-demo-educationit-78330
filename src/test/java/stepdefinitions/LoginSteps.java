package stepdefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;
import support.DriverManager;
import utilities.Constants;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("que el usuario se encuentra en la página de inicio")
    public void que_el_usuario_se_encuentra_en_la_página_de_inicio() {
		driver = DriverManager.getDriver();
		driver.get(Constants.SAUCEDEMO_URL);
		
		loginPage = new LoginPage(driver);
		
    }
    
    @When("ingresa el usuario {string}")
    public void ingresa_el_usuario(String username) {
        loginPage.enterUsername(username);
    }

    @When("ingresa la contraseña {string}")
    public void ingresa_la_contraseña(String password) {
        loginPage.enterPassword(password);
    }

    @When("deja el campo de usuario vacío")
    public void deja_el_campo_de_usuario_vacío() {
        loginPage.enterUsername("");
    }

    @When("deja el campo de contraseña vacío")
    public void deja_el_campo_de_contraseña_vacío() {
        loginPage.enterPassword("");
    }

    @When("presiona el botón de login")
    public void presiona_el_boton_de_login() {
        loginPage.clickLogin();
    }

    @Then("debería ser redirigido a {string}")
    public void deberia_ser_redirigido_a(String expectedUrl) {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "La URL de redirección no es la esperada");
    }

    @Then("debería ver el mensaje de error en el login {string}")
    public void deberia_ver_el_mensaje_de_error(String expectedMessage) {
        loginPage.verifyErrorMessage(expectedMessage);
    }
}