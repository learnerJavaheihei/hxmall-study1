package com.hxzy.service;

import java.util.List;

public interface FirstPageUtilService {

    //通过具体某一天去查学员的数量
    List<Integer> getStuNumByDate();

    //通过具体某一天去查班级的数量
    List<Integer> getGradeNumByDate();

    //通过具体某一天去查投诉的数量
    List<Integer> getComplaintNumByDate();

    //通过具体某一天去查项目的数量
    List<Integer> getProjectNumByDate();

    List<String> getTiles();

}
