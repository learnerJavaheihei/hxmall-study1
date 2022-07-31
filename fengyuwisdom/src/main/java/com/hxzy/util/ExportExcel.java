package com.hxzy.util;

import com.alibaba.excel.EasyExcel;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExportExcel {
    public static void exportFile(String filename, HttpServletResponse response, Class clazz, List list){
        response.setHeader("Content-Type", "application/x-msdownload");
        response.setHeader("Content-Disposition","attachment;filename="+filename+System.currentTimeMillis()+".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(),clazz).sheet(filename).doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
