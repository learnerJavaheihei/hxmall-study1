import com.hxzy.controller.FlowDatasController;
import com.hxzy.entity.*;
import com.hxzy.mapper.DayexamDtoMapper;
import com.hxzy.mapper.InfoDtoMapper;
import com.hxzy.service.FirstPageDatasService;
import com.hxzy.service.FirstPageUtilService;
import com.hxzy.service.ScoreService;
import com.hxzy.service.StudentDDService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration
public class Testdsg {
    @Autowired
    ScoreService scoreService;
    @Autowired
    StudentDDService studentDDService;
    @Autowired
    InfoDtoMapper infoDtoMapper;
    @Autowired
    FirstPageDatasService firstPageDatasService;
    @Autowired
    FlowDatasController flowDatasController;

    @Autowired
    FirstPageUtilService firstPageUtilService;
    @Test
    public void testdsf(){
        ScoreDatas studentDayDatas = scoreService.getStudentDayDatas();
        List<List<Object>> scoreDay = studentDayDatas.getScoreDay();
        System.out.println(Arrays.asList(scoreDay));
        System.out.println(scoreDay.size());
        //scoreDay.forEach(i-> i.forEach(j-> System.out.println(j)));
        for (List<Object> objectList : scoreDay) {
            System.out.println(Arrays.asList(objectList));
            //objectList.forEach(i-> System.out.println(i));
        }
    }
    @Test
    public void fdyh(){
        ScoreDatas studentWeekDatas = scoreService.getStudentWeekDatas();
        List<List<Object>> scoreDay = studentWeekDatas.getScoreWeek();
        System.out.println(Arrays.asList(scoreDay));
        System.out.println(scoreDay.size());
        //scoreDay.forEach(i-> i.forEach(j-> System.out.println(j)));
        for (List<Object> objectList : scoreDay) {
            System.out.println(Arrays.asList(objectList));
            //objectList.forEach(i-> System.out.println(i));
        }
    }
    @Test
    public void reh(){
        ScoreDatas studentStageDatas = scoreService.getStudentStageDatas();
        List<List<Object>> scoreDay = studentStageDatas.getScoreStage();
        System.out.println(Arrays.asList(scoreDay));
        System.out.println(scoreDay.size());
        //scoreDay.forEach(i-> i.forEach(j-> System.out.println(j)));
        for (List<Object> objectList : scoreDay) {
            System.out.println(Arrays.asList(objectList));
            //objectList.forEach(i-> System.out.println(i));
        }
    }
    @Test
    public void dsf(){
        List<ComplaintData> complaint = infoDtoMapper.getComplaint();
        List<GradeData> grade = infoDtoMapper.getGrade();
        List<ProjectData> project = infoDtoMapper.getProject();
        List<StudentDDto> studentD = infoDtoMapper.getStudentD();
        System.out.println("1=>"+Arrays.asList(complaint));
        System.out.println("2=>"+Arrays.asList(grade));
        System.out.println("3=>"+Arrays.asList(project));
        System.out.println("4=>"+Arrays.asList(studentD));
    }

//    @Test
//    public void stest(){
//        List<String> dates = firstPageDatasService.getDates();
//        System.out.println("1=>"+Arrays.asList(dates));
//    }
//
//    @Test
//    public void sgdg(){
//        ScoreDatas studentDayDatas = scoreService.getStudentDayDatas();
//    }
//
//    @Test
//    public void tgewtg(){
//        List<String> dates = firstPageDatasService.getDates();
//        System.out.println("1=>"+Arrays.asList(dates));
//
//        List<Integer> stuNumByDate = firstPageUtilService.getStuNumByDate();
//        System.out.println("1=>"+Arrays.asList(stuNumByDate));
//
//        List<Integer> gradeNumByDate = firstPageUtilService.getGradeNumByDate();
//        System.out.println("1=>"+Arrays.asList(gradeNumByDate));
//
//        List<Integer> complaintNumByDate = firstPageUtilService.getComplaintNumByDate();
//        System.out.println("1=>"+Arrays.asList(complaintNumByDate));
//
//        List<Integer> projectNumByDate = firstPageUtilService.getProjectNumByDate();
//        System.out.println("1=>"+Arrays.asList(projectNumByDate));
//    }

    @Test
    public void dsghsd(){
        List<Map<String, Object>> attributes = firstPageDatasService.getAttributes();
        System.out.println(Arrays.asList(attributes));
    }
}
