package com.wlwz.action;

import com.wlwz.dao.IUserDAO;
import com.wlwz.dataProcesse.DataProcessFactory;
import com.wlwz.util.ReqRes;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;


/**
 * Created by yanzi on 2016/3/9.
 */

@Component("uploadFileAction")
@Scope("prototype")
public class UploadFileAction extends BaseAction{
    private File file;
    private String methodType;
    private String  minValue;
    private String  maxValue;

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    private String yResult;

    private DataProcessFactory dataProcessFactory;
    @Resource(name = "dataProcessFactory")
    public void setDataProcessFactory( DataProcessFactory dataProcessFactory) {
        this.dataProcessFactory = dataProcessFactory;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


    public String dealWithData()throws Exception {
        System.out.println(this.methodType);


        BufferedReader bf = new BufferedReader(new FileReader(this.getFile()));
        String readLine ;
        StringBuffer dataStr = new StringBuffer();

        while((readLine = bf.readLine())!=null){
            dataStr.append(readLine);
        }

        System.out.println(dataStr);

        String dataS = dataStr.toString().replaceAll("\\r","").replaceAll("\\n", "").replaceAll("  ", "");

        if(methodType.equals("不处理")){
            yResult = "[{name:'初值',data:[" + dataS + "]}]";
            HttpSession ses = ReqRes.getSession();
            ses.setAttribute("yResult",yResult);
            file.delete();
            return SUCCESS;
        }

        String resultS = dataProcessFactory.processData(methodType,dataS,minValue,maxValue);

//        yResult = "[{name:'初值', data:[0.0176938,0.186418,-0.443274,0.0785817]},{name:'结果', data:[0.0176938,0.186418,-0.443274,0.0785817]}]";

        if(resultS == null){
            return INPUT;
        }

        yResult = "[{name:'初值',data:[" + dataS + "]},{name:'结果',data:[" + resultS + "]}]";
        System.out.println(yResult);
        HttpSession ses = ReqRes.getSession();
        ses.setAttribute("yResult",yResult);

        file.delete();
        return SUCCESS;
    }

}
