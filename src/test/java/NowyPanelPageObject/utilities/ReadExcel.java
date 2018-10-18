package NowyPanelPageObject.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\daneTesty.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook (fis);
        XSSFSheet sheet = workbook.getSheet("vouchery");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);

        System.out.println(sheet.getRow(1).getCell(0));

    }

}
