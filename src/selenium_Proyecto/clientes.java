/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selenium_Proyecto;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Lenovo
 */
public class clientes {

    public void carrito() {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

        // Agregar producto al carrito
        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();

        // Validar cantidad en el carrito
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String cantidad = cartBadge.getText();

        System.out.println("Cantidad en carrito: " + cantidad);

        if (cantidad.equals("1")) {
            System.out.println("Producto agregado correctamente al carrito");
        } else {
            System.out.println("No se agregó el producto al carrito");
        }

        driver.quit();
    }

    public void filtroProductos() throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement filtro = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filtro);
        select.selectByVisibleText("Price (low to high)");

        Thread.sleep(1000);

        String valor = driver.findElement(By.className("product_sort_container")).getAttribute("value");
        System.out.println("Valor del filtro: " + valor);

        if (valor.equals("lohi")) {
            System.out.println("Filtro aplicado correctamente");
        } else {
            System.out.println("No se aplicó el filtro");
        }
        driver.quit();
    }

    public void compra() {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Agregar producto
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Ir al carrito
        driver.findElement(By.className("shopping_cart_link")).click();

        // Ir a checkout
        driver.findElement(By.id("checkout")).click();

        // Llenar datos
        driver.findElement(By.id("first-name")).sendKeys("Oscar");
        driver.findElement(By.id("last-name")).sendKeys("Sanchez");
        driver.findElement(By.id("postal-code")).sendKeys("10101");

        // Continuar
        driver.findElement(By.id("continue")).click();

        // Finalizar compra
        driver.findElement(By.id("finish")).click();

        // Validar mensaje final
        String mensajeFinal = driver.findElement(By.className("complete-header")).getText();
        System.out.println("Mensaje final: " + mensajeFinal);

        if (mensajeFinal.equals("Thank you for your order!")) {
            System.out.println("Compra finalizada correctamente");
        } else {
            System.out.println("La compra no se completó");
        }

        driver.quit();
    }

    public void visualizarProductos() {
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Validar título de la página de productos
        String titulo = driver.findElement(By.className("title")).getText();
        System.out.println("Título mostrado: " + titulo);

        if (titulo.equals("Products")) {
            System.out.println("La página de productos se visualizó correctamente");
        } else {
            System.out.println("No se mostró correctamente la página de productos");
        }

        driver.quit();
    }

}
