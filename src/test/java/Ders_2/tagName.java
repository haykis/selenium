package Ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class tagName {
    static WebDriver driver;

    @Test
    public void driverTanimlama() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://google.com");
        WebElement guvenlikDuvari=driver.findElement(By.xpath("//*[.='Kabul ediyorum']"));
       Thread.sleep(3000);
        guvenlikDuvari.click();
        WebElement yazi=driver.findElement(By.tagName("a"));
        System.out.println("en bastaki a tagname'e sahip yazi "+yazi.getText());

        System.out.println("--------------");
       List<WebElement> listem=driver.findElements(By.tagName("a"));



       for(int a=0;a<listem.size();a++){
           System.out.println("Tum a tagname'e sahip elemanler= " +listem.get(a).getText());
       }

       for(WebElement w:listem) {
           System.out.println("Tum a tagname'e sahip elemanler= " + w.getText());
       }







    }
}
