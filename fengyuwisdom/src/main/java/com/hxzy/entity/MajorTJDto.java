package com.hxzy.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MajorTJDto {

    private List<String> sexs;
    private List<Map<String,Object>> values;
}
