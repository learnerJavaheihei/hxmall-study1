package com.hxzy.entity;

import lombok.Data;

import java.util.List;

@Data
public class ScoreDatas {

    private List<List<Object>> scoreDay;

    private List<List<Object>> scoreWeek;

    private List<List<Object>> scoreStage;

}
