package com.wlwz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wlwz.depoly.PropertyData;
import com.wlwz.depoly.depolyTable;
import com.wlwz.service.IDepolyService;
import com.wlwz.service.IUserstateService;

@Component("depolyService")
public class DepolyServiceImply implements IDepolyService{
	private IUserstateService userstateService;

	@Resource(name = "userstateService")
	public void setUserstateService(IUserstateService userstateService) {
		this.userstateService = userstateService;
	}
	
	
	
	public void depolyWriteProperty(Integer userGroup, String[] depoly){
		PropertyData.setPropertyFile(userGroup);
	    int depolyNum = getMyInt(depoly.length,6);			   
	    PropertyData.writeData("depolyNum", Integer.toString(depolyNum));
	    System.out.println("配置参数的个数是："+depolyNum);		
			
		for(int i = 0; i < depolyNum; i++){
			int num = Integer.valueOf(depoly[i*6]);
			PropertyData.writeData("depolyName_"+num, depoly[i*6+1]);
	//		System.out.print(PropertyData.readData("depolyName_"+depoly[i*6]));
			PropertyData.writeData("depolyDataType_"+num, depoly[i*6+2]);	
			PropertyData.writeData("depolyDataLength_"+num, depoly[i*6+3]);
			
			//确保数组引用不越界
			if ((i*6+4 < depoly.length) && (depoly[i*6+4] != null)){
			   PropertyData.writeData("depolyUpper_"+num, depoly[i*6+4]);
			}
			if((i*6+5 < depoly.length) && (depoly[i*6+5] != null)){
				PropertyData.writeData("depolyLower_"+num, depoly[i*6+5]);
			}
		}	

		
	}
	public void depolyDatabase(Integer userGroup) {
		try{
		depolyTable dbDepoly = new depolyTable();
		dbDepoly.setUsergroup(userGroup);
		dbDepoly.createDepolyTable();
	    userstateService.changeState(userGroup, 3);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getMyInt(int a,int b) {//商向上取整，因为得到的depolyStr如果最后一个参数没有设定上下限的话，它的长度不是6的倍数
		return(((double)a/(double)b)>(a/b)?a/b+1:a/b);
		}

}
