package techproed.tests.day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

import java.io.FileNotFoundException;

public class C01_ExcelTest1 {
    @Test
    public void excelTest1(){
        String path ="src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        ExcelUtils excelUtils =new ExcelUtils(path,sheetName);
        System.out.println(excelUtils.getCellData(1, 0));
        String email = excelUtils.getCellData(1,0);
        String password = excelUtils.getCellData(1,1);
        System.out.println(email+" || "+password);

    }
}
