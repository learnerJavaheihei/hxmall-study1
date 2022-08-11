package com.hxzy.service.impl;


import com.hxzy.entity.ComplaintData;
import com.hxzy.entity.GradeData;
import com.hxzy.entity.ProjectData;
import com.hxzy.entity.StudentDDto;
import com.hxzy.mapper.InfoDtoMapper;
import com.hxzy.service.GetDatesService;
import com.hxzy.util.DateSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GetDatesServiceImpl implements GetDatesService {

    @Autowired
    InfoDtoMapper infoDtoMapper;

    @Override
    public List<String> getDates() {
        List<ComplaintData> complaint = infoDtoMapper.getComplaint();
        List<GradeData> grade = infoDtoMapper.getGrade();
        List<ProjectData> project = infoDtoMapper.getProject();
        List<StudentDDto> studentD = infoDtoMapper.getStudentD();
        List<String> dates=new ArrayList<>();
        for (int i = 0; i < complaint.size(); i++) {
            if(complaint.get(i).getCtime()!=null){
                String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(complaint.get(i).getCtime());
                if(!dates.contains(dodateFormat)){
                    dates.add(dodateFormat);
                }
            }
        }
        for (int i = 0; i < grade.size(); i++) {
            if(grade.get(i).getSdate()!=null){
                String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(grade.get(i).getSdate());
                if(!dates.contains(dodateFormat)){
                    dates.add(dodateFormat);
                }
            }
        }
        for (int i = 0; i < project.size(); i++) {
            if(project.get(i).getCtime()!=null){
                String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(project.get(i).getCtime());
                if(!dates.contains(dodateFormat)){
                    dates.add(dodateFormat);
                }
            }
        }
        for (int i = 0; i < studentD.size(); i++) {
            if(studentD.get(i).getCtime()!=null){
                String dodateFormat = FirstPageUtilServiceImpl.dodateFormat(studentD.get(i).getCtime());
                if(!dates.contains(dodateFormat)){
                    dates.add(dodateFormat);
                }
            }
        }
        return DateSort.sort(dates);
    }
}
