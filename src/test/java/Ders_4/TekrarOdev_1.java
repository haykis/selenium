package Ders_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TekrarOdev_1 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https:amazon.com");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method dayiz");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement arama = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        arama.sendKeys("bilgisayar" + Keys.ENTER);
        //Thread.sleep(2000);
        driver.navigate().to("https:facebook.com");
        WebElement cerezler = driver.findElement(By.xpath("//*[.='Temel ve isteğe bağlı çerezlere izin ver']"));
        cerezler.click();
        driver.navigate().refresh();
        driver.navigate().back();
        WebElement temizle = driver.findElement(By.id("twotabsearchtextbox"));
        temizle.click();
        temizle.clear();
        temizle.sendKeys("s22" + Keys.ENTER);
        WebElement sonuc=driver.findElement(By.className("sg-col-inner"));
        System.out.println("arama sonucu= " + sonuc.getText());

    }

    @AfterMethod
    public void afterMethod() {


    }

    @AfterClass
    public void tearDown() {

       driver.close();
    }

}
