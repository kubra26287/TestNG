package techproed.tests.day28_Listeners;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class C02_ListenersTest2 {

    @Test
    public void test1() {
        System.out.println("Passed");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }

    @Test
    public void test2() {
        System.out.println("FAILED");
        Assert.assertEquals(2,1);
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandi");//Testi atlar yani ignore eder

    }

    @Test
    public void test4() {
        System.out.println("No SUch ELEMENT EXCEPTION");
        throw new NoSuchElementException("NoSuchElement");
        //  Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        //  Driver.getDriver().findElement(By.xpath("bhgkjhjgh"));
    }
}
