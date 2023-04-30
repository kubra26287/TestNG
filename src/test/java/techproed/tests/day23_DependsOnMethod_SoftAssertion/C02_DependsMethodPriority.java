package techproed.tests.day23_DependsOnMethod_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsMethodPriority {
    /*
    Bu classi  Priorty ve dependsOnMethod arasindaki farki gostermek icin actik.
    Priorty cok fazla Test methodunun oldugu class da hepsini numaralandiracagimiz icin kullanisli olmaz.
    O yuzden dependsOnMethod kullanarak sadece istedigimiz Test methodunu baglariz.
     */
    WebDriver driver;
    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")) ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void amazonTest2() {
        driver.get("https://amazon.com");

    }

    @Test(priority = 2)
    public void amazonTest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
