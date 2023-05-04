package techproed.tests.practice_day01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.FaceBookPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PageClassKullanimi {
    // facebook anasayfaya gidin
    // kullanıcı email kutusuna rastgele bir isim yazın
    // kullanıcı sifre kutusuna rastgele bir password yazın
    // giris yap butonuna tıklayın
    // girdigin sifre yanlıs yazı elementinin, gorunur oldugunu test edin
    // sayfayı kaptın

    @Test
    public void test1() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanıcı email kutusuna rastgele bir isim yazın
        FaceBookPage faceBookPage = new FaceBookPage();
        ReusableMethods.bekle(2);
       WebElement cookie = faceBookPage.cookiesKabul;
       ReusableMethods.click(cookie);
        ReusableMethods.bekle(2);
        faceBookPage.emailKutusu.sendKeys("Kubra", Keys.TAB);

        // kullanıcı sifre kutusuna rastgele bir password yazın
        faceBookPage.pass.sendKeys("12345",Keys.TAB);
        // giris yap butonuna tıklayın
        faceBookPage.login.click();
        // girdigin sifre yanlıs yazı elementinin, gorunur oldugunu test edin
        Assert.assertTrue(faceBookPage.sifreyanlis.isDisplayed());
        // sayfayı kaptın
        Driver.closeDriver();
    }
}
