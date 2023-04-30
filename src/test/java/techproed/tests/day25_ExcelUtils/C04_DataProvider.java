package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProvider {


    /*
           * DataProvider bir cok veriyi Test caselere loop kullanmadan aktarmak icin kullanilir.
           * TestNG den gelen bir ozelliktir.
           * 2 boyutlu bir object Array return eder.
           * DDT(Data Driven Testing) icin kzllanilir. Yani birden fazla veriyi Testcase'lerde
           ayni anda kullanmak icin kullanilir.
           * Kullanimi icin @Test notasyonundan sonra parametre olarak dataprovider yazilir ve
            String bir isim belirtilir.Bu belirttigimiz isimle @DataProvider notasyonu ile bir method olustururlur
            */

    @DataProvider(name = "googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}};
    }

    @Test(dataProvider = "urunler") //Test icine yazdik urunler uzerine tikladik create method urunler tikladik yukaridaki method cikti.
    public void testDataProvider(String data) { //dataProvider daki verileri alabilmek icin Test methodumuza String bir parametre atariz.
        System.out.println(data);
    }
    /*
       Eğer farklı bir test methodu için aynı dataProvider methodu kullanılacaksa
       @DataProvider(name = "googleTest") şeklinde dataProvider notasyonundan sonra name parametresine yeni
       oluşturduğumuz methodun adını yazarız.
 */

    @Test(dataProvider = "googleTest")
    public void googleTest(String araclar) {
        //Google sayfasina gidiniz

        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}}; araclari aratiniz
        GooglePage googlePage = new GooglePage();
        googlePage.search.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(3);
        //Her aramadan sonra sayfa remi aliniz
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(3);
        //Driver.closeDriver();
    }
}
