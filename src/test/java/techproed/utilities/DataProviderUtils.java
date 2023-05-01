package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","icAnadolu","06"},
                              {"Izmir","Ege","35"},
                              {"Istanbul", "Marmara", "34"}};
    }

    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Erol","1234"},{"Kubra","5678"},{"Fatih","1983"}};
    }

    @DataProvider
    public Object[][] blueRental()  {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        return excelUtils.getDataArray();
       // return new Object[][]{}; bunu siliyoruz.Cunku verileri excelUtils'den cagiriyoruz.
    }
}
