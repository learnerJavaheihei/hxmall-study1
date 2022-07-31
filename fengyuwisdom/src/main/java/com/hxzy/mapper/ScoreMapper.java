package com.hxzy.mapper;

import com.hxzy.entity.DayexamDto;
import com.hxzy.entity.Stageexam;
import com.hxzy.entity.Weekexam;
import java.util.List;

public interface ScoreMapper {

    List<DayexamDto> getStudent();

    List<Weekexam> getWeekexam();

    List<Stageexam> getStageexam();
}
