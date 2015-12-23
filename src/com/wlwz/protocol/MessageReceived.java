package com.wlwz.protocol;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.annotation.Resource;

import com.wlwz.depoly.PropertyData;
import com.wlwz.service.IRunningdataService;
import com.wlwz.service.impl.RunningdataServiceImpl;

public class MessageReceived extends BasePorotocol {
	
	private Timestamp createTime; // 下位机发送数据时间
	private String sql;  //用来向数据库中插入运行数据的sql语句
	private int userGroup;
	public MessageReceived() {

	}

	public Timestamp getCreateTime() {
		return createTime;
	}
	public String getSql(){
		return sql;
	}
	public int getUserGroup(){
		return userGroup;
	}
	
	

	// 通过用户上发信息可得到对应的设备Id和用户组号，由此可确定用户身份，然后相应地解析dataBody，得到用于保存记录的sql语句
	protected void process(String IMEI,String userName, String dataBody,IRunningdataService runningdataService) {
	       	System.out.println(IMEI+" "+userName);
	       
	       	/*一定不要用下面这条代码，因为new了一个对象后就无法使用spring的依赖注入了，
	       	//会导致下面的操作无法进行，所以我改进了用方法参数中就传入这个对象
		//    IRunningdataService runningdataService = new RunningdataServiceImpl();*/
		
		    int[] identifyInfo =  runningdataService.getDeviceIdByIdtify(IMEI, userName);
		    int deviceId = identifyInfo[0];
		    userGroup = identifyInfo[1];
		    if(userGroup != -1 && deviceId != -1){
			    PropertyData.setPropertyFile(userGroup);
			    int dataNum = Integer.valueOf(PropertyData.readData("depolyNum"));
			    System.out.println(dataNum);
				createTime = new Timestamp(System.currentTimeMillis());
				System.out.println("下位机发送数据时间====" + createTime);
				StringBuffer sql1 = new StringBuffer("INSERT INTO runningdata" + userGroup + " (deviceId,createTime,");
				for(int i = 1; i <= dataNum; i++){
					sql1.append("field_"+i+",");
				}
				sql1 = sql1.deleteCharAt(sql1.length()-1);
				sql1.append(") VALUES(" + deviceId + ", '" + createTime +"'" );
				
				int j = 0;
				String dataStr = "";
				for(int i =1; i <= dataNum; i++){
					String depolyDataLengthName = "depolyDataLength_"+i;
					int length = Integer.valueOf(PropertyData.readData(depolyDataLengthName));
					if(j+length <= dataBody.length()){
					    dataStr = dataBody.substring(j,j+length);
					    //如果配置参数本来就是字符型
					    if(PropertyData.readData("depolyDataType_"+i).equals("varchar") ||PropertyData.readData("depolyDataType_"+i).equals("char" )){
						    sql1.append(", '"+dataStr + "'");
						 }
					    //如果配置参数为数值型(为统一标准，只用整型表示，浮点型请自动乘10^n,使其成为整数)
					    else{
					    	sql1.append(", '"+ Long.parseLong(dataStr,16) + "'");
					    }
						    j = j+length;
					}
				}
				sql1.append(");");
				System.out.println(sql1.toString());
				sql = sql1.toString();
				
		    }
		    else
		    	System.out.println("身份验证失败，数据无效");
		}


	
	
}
