package techproed.tests.day22Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C03_Priority {
    /*Priorty de istedigimiz siralamayi yapariz
         TestNG test method'larını isim sırasına (alfabetik) göre ve rakamlara göre küçükten büyüğe çaliştirir.
     Eğer isim sıralamasının dışında bir sıralama ile çalışmasını isterseniz o zaman test methodlarına öncelik(priority)
     tanımlayabiliriz.
         Priority küçükten büyüğe göre çalışır. Eğer bir test methoduna priority atanmamışsa
     default olarak priority=0 kabul edilir.
      */
    WebDriver driver;
    @Test(priority = -3)
    public void techproedTest() {
        driver.get("https://techproeducation.com");
    }

    @Test(priority = -1)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test(priority = -2)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @Ignore
    //Ignore notasyonu ile tanimlanmis test methodu calismayacaktir fakat raporlamada gozukur
    @Test
    public void test1() {
        System.out.println("Test1 method");
    }

    @Test(enabled = false)
    //@Test(enabled = false) notasyonu da calismayacaktir ama raporlamalarda gozukmez.yandaki Run isareti kalkar.
    public void test2() {
        System.out.println("Test 2 Method");
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
