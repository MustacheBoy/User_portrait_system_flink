package com.protrait.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String getYearbasebyAge(String age) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); //设置当前时间
        calendar.add(Calendar.YEAR, -Integer.valueOf(age));//计算是那个年代
        Date newdate = calendar.getTime();  //取出这个时间
        DateFormat dateFormat = new SimpleDateFormat("yyyy"); //转成字符串
        String newdatestring = dateFormat.format(newdate);
        Integer newdateinteger = Integer.valueOf(newdatestring);

        String yearbasetype = "未知";

        if (newdateinteger >= 1940 && newdateinteger < 1950) {
            yearbasetype = "40后";
        } else if (newdateinteger >= 1950 && newdateinteger < 1960) {
            yearbasetype = "50后";
        } else if (newdateinteger >= 1960 && newdateinteger < 19750) {
            yearbasetype = "60后";
        } else if (newdateinteger >= 1970 && newdateinteger < 1980) {
            yearbasetype = "70后";
        } else if (newdateinteger >= 1980 && newdateinteger < 1990) {
            yearbasetype = "80后";
        } else if (newdateinteger >= 1990 && newdateinteger < 2000) {
            yearbasetype = "90后";
        } else if (newdateinteger >= 2000 && newdateinteger < 2010) {
            yearbasetype = "00后";
        } else if (newdateinteger >= 2010) {
            yearbasetype = "10后";
        }
        return yearbasetype;
    }
}

