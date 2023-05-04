package techproed.tests.practice_day01;

import org.testng.annotations.Test;
import techproed.utilities.TestBase;

public class C01_Priority extends TestBase {
    //Junit'te alfabetik siraya gore ve rakamlara göre calisir.TestNG'de isim sirasina ve rakamlara göre calisir.Eger priority(oncelik sirasi)
    // olusturmak istersek kucukten buyuge deger vererek oncelik belirtiriz.
    // Priority degeri en kucuk olan en once calisir.Priority e herhangi bir deger atamazsak default olarak sifir kabul eder.
    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz

    @Test(priority =-2 )
    public void amazon() {
        driver.get("https://www.amazom.com");
    }

    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz

    @Test
    public void bestbuy() {
        driver.get("https://www.bestbuy.com");
    }

    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    @Test(priority =-5 )
    public void techpro() {
        driver.get("https://www.techproeducation.com");
    }


    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız
}
