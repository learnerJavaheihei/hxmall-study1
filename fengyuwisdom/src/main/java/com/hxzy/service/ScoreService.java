package com.hxzy.service;

import com.hxzy.entity.ScoreDatas;

public interface ScoreService {

    ScoreDatas getStudentDayDatas();

    ScoreDatas getStudentWeekDatas();

    ScoreDatas getStudentStageDatas();
}
