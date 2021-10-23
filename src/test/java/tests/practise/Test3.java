package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test3 {

    // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN

    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Test
    public void dropDown() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        WebElement dropdownGun = driver.findElement(By.cssSelector("#day"));
        Select select1 = new Select(dropdownGun);

        List<WebElement> daySecenekler = select1.getOptions();
        System.out.println("============ GUNLER ==========");
        for (WebElement each : daySecenekler) {
            System.out.println(each.getText());
        }

        WebElement dropdownAy = driver.findElement(By.cssSelector("#month"));
        Select select2 = new Select(dropdownAy);

        List<WebElement> aySecenekler = select2.getOptions();
        System.out.println("============ AYLAR ==========");
        for (WebElement each : aySecenekler) {
            System.out.println(each.getText());
        }

        WebElement dropdownYear = driver.findElement(By.cssSelector("#year"));
        Select select3 = new Select(dropdownYear);

        List<WebElement> yilSecenekler = select3.getOptions();
        System.out.println("============ YILLAR ==========");
        for (WebElement each : yilSecenekler) {
            System.out.println(each.getText());
        }
    }
}
