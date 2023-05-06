package calismalarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import techproed.utilities.Driver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DenemeTask12 {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım


    @Test
    public void name() throws InterruptedException {
       Driver.getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        List<WebElement> sayilar =Driver.getDriver().findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
        Random rnd = new Random();
        for (int i = 0; i < sayilar.size(); i++) {
            sayilar.get(rnd.nextInt(sayilar.size()-1)).click();
            if (i==1){
                break;
            }
            sayilar = Driver.getDriver().findElements(By.xpath("//*[@class='btn btn-outline-primary']"));

        }
        String sayi1 = Driver.getDriver().findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println(sayi1);
        Thread.sleep(2000);

        List<WebElement> islem = Driver.getDriver().findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
        islem.forEach(t -> System.out.println(t.getText()));
        String tiklananIsaret="";
        for (int i = 0; i < islem.size(); i++) {
            islem = Driver.getDriver().findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
            WebElement isaret = islem.get(rnd.nextInt(islem.size()));
            isaret.click();
            tiklananIsaret=isaret.getText();

        }
        System.out.println("TIKLANAN ISARET "+tiklananIsaret);
        Thread.sleep(2000);
        for (int i = 0; i < sayilar.size(); i++) {
            sayilar.get(rnd.nextInt(sayilar.size()-1)).click();
            if (i==1){
                break;
            }
            sayilar =Driver.getDriver().findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
        }
        String[] sonucEkran = Driver.getDriver().findElement(By.xpath("//*[@class='screen']")).getText().split("");
        List<String> num = new ArrayList<String>();
        num.add(sonucEkran[3] + sonucEkran[4]);

        String sayi2 = "";
        for (String s : num) {
            sayi2 = s;
            System.out.println(sayi2);
        }

        Thread.sleep(3000);

        Driver.getDriver().findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='spinner-border']")));

        String sonuc =Driver.getDriver().findElement(By.xpath("//*[@class='screen']")).getText();
        double actualResult = Double.parseDouble(sonuc);
        System.out.println("Gerçek Sonuc = " + actualResult);
        double s1 = Double.parseDouble(sayi1);
        double s2 = Double.parseDouble(sayi2);

        double expectedResult = 0;
        switch (tiklananIsaret) {
            case "+":
                expectedResult = s1 + s2;

                break;
            case "-":
                expectedResult = s1 - s2;

                break;
            case "÷":
                expectedResult = s1 / s2;

                break;
            case "x":
                expectedResult = s1 * s2;

                break;
        }

        System.out.println("Beklenen Sonuc = " + expectedResult);

        assert expectedResult == actualResult;


    }
}
