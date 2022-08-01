package com.hxzy.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FlowDatas {

    private List<String> clicks;

    private List<String> times;

    private List<Map<String,Object>> mapData;
}
