package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {

    public static int getRowCount() {
        try {
            FileInputStream fis = new FileInputStream("testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int count = sheet.getLastRowNum();

            wb.close();
            return count;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getData(int row) {
        try {
            FileInputStream fis = new FileInputStream("testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            String data = sheet.getRow(row).getCell(0).getStringCellValue();

            wb.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}