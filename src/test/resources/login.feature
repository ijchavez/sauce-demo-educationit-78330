Feature: Validación del formulario de login en SauceDemo

  Scenario: Login exitoso con credenciales válidas
    Given que el usuario se encuentra en la página de inicio
    When ingresa el usuario "standard_user"
    And ingresa la contraseña "secret_sauce"
    And presiona el botón de login
    Then debería ser redirigido a "https://www.saucedemo.com/v1/inventory.html"

  Scenario: Login fallido con campo de usuario vacío
    Given que el usuario se encuentra en la página de inicio
    When deja el campo de usuario vacío
    And ingresa la contraseña "secret_sauce"
    And presiona el botón de login
    Then debería ver el mensaje de error en el login "Epic sadface: Username is required"

  Scenario: Login fallido con campo de contraseña vacío
    Given que el usuario se encuentra en la página de inicio
    When ingresa el usuario "standard_user"
    And deja el campo de contraseña vacío
    And presiona el botón de login
    # asi lo recibimos de chatgpt, inviertan esto para ver que pasa
    #Then debería ver el mensaje de error en el login "Epic sadface: Username and password do not match any user in this service" 
    Then debería ver el mensaje de error en el login "Epic sadface: Password is required"
    
  Scenario: Login fallido con credenciales inválidas
    Given que el usuario se encuentra en la página de inicio
    When ingresa el usuario "usuario_falso"
    And ingresa la contraseña "clave123"
    And presiona el botón de login
    Then debería ver el mensaje de error en el login "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login fallido con usuario bloqueado
    Given que el usuario se encuentra en la página de inicio
    When ingresa el usuario "locked_out_user"
    And ingresa la contraseña "secret_sauce"
    And presiona el botón de login
    # asi lo recibimos de chatgpt, inviertan esto para ver que pasa
    #Then debería ver el mensaje de error en el login "Epic sadface: Username and password do not match any user in this service" 
    Then debería ver el mensaje de error en el login "Epic sadface: Sorry, this user has been locked out."