package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
   private Workbook workbook;
   //sadece bu classla islem yapilsin diye private yaptik.
   private Sheet sheet;
   private String path;

    //Constructor :Excel pathine ve exceldeki sayfaya ulasmak icin 2 parametreli constructor olusturduk.
    public ExcelUtils(String path,String sheetName){
        this.path = path;

        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Satir ve sutun sayilari girildiginde o hucredeki veriyi return eder.
    public String getCellData(int rowNum,int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }
    //Exceldeki satir sayisini return eder
    public  int rowCount(){
        return sheet.getLastRowNum();

    }//Exceldeki sutun sayisini return eder
    public  int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }
}
