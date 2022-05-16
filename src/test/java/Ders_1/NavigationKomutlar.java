package Ders_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigationKomutlar {
    static WebDriverManager driver;

    @Test
    public void driver_Tanimlama() throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1
        driver.get("https://google.com");
        Thread.sleep(1000);
        //2 bulundugumuz sayfadan baska bir sayfaya gitmemizi saglar
        driver.navigate().to("https:amazon.com");
        Thread.sleep(1000);
        //3 navigate back geldigimiz sayfaya geri doner
        driver.navigate().back();
        Thread.sleep(1000);
        //4 navigate forward
        driver.navigate().forward();
        //5 sayfayi buyutur
        driver.manage().window().maximize();
        //6 navigate yenileme
        driver.navigate().refresh();
        Thread.sleep(1000);
        //7 close calistigimiz kapatmaya yariyor
       // driver.close();
        //8 tamamen kapatmak icin
        driver.quit();




    }
}