package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C02_BlueRentalExcelTest {
    @Test
    public void excelTest() {
        /*BlueRentalCar adresine gidelim
          excel dosyamizdan aldigimiz ilk email ve password ile sayfaya login olalim
          Login oldugumuzu dogrulayalim.
         */

        /*
        Eger bir veriyi properties dosyasindan almak istiyorsak ConfigReader classindan
        .getProperty() methodu ile .properties uzantili dosyamiza girdigimiz Key degerini
         belirttikten sonra bize value yu getirir.
        Eger bir veriyi excel dosyasindan almak istiyorsak, excelUtils classindan methodlari kullanarak
        istedigimiz veriyi kullanabiliriz
         */

        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email = excelUtils.getCellData(1,0);
        String pass = excelUtils.getCellData(1,1);
        System.out.println(email+"||"+pass);

       // BlueRentalCar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACArUrl"));

        //excel dosyamizdan aldigimiz ilk email ve password ile sayfaya login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,pass,Keys.ENTER);

        //Login oldugumuzu dogrulayalim.
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());

    }
}
