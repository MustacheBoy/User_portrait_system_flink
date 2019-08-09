package com.protrait.map;


import com.protrait.entity.YearBase;
import com.protrait.util.DateUtils;
import com.protrait.util.HbaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

public class YearBaseMap implements MapFunction<String, YearBase> {

    @Override
    public YearBase map(String s) throws Exception {
        if(StringUtils.isBlank(s)){//如果为空  返回
            return null;
        }

        String[] userinfos = s.split(",");
        String userid = userinfos[0];
        String username = userinfos[1];
        String sex = userinfos[2];
        String telphone = userinfos[3];
        String email = userinfos[4];
        String age = userinfos[5];
        String registerTime = userinfos[6];
        String usetype = userinfos[7];// 终端类型：0、PC端；1、移动端；2、小程序端

        String yearbasetype= DateUtils.getYearbasebyAge(age);
        String tablename = "";
        String rowkey ="";
        String famliyname = "";
        String colum = "";

        HbaseUtils.putdata(tablename,rowkey,famliyname,colum,yearbasetype);

        YearBase yearBase = new YearBase();

        String groupflied = "yearbase=="+yearbasetype;
        yearBase.setYeartype(yearbasetype);
        yearBase.setCount(1l);
        yearBase.setGroupflied(groupflied);

        return yearBase;
    }
}
