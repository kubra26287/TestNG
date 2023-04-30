package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C05_DataProvider {

    /*
         username	password
         sam.walker@bluerentalcars.com	c!fas_art
         kate.brown@bluerentalcars.com	tad1$Fas
         raj.khan@bluerentalcars.com	v7Hg_va^
         pam.raymond@bluerentalcars.com	Nga^g6!

         Verileri kullanarak blurentalCar sayfasina login olalim
          */
    @DataProvider
    public static Object[][] BlueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com","c!fas_art"},
                              {"kate.brown@bluerentalcars.com","tad1$Fas"}};
    }

    @Test(dataProvider = "BlueRental")
    public void testDataProvider(String email,String password) {
        // BlueRentalCar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACArUrl"));

        // sayfaya login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(3);
        Driver.closeDriver();
        /*
       C05 classindaki task icin her kullanici icin dogrulama yapalim
        En son sayfayi kapatalim
         */

    }
}
