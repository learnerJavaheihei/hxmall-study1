package com.hxzy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateSort {
    public static List<String> sort(List<String> dates){
        List<String> dateSort=new ArrayList<>();
        List<Date> dateList=new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String date : dates) {
            Date parse = null;
            try {
                parse = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //java.sql.Date date1 = new java.sql.Date(parse.getTime());
            dateList.add(parse);
        }
        Collections.sort(dateList);
        for (Date date : dateList) {
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();
            String format = simpleDateFormat1.format(date);
            int i = format.indexOf(" ");
            String substring = format.substring(0, i);
            dateSort.add(substring);
        }
        return dateSort;
    }
}
