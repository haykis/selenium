package Ders_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleOdev_1 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get("https://google.com");
    }

    @Test
        public void test1() throws InterruptedException {
           WebElement guvenlikDuvari = driver.findElement(By.xpath("//*[.='Kabul ediyorum']"));
           Thread.sleep(3000);
           guvenlikDuvari.click();

           String title=driver.getTitle();
           String url=driver.getCurrentUrl();
        System.out.println("Google sayfasinin Title= "+title);
        System.out.println("Google sayfasinin Url si= "+url);
           if ((title.contains("Google")) && (url.contains("google"))){
            System.out.println("Google sayfasinin title ve Url eslesiyor");
        }else{
            System.out.println("bir problem olabilir");
        }


           WebElement arama = driver.findElement(By.name("q"));
           arama.sendKeys("Kulaklik" + Keys.ENTER);

    }
    @Test
    public void test2(){
        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("masa" + Keys.ENTER);
    }
    @Test
    public void test3(){
        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("sandalye" + Keys.ENTER);
    }

    @AfterMethod
    public void testtensonra(){
        WebElement sonuc= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());
    }

    @AfterClass
    public static void teardown(){

       driver.close();
    }

}


