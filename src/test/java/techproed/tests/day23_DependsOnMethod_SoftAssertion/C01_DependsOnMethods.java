package techproed.tests.day23_DependsOnMethod_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {
    /*
    Test methodlari birbirinden bagimsiz calisir. Methodlari birbirini bagimli calistirmak istersek
     @Test(dependsOnMethods = "amazonTest")  parametresini bu sekilde baglamak istedigimiz Test methodunun adini belirterek
     kullaniriz.Eger dependsMethodunu kullanmazsak 'NULLPointerExeption' aliriz.
     */
    WebDriver driver;
    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")) ;
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(dependsOnMethods = "amazonTest")
    public void amazonTest2() {
        driver.get("https://amazon.com");

    }

    @Test(dependsOnMethods = "amazonTest2")  //bu Test in calismasi icin butun classi calistirmamiz gerekir.Sadece amazon
    //test 2 calisirsa driveri bulamayacagindan Testi bulamaz.
    public void amazonTest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
