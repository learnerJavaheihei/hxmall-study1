package com.hxzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxzy.entity.Student;
import com.hxzy.listener.EasyExcelStuListener;
import com.hxzy.service.StudentService;
import com.hxzy.util.ExportExcel;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*分页查询*/
    @RequestMapping("/all.do")
    @ResponseBody
    public PageBean queryAll() {
        return studentService.querylist();
    }


    @RequestMapping("/downloadFile.do")
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        //获取数据
        List<Student> students = studentService.exportStudentInfo();
        ExportExcel.exportFile("studentinfo", response, Student.class, students);
    }

    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    @ResponseBody
    public R uploadFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            InputStream is = file.getInputStream();
            EasyExcel.read(is, Student.class,
                            new EasyExcelStuListener(studentService))
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .doRead();
            RUtil.ok();
        }
        return RUtil.fail();
    }

    @RequestMapping(value = ("/insert.do"),method = RequestMethod.POST)
    @ResponseBody
    public R insert(@RequestBody Student record) {
        record.setCtime(new java.sql.Date(new Date().getTime()));
        return studentService.insert(record);
    }

    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public R delete(Integer id) {
        return studentService.delete(id);
    }

    @RequestMapping(value = "/select.do")
    @ResponseBody
    public PageBean selectAll(@RequestParam("no") String no,
                              @RequestParam("name") String name,
                              @RequestParam("sex") String sex,
                              @RequestParam("hometown") String hometown,
                              @RequestParam("education") String education,
                              @RequestParam("gradeName") String gradeName) {
        int parseInt=0;
        if(sex!=""||sex.length()>0){
            parseInt = Integer.parseInt(sex);
        }else {
            parseInt=0;
        }
        return studentService.selectAll(name, no, parseInt, hometown, education, gradeName);
    }

    @RequestMapping(value = "/deleteAll.do/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            id.add(Integer.parseInt(split[i]));
        }
        return studentService.deleteAll(id);
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public R updateAlla(Student student) {
        student.setCtime(new java.sql.Date(new Date().getTime()));
        return studentService.updateData(student);

    }
}
