package com.wlwz.dataProcesse;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by yanzi on 2016/3/9.
 */
@Component("normalizedProcess")
public class NormalizedProcess extends AbstractBaseProcess {
    @Override
    public String processData(ArrayList<Double> dataArr) {
        Double max = getMax(dataArr);
        if(max == null)
            return  null;

        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat dcmFmt = new DecimalFormat("0.00000");
        for(int i = 0; i < dataArr.size()-1; i++){
           stringBuffer.append(dcmFmt.format(dataArr.get(i)/max));
            stringBuffer.append(",");
        }
        stringBuffer.append(dcmFmt.format(dataArr.get(dataArr.size()-1)/max));
        return stringBuffer.toString();
    }

    public Double getMax(ArrayList<Double> dataArr) {
        if (dataArr == null || dataArr.size() == 0)
            return null;
        Double max = dataArr.get(0);
        for(int i = 0; i < dataArr.size(); i++){
            if(dataArr.get(i) > max){
                max = dataArr.get(i);
            }
        }
        return  max;
    }

    @Override
    public String processData(ArrayList<Double> dataArr, String minValue, String maxValue) {
        return null;
    }
}
