import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.ScoreDatas;
import com.hxzy.mapper.DayexamDtoMapper;
import com.hxzy.service.ScoreService;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration
public class Testdsg {
    @Autowired
    ScoreService scoreService;
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
}
