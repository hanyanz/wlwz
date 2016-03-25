package com.wlwz.dataProcesse;

import java.util.ArrayList;

/**
 * Created by yanzi on 2016/3/9.
 */
public abstract class AbstractBaseProcess {
    public abstract String processData(ArrayList<Double> dataArr);
    public abstract String processData(ArrayList<Double> dataArr,String minValue,String maxValue);

}
