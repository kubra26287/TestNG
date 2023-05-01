package techproed.tests.day26_ExcelDataProvider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class C02_DataProvider {
    //Bu classi olusturdugumuz gun Utilitils den DataProvider class'i actik


    @Test(dataProvider = "sehirVerileri",dataProviderClass = DataProviderUtils.class)
    //Eger verileri 'DataproviderUtils' class'indan
    // cekmek istersek virgulden sonra "dataProviderClass = DataProviderUtils.class" yazariz.

    public void testName(String ad,String bolge,String plaka) {
        System.out.println(ad+" | "+bolge+" | "+plaka);
    }

    @Test(dataProvider = "kullanicilar",dataProviderClass = DataProviderUtils.class)
    public void test2(String userName,String password) {
        System.out.println(userName+" | "+password);
    }
    /*
    Yukardaki orneklerdeki gibi blurantalCar sayfasina login olunuz.Her data icin login oldugunuzu dogrulayiniz.
    not: Configration.propertys dosyasindaki verileri kullaniniz.
     */


}
