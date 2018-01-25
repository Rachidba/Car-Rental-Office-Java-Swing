package Controller;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class ExcelExporter {
    private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;


    public static boolean export(String[] titles, Vector<String[]> dat, String fileName) {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Sheet");

        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);

        int rowNum = 2;
        //For titles row
        Row row = sheet.createRow(rowNum++);
        int cellNum = 2;
        for (Object obj : titles) {
            Cell cell = row.createCell(cellNum++);
            cell.setCellValue((String)obj);
            cell.setCellStyle(style);
        }
        //For the liste
        for (int i = 0; i < dat.size(); i++) {
            row = sheet.createRow(rowNum++);
            Object [] objArr = dat.get(i);
            int cellnum = 2;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof Date)
                    cell.setCellValue((Date)obj);
                else if(obj instanceof Boolean)
                    cell.setCellValue((Boolean)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
            }
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File(fileName));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
