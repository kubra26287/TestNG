package calismalarim;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;


import java.io.*;


public class DenemeTask11 {/*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
*/

    @Test
    public void test1() throws IOException, InvalidFormatException {
        String pathName = "/Users/fatihyilmaz/Desktop";
        String fileName = "data.xlsx";
        ReusableMethods.bekle(2);
        File file = new File(pathName,fileName);
        ReusableMethods.bekle(2);
        Workbook workbook=new XSSFWorkbook(file);
        ReusableMethods.bekle(2);
        Sheet sheet = workbook.createSheet("data");
        Row row1 = sheet.createRow(0);
        //baslik
        ReusableMethods.bekle(2);
        row1.createCell(0).setCellValue("email");
        row1.createCell(1).setCellValue("password");

        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("evren.techproed@gmail.com");

        row2.createCell(1).setCellValue("asdfgh");

        //dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        workbook.close();

    }

    @Test
    public void test2() throws IOException {

        String dosyaYolu = "/Users/fatihyilmaz/Desktop/data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        ReusableMethods.bekle(2);
        Workbook workbook = WorkbookFactory.create(fis);
        String email =  workbook.getSheet("data").getRow(1).getCell(0).toString();
        System.out.println("email = " + email);
        ReusableMethods.bekle(2);
        String password = workbook.getSheet("data").getRow(1).getCell(1).toString();
        System.out.println("password = " + password);
        ReusableMethods.bekle(2);
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACArUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());




    }
}
