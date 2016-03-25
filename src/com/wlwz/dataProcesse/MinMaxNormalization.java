package com.wlwz.dataProcesse;

import com.wlwz.util.StringUtils;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by yanzi on 2016/3/22.
 */
@Component("minMaxNormalization")
public class MinMaxNormalization extends AbstractBaseProcess {
    @Override
    public String processData(ArrayList<Double> dataArr, String minValue, String maxValue) {
        if(maxValue == null || minValue == null|| maxValue.length() == 0 || minValue.length() == 0)
            return null;

        Double maxV = getMax(dataArr);
        Double minV = getMin(dataArr);
        if(maxV == null || minV == null)
            return null;

        Double maxN = Double.valueOf(maxValue);
        Double minN = Double.valueOf(minValue);

        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat dcmFmt = new DecimalFormat("0.00000");
        for(int i = 0; i < dataArr.size()-1; i++){
            stringBuffer.append(dcmFmt.format(getNormalizeValue(dataArr.get(i),maxV,minV,maxN,minN)));
            stringBuffer.append(",");
        }
        stringBuffer.append(dcmFmt.format(getNormalizeValue(dataArr.get(dataArr.size()-1),maxV,minV,maxN,minN)));

        return  stringBuffer.toString();
    }

    private Double getNormalizeValue(Double data,Double maxV,Double minV,Double maxN,Double minN ){
        return ((data-minV)/(maxV-minV))*(maxN-minN)+minN;
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

    public Double getMin(ArrayList<Double> dataArr) {
        if (dataArr == null || dataArr.size() == 0)
            return null;
        Double min = dataArr.get(0);
        for(int i = 0; i < dataArr.size(); i++){
            if(dataArr.get(i) < min){
               min = dataArr.get(i);
            }
        }
        return  min;
    }

    @Override
    public String processData(ArrayList<Double> dataArr) {
        return null;
    }
}
