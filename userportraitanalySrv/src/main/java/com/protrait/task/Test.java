package com.protrait.task;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Test {
    public static void main(String[] args) {
        final ParameterTool parmas =ParameterTool.fromArgs(args);

        final ExecutionEnvironment env =ExecutionEnvironment.getExecutionEnvironment();

        env.getConfig().setGlobalJobParameters(parmas);

        DataSet<String> text = env.readTextFile(parmas.get("input"));
        DataSet map =text.flatMap(null);
        DataSet reduce = map.groupBy("groupbyfield").reduce(null);

        try {
            env.execute("test");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
