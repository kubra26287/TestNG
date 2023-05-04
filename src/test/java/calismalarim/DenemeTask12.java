package calismalarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import java.util.List;
import java.util.Random;

public class DenemeTask12 {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım


    @Test
    public void test1() {
        Driver.getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        List<WebElement> hesapM = Driver.getDriver().findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
        Random random = new Random();
        for (int i = 0; i <hesapM.size() ; i++) {
            hesapM.get(random.nextInt(hesapM.size()-1)).click();
            if (i==1){
                break;
            }
            hesapM =  Driver.getDriver().findElements(By.xpath("//*[@class='btn btn-outline-primary']"));

        }
    }
}
