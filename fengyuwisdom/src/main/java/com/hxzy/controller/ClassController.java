package com.hxzy.controller;


import com.hxzy.entity.GradeDto;
import com.hxzy.service.ClassService;
import com.hxzy.util.ExportExcel;
import com.hxzy.util.RUtil;
import com.hxzy.vo.PageBean;
import com.hxzy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/class/")
public class ClassController {
    @Autowired
    private ClassService classService;

    //分页
    @RequestMapping("/all.do")
    @ResponseBody
    public PageBean queryAll() {
        return classService.queryList();
    }

    //搜索
    @RequestMapping("/select.do")
    @ResponseBody
    public PageBean selectAll(@RequestParam("name") String name, @RequestParam("address") String address) {

        return classService.selectAll(name, address);
    }

    //添加
    @RequestMapping(value = "/insert.do", method = RequestMethod.POST)
    @ResponseBody
    public R insertAll(GradeDto record) {
        return classService.insertData(record);
    }

    //编辑
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public R updateAlla(GradeDto gradeDto) {
        System.out.println(gradeDto);

        if (gradeDto != null) {
            classService.updateData(gradeDto);
            return RUtil.ok();
        } else {
            return RUtil.fail();
        }

    }

    //批量删除
    @RequestMapping(value = "/deleteAll.do/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public R deleteAllCu(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");

        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            idList.add(Integer.parseInt(split[i]));
        }

        return classService.deleteALL(idList);
    }


    //删除
    @RequestMapping("/delete.do")
    @ResponseBody
    public R deleteAll(Integer id) {
        return classService.deleteDate(id);
    }

    //导出文件
    @RequestMapping("/downloadFile.do")
    public void  downloadFile(HttpServletRequest request, HttpServletResponse response){
        //获取到数据集
        List<GradeDto> gradeDtos = classService.exportAdminInfo();
        ExportExcel.exportFile("gradeinfo",response,GradeDto.class,gradeDtos);
    }

}








