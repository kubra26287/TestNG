package techproed.tests.day23_DependsOnMethod_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_SoftAssertion {
    /*
   -- SoftAssert kullanmak icin oncelikle bir obje olusturmamiz gerekir.
   Cunku Softassert intance oldugundan dolayi obje olusturup o sekilde
   calistirabiliriz.junittekki Assert static idi heryerden ulasilailiyordu.
   --Hard assertionda bir dogrulama Failed olursa Testin calismasi durur.
   butun hatalari en son listelemesini istedigimizde softAssert.assertAll methodu kullaniriz.
        Aksi halde hata vermez
     */
    //ilk olarak
    SoftAssert softAssert;
    WebDriver driver;
    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")) ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Url in amazon.com.tr olup olmadigini dogrulayiniz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");

        //Assert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");
        //BUrada Hard Assertion kullandigimizda Test hatali oldugu icin direk durur devam calismaz


        //basligin 'best' icerdigini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //amazon kutusunda iphone aratalim
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //sonucun samsung icerip icermedigini Test edin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonuc.getText().contains("samsung"));
        System.out.println("Gercek sonuc iphone olmali");
        softAssert.assertAll();
        System.out.println("Test sonuclandi");//bunu yazdirmaz cunku assertAll dan sonrasi calismaz.

    }




}
