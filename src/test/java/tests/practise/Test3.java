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
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test3 extends TestBase {

    // 1) https://www.ntv.com.tr/ ADRESİNE GİT
    // 2) SAYFANIN TiTLE'NIN "NTV HABER - Haberler, Son Dakika Haberleri" OLDUGUNU DOGRULA
    // 3) SAYFANIN HANDLE DEGERiNi AL.
    // 4) SPOR SAYFASINA TIKLA
    // 5) URL'iN "https://www.ntvspor.net/" OLDUGUNU DOGRULA
    // 6) ANA SAYFAYA GERi DON
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.ntv.com.tr/");
        System.out.println("SAYFA TiTLE: " + driver.getTitle());

        String expectedTitle = "NTV HABER - Haberler, Son Dakika Haberleri";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle, "Title istenenden farkli");

        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println("1. SAYFANIN HANDLE DEGERi: " + ilkSayfaHandleDegeri);

        driver.findElement(By.xpath("//a[@class='header-category-link spor']")).click();

        System.out.println(driver.getCurrentUrl());

        Set<String> tumWindowHandles = driver.getWindowHandles();
        System.out.println("Tum Handles: " + tumWindowHandles);

        String ikinciWindowHandle = "";

        for (String each: tumWindowHandles
        ) {
            if(!each.equals(ilkSayfaHandleDegeri)){
                ikinciWindowHandle = each;
            }
        }
        System.out.println("2. SAYFANIN HANDLE DEGERi: " + ikinciWindowHandle);

        //2. SAYFAYA GECMiS olduk
        driver.switchTo().window(ikinciWindowHandle);

        System.out.println(driver.getCurrentUrl());

        String expectedURL = "https://www.ntvspor.net/";
        String actualURL = driver.getCurrentUrl();

        softAssert.assertEquals(driver.getCurrentUrl(),expectedURL
                ,"Url is not as expected");

        softAssert.assertAll();

        Thread.sleep(3000);

        driver.switchTo().window(ilkSayfaHandleDegeri);
    }
}