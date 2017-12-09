import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class TransaccionIT {

    //private static WebDriver driver =null;
     static WebDriver driver = null;

    public TransaccionIT(){

    }

    @BeforeClass
    public static void inicializarDriver() throws MalformedURLException {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void finalizarDriver(){
        driver.quit();
    }

    @Test
    public void TestSolicitudInformacion()
    {
        driver.get("http://www.aquaservice.com/contratar");
        WebElement nombreElem = driver.findElement(By.id("edit-submitted-nombre"));
        nombreElem.sendKeys("Prueba");
        WebElement telefElem = driver.findElement(By.id("edit-submitted-telefono"));
        telefElem.sendKeys("633383883");
        WebElement mailElem = driver.findElement(By.id("edit-submitted-email"));
        mailElem.sendKeys("prueba@yopmail.com");

        WebElement cmdEnviar = driver.findElement(By.name("op"));
        cmdEnviar.click();
        WebDriverWait wait = new WebDriverWait(driver , 65);
        WebElement resultElem = driver.findElement(By.id("page-title"));
        wait.until(ExpectedConditions.visibilityOf(resultElem));
        Assert.assertEquals(resultElem.getText(), "¡Gracias!");


    }
}
