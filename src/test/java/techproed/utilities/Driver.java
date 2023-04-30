package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {
       /*
Driver class'indaki temel mantik extends yontemiyle degil yani TestBase class'ina extent etmek yerine
Driver class'indan static methodlar kullanarak driver olustururuz.Static oldugu icin heryerden bu classa ulasabilecegiz.
Static yaptigimiz icin Obje olusturmaya gerek yok.
 */

    /*
    Singleton Pattern : Tekli kullanim kalibi
      Bir classtan obje olusturulmasinin onune gecmek icin kullanilan ifade
      Bir classtan obje olusturmanin onune gecmek icin default constructor  in kullanimini engellemek icin
    private access modifire kullanarak bir constructor olustururuz.
     */
    private Driver(){
        //Artik driver classindan obje olusturulamicak boylece Driver classini garantiye almis oluruz
    }


   static WebDriver driver;
  public static WebDriver getDriver(){
     /*
     Driver i her cagir cagirdiginda yeni bir pencere acilmasinin onune gecmek icin
     if blogu icinde eger driver a deger atanmamissa deger ata, eger deger atanmissa driver i ayni sayfada return et.
     Bunun icin sadece yapmamiz gereken if(driver==null) kullanmak
      */
     if (driver==null){
         switch (ConfigReader.getProperty("browser")){
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driver= new ChromeDriver();
                 break;
             case "edge":
                 WebDriverManager.edgedriver().setup();
                 driver=new EdgeDriver();
                 break;
             default:
                 WebDriverManager.chromedriver().setup();
                 driver= new ChromeDriver();
         }

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     }
     return driver;
  }

    public static void closeDriver(){
     if (driver!=null){ //driver a deger atanmissa
         driver.close();
         driver=null;
     }

    }
    public static void quidDriver(){
        if (driver!=null){ //driver a deger atanmissa
            driver.quit();
            driver=null;
        }

    }



}
