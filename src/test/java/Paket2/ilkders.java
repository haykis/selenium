package Paket2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ilkders {
    static WebDriverManager deneme;
    @Test
    public void ornek_sayfa() throws InterruptedException{
        WebDriver deneme;
        WebDriverManager.chromedriver().setup();
        deneme=new ChromeDriver();
        //deneme.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        deneme.get("https://google.com");
        deneme.manage().window().maximize();
        Thread.sleep(1000);
        deneme.get("https:youtube.com");
        Thread.sleep(2000);
        deneme.navigate().back();
        Thread.sleep(1000);
        deneme.close();


    }
}
