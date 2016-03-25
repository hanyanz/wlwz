package com.wlwz.dataProcesse;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by yanzi on 2016/3/9.
 */

@Component("dataProcessFactory")
public class DataProcessFactory {
    private String methodType;
    private String dataStr;
    private AbstractBaseProcess baseMethod;

    private  NormalizedProcess normalizedProcess;
    @Resource(name = "normalizedProcess")
    public void setNormalizedProcess( NormalizedProcess normalizedProcess) {
        this.normalizedProcess = normalizedProcess;
    }

    private  MinMaxNormalization minMaxNormalization;
    @Resource(name = "minMaxNormalization")
    public void setMinMaxNormalization(  MinMaxNormalization minMaxNormalization) {
        this.minMaxNormalization = minMaxNormalization;
    }

    private HaarProcess haarProcess;
    @Resource(name = "haarProcess")
    public void setHaarProcess(HaarProcess haarProcess){
        this.haarProcess = haarProcess;
    }


    public String processData(String methodType, String dataStr,String minValue, String maxValue){
        this.methodType = methodType;
        this.dataStr = dataStr;
        this.baseMethod = getProcessMethod();
        if(baseMethod == null)
            return  null;
        if(methodType.equals("数据标准化")){
            return baseMethod.processData(checkDataStr(),minValue,maxValue);
        }else{
            return  baseMethod.processData(checkDataStr());
        }
    }


    private ArrayList<Double> checkDataStr(){
        if(dataStr == null ||  baseMethod == null)
            return null;
        String[] dataSArr = dataStr.split(",");
        ArrayList<Double> dataArr = new ArrayList<>();
        Double data = null;

        for(int i = 0; i < dataSArr.length; i++){
            try{
                data = Double.parseDouble(dataSArr[i]);
            }catch (Exception e){
                System.out.println("error when checking " + e.getMessage());
            }

            if(data != null)
                dataArr.add(data);
        }

        return dataArr;
    }

    private AbstractBaseProcess getProcessMethod(){
        switch (methodType){
            case "归一化":
                return normalizedProcess;
            case "数据标准化":
                return minMaxNormalization;
            case "噪声平滑":
                return haarProcess;
            default:
                return  null;
        }
    }
}
