package com.hxzy.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class StudentSexDatas {

    private List<String> sexNames;

    private List<Map<String,Object>> sexNamesObject;

    private List<String> hometownNames;

    private List<Map<String,Object>> hometownNamesObject;

    private List<String> educationNames;

    private List<Map<String,Object>> educationNamesObject;


}
