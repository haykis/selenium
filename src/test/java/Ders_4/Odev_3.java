package Ders_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Odev_3 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get("https:amazon.com");
        Thread.sleep(2000);

    }

    @Test
    public void test1() throws InterruptedException {
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Computers");
        Thread.sleep(2000);
        WebElement arama=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        arama.sendKeys("Computer mice"+Keys.ENTER);
        WebElement sonuc=driver.findElement(By.className("sg-col-inner"));
        System.out.println("sonuc sayisi "+sonuc.getText());
        WebElement logo=driver.findElement(By.className("rush-component"));
        boolean gorunuyormu=logo.isDisplayed();
        Assert.assertTrue(gorunuyormu);

    }
    @Test
    public void test2() throws InterruptedException {
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Home & Kitchen");
        Thread.sleep(1000);
        WebElement arama=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        arama.sendKeys("tea glass"+Keys.ENTER);
        WebElement fiyat=driver.findElement(By.className("a-price"));
        System.out.println("urunun fiyati "+fiyat.getText());
        WebElement logo=driver.findElement(By.xpath("(//img[@class='s-image'])[4]"));
        boolean tiklaniyormu=logo.isEnabled();
        Assert.assertTrue(tiklaniyormu);
        logo.click();

    }

    @AfterMethod
    public void afterMethod() {


    }

    @AfterClass
    public void tearDown() {

        //driver.close();
    }
}
