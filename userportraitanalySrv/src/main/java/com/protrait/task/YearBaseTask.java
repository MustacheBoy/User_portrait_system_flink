package com.protrait.task;

import com.protrait.entity.YearBase;
import com.protrait.map.YearBaseMap;
import com.protrait.reduce.YearBaseReduce;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.List;

public class YearBaseTask {

    public static void main(String[] args) {
        final ParameterTool parmas =ParameterTool.fromArgs(args);

        final ExecutionEnvironment env =ExecutionEnvironment.getExecutionEnvironment();

        env.getConfig().setGlobalJobParameters(parmas);

        DataSet<String> text = env.readTextFile(parmas.get("input"));


        DataSet<YearBase> mapresult =  text.map(new YearBaseMap());

        DataSet<YearBase> reduceresult = mapresult.groupBy("flied").reduce(new YearBaseReduce());

        try {
            List<YearBase> resultlist =  reduceresult.collect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
