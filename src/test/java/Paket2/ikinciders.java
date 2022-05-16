package Paket2;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ikinciders {
static WebDriverManager ilkadim;
@Test
    public void method() throws InterruptedException{

    WebDriverManager.chromedriver().setup();
    WebDriver deneme=new ChromeDriver();
    deneme.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    deneme.get("https:google.com");
    deneme.navigate().to("https:youtube.com");
    Thread.sleep(2000);


}
}
