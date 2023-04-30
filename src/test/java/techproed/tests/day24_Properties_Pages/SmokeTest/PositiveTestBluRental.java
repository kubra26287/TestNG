package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveTestBluRental {
    /*
        Acceptance Criteria:
        Admin olarak, uygulamaya giriş yapabilmeliyim
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
         */
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACArUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("email"), Keys.TAB,
                ConfigReader.getProperty("pass"),Keys.ENTER);

        Assert.assertEquals(blueRentalPage.verify.getText(),"Jack Nicholson");

    }
}
