package com.hxzy.service;

import com.hxzy.entity.StudentSexDatas;

import java.util.List;

public interface StudentDDService {

    StudentSexDatas getStudentSex();

    StudentSexDatas getStudentHometown();

    StudentSexDatas getStudentEducation();

    Integer getCount();

    Integer getGradeConut();

    Integer getComplaintConut();

    Integer getProjectConut();
}
