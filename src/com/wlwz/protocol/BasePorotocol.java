package com.wlwz.protocol;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import com.wlwz.dao.IDeviceDAO;
import com.wlwz.dao.IUserDAO;
import com.wlwz.entity.Device;
import com.wlwz.entity.User;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IRunningdataService;

public abstract class BasePorotocol {

	protected String IMEI; // IMEI序列号
	protected String userName;
	protected String commandId; // 命令字
	protected Integer dataLength; // 数据长度
	protected String dataBody; // 数据段
	protected String CRC; // CRC校验码

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	public String getDataBody() {
		return dataBody;
	}

	public void setDataBody(String dataBody) {
		this.dataBody = dataBody;
	}

	public String getCRC() {
		return CRC;
	}

	public void setCRC(String cRC) {
		CRC = cRC;
	}
	

	public void decode(String proto) {
		IMEI = ProtocolUtils.getImei(proto);
		userName = analyticASCII(ProtocolUtils.getUserName(proto));
		commandId = ProtocolUtils.getCommandId(proto);
		dataLength = Integer.parseInt(ProtocolUtils.getDataLength(proto), 16);
		dataBody = ProtocolUtils.getDataBody(proto);
		CRC = ProtocolUtils.getCRC(proto);
		System.out.println("用户名为："+userName);
		System.out.println("十进制IMEI序列号===" + IMEI);
		System.out.println("数据串为：" + dataBody + ";数据串长度=" + dataBody.length()
				/ 2 + "字节");
	}

	public void messDecode(String proto,IRunningdataService runningdataService) {
		decode(proto);
		//通过用户名得到userGroup
		System.out.println(userName);
	
	   process(IMEI, userName,dataBody, runningdataService);
		
	}

	
	protected void process(String IMEI,String userName, String dataBody,IRunningdataService runningdataService) {
	}

	

	// 解码ASCII数据字符串,(IMEI和经纬度)每次剪切两位(ASCII码)还原为对应数字,然后拼接成字符串-即为发送的原始数据
	protected String analyticASCII(String data) {
		String test = "";
		int length = (int) (data.length() / 2);
		// 当IMEI按ASCII值传输时
		int a = 0;
		int b = 2;
		for (int i = 0; i < length; i++) {
			try {
				String cut = data.substring(a, b);
				// 丢掉数据为空的部分
				if (!cut.equals("00")) {
					Integer y = Integer.parseInt(cut, 16);
					test += (char) y.intValue();
				}
				a += 2;
				b += 2;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return test;
	}


	// 处理6个字节的时间字符串，返回时间格式
	protected Timestamp geTimestamp(String data) {
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;
		hour = Integer.parseInt(data.substring(0, 2), 16) + 8;
		minute = Integer.parseInt(data.substring(2, 4), 16);
		second = Integer.parseInt(data.substring(4, 6), 16);
		day = Integer.parseInt(data.substring(6, 8), 16);
		month = Integer.parseInt(data.substring(8, 10), 16);
		year = Integer.parseInt(data.substring(10, 12), 16);
		month -= 1;
		year += (2000 - 1900);
		Timestamp time = new Timestamp(year, month, day, hour, minute, second,
				0);
		return time;
	}

	

}
