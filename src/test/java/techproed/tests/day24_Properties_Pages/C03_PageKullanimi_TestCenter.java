package techproed.tests.day24_Properties_Pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterTechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PageKullanimi_TestCenter {
    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin
    //Sayfadan cikis yap ve cikis yapildigini test et
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterTechproPage tctp = new TestCenterTechproPage();
        tctp.username.sendKeys(ConfigReader.getProperty("kullaniciAdi"), Keys.TAB,
                               ConfigReader.getProperty("kullaniciPassword"),Keys.ENTER);
        //Burada tekrardan password icin locate almadik Tab tusuyla asagi inerek passwordu yazdirmis olduk.
        Assert.assertTrue(tctp.text.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        tctp.logout.click();
        Assert.assertTrue(tctp.giris.isDisplayed());
        Driver.closeDriver();
    }
}
