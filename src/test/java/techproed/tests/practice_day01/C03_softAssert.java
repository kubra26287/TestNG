package techproed.tests.practice_day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.TestBase;

public class C03_softAssert extends TestBase {
    /*
            'softAssertion' ile Junitteki 'Assertion' arasindaki fark;
       *Assert programi calistirdiginda hata aliyorsa programi durduruyor
       * SoftAssertion programi calistirdiginda hata aliyorsa Test e devam eder
        Test sonuclandiginda calismayan Testi kirmizi uyari ile belirtir.
        butun hatalari en son listelemesini istedigimizde softAssert.assertAll methodu kullaniriz.
        Aksi halde hata vermez

     */

    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin

    @Test
    public void test1() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://www.amazon.com");
        // Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        String baslik = driver.getTitle();
        softAssert.assertTrue(baslik.contains("RAmazon1"),"Titel amazon icermiyor"); //burada bilerek yanlis yazdik ki soft assert test sonlanana kadar calistigini kontrol ettik.
        // Arama kutusunun erisilebilir oldugunu test edin
       WebElement aramaKutusu=  driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       softAssert.assertTrue(aramaKutusu.isEnabled(),"Arama kutusuna erisilemiyor");
        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // Sonuc yazısının gorunur oldugunu test edin
        WebElement aramaSonucu =  driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(aramaSonucu.isDisplayed(),"Sonuc yazisi gorunmuyor");

        softAssert.assertTrue(aramaSonucu.getText().contains("Nutella"),"sonuc yazisi nutella icermiyor");

        softAssert.assertAll();


    }
}
