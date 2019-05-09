package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import poi.student.domain.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/7
 **/
public class ExcelExportUtil {

    public static  List<Student> fileToList(File file) throws IOException {
        List<Student> list = new ArrayList<>();
        //获取文件名
        Workbook workbook = null;
        String fileName = file.getName();
        FileInputStream mStream = new FileInputStream(file);
        //boolean xls = file.getName().endsWith("xls");
        if (file.getName().endsWith("xls")) {
            workbook = new HSSFWorkbook(mStream);
        } else {
            workbook = new XSSFWorkbook(mStream);
        }
        //获取第一个表
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();//获取总行数
        int clos = sheet.getRow(0).getPhysicalNumberOfCells();//获取总列数
        for (int i = 1; i < rows+1; i++) {

            for (int j = 0; j < clos; j++) {
                //第一个是列数，第二个是行数
                String sid = sheet.getRow(i).getCell(j++).getStringCellValue();
                String username = sheet.getRow(i).getCell(j++).getStringCellValue();
                String password = sheet.getRow(i).getCell(j++).getStringCellValue();
                String sclass = sheet.getRow(i).getCell(j++).getStringCellValue();
                String score = sheet.getRow(i).getCell(j++).getStringCellValue();

                Student student = new Student(Integer.parseInt(sid),
                        username, password, sclass, Integer.parseInt(score));

                list.add(student);

            }
        }
        return list;
    }

}
