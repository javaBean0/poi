package poi.student.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import poi.student.domain.Student;
import poi.student.service.StudentService;
import utils.ExcelExportUtil;
import utils.ExcelImportUtil;
import utils.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    public ResponseResult findAll() {
        Student student = new Student();
        List<Student> students = studentService.findAll(student);
        return ResponseResult.ok(students);
    }

    @RequestMapping("/import")
    public void importt(@RequestParam(value = "file") MultipartFile file,
                        HttpServletRequest req, HttpServletResponse resp) throws Exception {

        File file1 = new File("F:\\Browser Download\\Google\\学生信息表1557212313155.xls");

        List<Student> students = ExcelExportUtil.fileToList(file1);

        int a = studentService.insertList(students);
        System.out.println("result : " + a);

    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Student> list = studentService.findAll(new Student());

        //excel标题
        String[] title = {"学号", "姓名", "密码", "班级id", "分数"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";
        String[][] content = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Student obj = list.get(i);
            content[i][0] = String.valueOf(obj.getSid() == null ? 0 : obj.getSid());
            content[i][1] = obj.getUsername().toString();
            content[i][2] = obj.getPassword().toString();
            content[i][3] = obj.getSclass().toString();
            content[i][4] = String.valueOf(obj.getScore() == null ? 0 : obj.getScore());

        }

        System.out.println(content);
        //创建HSSFWorkbook

        HSSFWorkbook wb = ExcelImportUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
