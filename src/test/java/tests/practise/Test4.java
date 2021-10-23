package tests.practise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Test4 extends TestBase {

    // 1) https://www.ntv.com.tr/ ADRESİNE GİT
    // 2) SAYFANIN TiTLE'NIN "NTV HABER - Haberler, Son Dakika Haberleri" OLDUGUNU DOGRULA
    // 3) SAYFANIN HANDLE DEGERiNi AL.
    // 4) SPOR SAYFASINA TIKLA
    // 5) URL'iN "https://www.ntvspor.net/" OLDUGUNU DOGRULA
    // 6) ANA SAYFAYA GERi DON


    @Test
    public void Test(){
        driver.get("https://www.ntv.com.tr/");
        System.out.println("Sayfa Title : "+driver.getTitle());

        String expectedTitle= "NTV HABER - Haberler, Son Dakika Haberleri";
        String actualTitle=driver.getTitle();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title istenenden farkli");



    }


}
