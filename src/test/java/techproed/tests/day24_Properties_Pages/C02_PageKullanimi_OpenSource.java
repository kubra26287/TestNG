package techproed.tests.day24_Properties_Pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage_Locate;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi_OpenSource {
    //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
    //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
    //Login Testini basarili oldugunu test et

   // openSourse_Url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    @Test
    public void test1() throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
        Yukaridaki adres icin 20 adet test methodu olusturursak sonrasinda yukaridaki Url de
        bir degisiklik oldugunda butun Test methodlarindan tek tek Url duzeltmek yerine bir
        kere properties dosyamdan Url i duzeltirim bu bizim icin daha duzenli ve kolay olur.
         */
        OpenSourcePage_Locate openSourcePage = new OpenSourcePage_Locate();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        Thread.sleep(3000);
        //Login Testini basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());
        Driver.closeDriver();
    }
}
