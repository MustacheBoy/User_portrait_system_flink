package com.protrait.reduce;

import com.protrait.entity.YearBase;
import org.apache.flink.api.common.functions.ReduceFunction;

public class YearBaseReduce implements ReduceFunction<YearBase> {

    @Override
    public YearBase reduce(YearBase yearBase, YearBase t1) throws Exception {

        String yeartype = yearBase.getYeartype();
        Long count1 = yearBase.getCount();
        Long coung2 = t1.getCount();

        YearBase finalyearBase = new YearBase();

        finalyearBase.setYeartype(yeartype);
        finalyearBase.setCount(count1+coung2);
        return finalyearBase;
    }
}
