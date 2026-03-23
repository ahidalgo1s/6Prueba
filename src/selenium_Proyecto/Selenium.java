package selenium_Proyecto;

import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "Ubicacion del driver\\msedgedriver.exe");
        Menu();
    }

    public static void Menu() throws InterruptedException {
        inicio iniciar = new inicio();
        clientes cc = new clientes();
        byte opcion;

        opcion = Byte.parseByte(JOptionPane.showInputDialog(null,
                "****MENÚ PRINCIPAL****\n\n"
                + "1.Prueba de inicio de seccion \n"
                + "2.Prueba de Login con credenciales inválidas \n"
                + "3.Agregar producto al carrito \n"
                + "4.Ordenamiento de productos por precio \n"
                + "5.Finalización del proceso de compra \n"
                + "6.Verificación de visualización de productos \n"
                + "7.Salir \n\n"
                + "Digite su opción:"));

        switch (opcion) {
            case 1: {
                System.out.println("Ejecutando prueba 1");
                iniciar.user();
                Menu();
                break;

            }
            case 2: {
                System.out.println("Ejecutando prueba 2");
                iniciar.loginInvalido();
                Menu();
                break;
            }
            case 3: {
                System.out.println("Ejecutando prueba 3");
                cc.carrito();
                Menu();
                break;
            }
            case 4: {
                System.out.println("Ejecutando prueba 4");
                cc.filtroProductos();
                Menu();
                break;
            }
            case 5: {
                System.out.println("Ejecutando prueba 5");
                cc.compra();
                Menu();
                break;
            }
            case 6: {
                System.out.println("Ejecutando prueba 6");
                cc.visualizarProductos();
                Menu();
                break;
            }
            case 7: {
                break;
            }
            default: {
                Menu();

            }
        }

    }
}
