/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selenium_Proyecto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 *
 * @author Lenovo
 */
public class inicio {

    public void user() {
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // datos correctos
        String username = "standard_user";
        String password = "secret_sauce";

        // localizar elementos (CORRECTOS)
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        // login
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

        // validación básica
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL actual: " + currentUrl);

        if (currentUrl.contains("inventory")) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Login fallido");
        }
    }

    public void loginInvalido() {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // datos incorrectos
        String username = "standard_user";
        String password = "incorrecta";

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

        // capturar mensaje de error
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String mensaje = error.getText();

        System.out.println("Mensaje de error: " + mensaje);

        if (mensaje.contains("Epic sadface")) {
            System.out.println("Prueba correcta: error detectado");
        } else {
            System.out.println("Prueba fallida");
        }

        driver.quit();
    }

}
