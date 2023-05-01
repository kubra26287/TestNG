package techproed.tests.day26_ExcelDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.*;

import java.util.Arrays;

public class C03_DataProviderExcel {
    @Test
    public void testName()  {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        System.out.println(Arrays.deepToString(excelUtils.getDataArray()));
    }

    @Test(dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class)
    public void test2(String email,String pass) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACArUrl"));

        //excel dosyamizdan aldigimiz ilk email ve password ile sayfaya login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,pass,Keys.ENTER);
        ReusableMethods.bekle(3);
        Driver.closeDriver(); //Kapatmazsak calismiyor.

    }
    /*
    TESTLERİMİZ: TEST PACKAGE ALTINDA
    LOCATELERİMİZ:PAGES PACKAGE ALTINDA
    AYARLAMALARI YAPTIĞIMIZ VE METHODLAR OLUŞTURDUĞUMUZ CLASSLAR UTILITIES ALTINDA
     */

    /*
    Testng.xml dosyasini indirmek icin plugins install ok. Smoke test sag tikla
    createTesngXml tikla ok .File reloadAll from disk tikla.Dosya projede olusur.
     */
}
