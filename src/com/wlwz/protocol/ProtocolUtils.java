/*
 *  Authors: zhong                                  |
 */
package com.wlwz.protocol;

import java.util.Calendar;
import java.util.Collection;

import org.apache.mina.core.session.IoSession;
import org.apache.regexp.RE;

import com.wlwz.service.IRunningdataService;
//import com.cnp.service.impl.Surv_sqlServiceImpl;

public class ProtocolUtils {
	// RTU发送含数据内容命令
	//zxy： fb+Imei+用户名+0x11+dataLength+dataBody+crc
	private static RE re = new RE("(FE|fe|fE|Fe)(\\w{20})(\\w{30})(\\w{2})(\\w{4})(.*)(\\w{2})");

	public static String getImei(String proto) {
		return re.getParen(2);
	}
    public static String getUserName(String proto){
    	return re.getParen(3);
    }
	public static String getCommandId(String proto) {
		return re.getParen(4);
	}

	public static String getDataLength(String proto) {
		return re.getParen(5);
	}

	public static String getDataBody(String proto) {
		return re.getParen(6);
	}
    //现在还没有实现这个CRC校验功能
	public static String getCRC(String proto) {
		return re.getParen(7);
	}

	// 将一个小于256的int数据转化为一个char
	public static char intToChar(int mess) {
		return (char) mess;
	}

	// 在已有char数组替换特定位置的char
	public static char[] replaceChar(char[] x, char[] y, int id) {
		for (int i = 0; i < x.length; i++) {
			y[id + i] = x[i];
		}
		return y;
	}

	// 这个函数是用来进行位运算的，主要为下面的计算CRC来服务
	public static int calcByte(int crc, char b) {
		int i;
		crc = crc ^ (int) b << 8;
		for (i = 0; i < 8; i++) {
			if ((crc & 0x8000) == 0x8000) {
				crc = crc << 1 ^ 0x1021;
			} else {
				crc = crc << 1;
			}
		}
		return crc & 0xffff;
	}

	// 这个函数是计算16位CRC码的函数，只要给出要校验的数组，以及数组长度，就可以返回16位CRC校验码
	public static int CRC16(char[] pBuffer, int length) {
		int wCRC16 = 0;
		int i;
		if ((pBuffer[0] == 0) || (length == 0)) {
			return 0;
		}
		for (i = 0; i < length; i++) {
			wCRC16 = calcByte(wCRC16, pBuffer[i]);
		}
		return wCRC16;
	}

	// CRC校验
	public static int CRCTest(String data) {
		int lengthCRC = data.length() / 2;
		char[] CRCTest = new char[lengthCRC];
		int a = 0;
		int b = 2;
		for (int i = 0; i < lengthCRC; i++) {
			CRCTest[i] = intToChar(Integer.parseInt(data.substring(a, b), 16));
			a += 2;
			b += 2;
		}
		return CRC16(CRCTest, lengthCRC);
	}

	public static BasePorotocol decode(IoSession session, String proto,
			IRunningdataService runningdataService) throws Exception {
		BasePorotocol bp = null;
		int commandId;
		String test;
		int CRC;
		if (re.match(proto)) {
			// System.out.println(getCommandId(proto));
			commandId = Integer.parseInt(getCommandId(proto), 16);
			System.out.println(commandId);
			 test = "fe"+getImei(proto)+getCommandId(proto)+getDataLength(proto)+getDataBody(proto);
			 CRC = Integer.parseInt(getCRC(proto),16);
			 System.out.println("CRC校验结果=="+CRCTest(test));
			 System.out.println("CRC校验结果=="+CRC);
			 if(CRCTest(test)==CRC){
			 System.out.println("CRC校验通过");
			 }
			switch (commandId) {
			case 17:
				bp = new MessageReceived();
				bp.messDecode(proto,runningdataService);
				MessageReceived m = (MessageReceived) bp;
				String sql = m.getSql();
				int userGroup = m.getUserGroup();
				// 对比时间，相差较大则不进行保存
				// Calendar cal=Calendar.getInstance();
				// if(m.getYear()==cal.get(Calendar.YEAR)){
				// if((m.getYear() < cal.get(Calendar.YEAR)+1)&&(m.getYear() >
				// cal.get(Calendar.YEAR)-1)){
				System.out.println("开始存储数据");
//TODO	zxy			surveillancedataService.saveSurveillancedata(m);
				runningdataService.saveRunningdata(sql, userGroup);
		       
				System.out.println(getImei(proto));
				
				// 拿到所有的客户端Session
		        Collection<IoSession> sessions = session.getService().getManagedSessions().values();

		        // 向所有客户端发送数据
//		        for (IoSession sess : sessions) {
//
//		            sess.write("hello, I am server!");
//
//		        }
				
				// 判断是否有报警,然后发送到笔记本
				// AlarmSend alarmSend = new AlarmSend();
				// alarmSend.sendToRock(m, proto);

				// 接收到有报警数据发送短信
//				AlarmAnalyze analyze = new AlarmAnalyze();
//				analyze.send(m);

				// 以下为调用中国网建API函数进行短信的发送。
				// if(Math.abs(m.getDipAngleX())>20||Math.abs(m.getDipAngleY())>20){
				// String temp = "国资号为：" + serviceImpl.getZId(m) +
				// "的设备报警，报警类型为：";
				// if(Math.abs(m.getDipAngleX())>20){
				// temp += "防倾覆传感器报警X！";
				// }
				// else if (Math.abs(m.getDipAngleY())>20) {
				// temp += "防倾覆传感器报警Y！";
				// }
				// SmsWebchinese smsWebchinese = new SmsWebchinese();
				// try {
				// // smsWebchinese.sendMessage(temp);
				// } catch (Exception e) {
				// // TODO: handle exception
				// }
				// }
				// }
				break;
			default:
				break;
			}
			// }
		}
		return bp;
	}
	

	// //解码ASCII数据
	// public static String analyticASCII(String data){
	// String test = "";
	// int length = (int)(data.length()/2);
	// //当IMEI按ASCII值传输时
	// int a = 0;int b = 2;
	// for(int i=0;i<length;i++){
	// Integer y = Integer.parseInt(data.substring(a, b),16);
	// a += 2;b += 2;
	// test += (char)y.intValue();
	// }
	// return test;
	// }

	// 提取ASCII中有效数据
	// public static String getString(String data){
	// String test = data;
	// test = test.replaceAll("00", "");
	// return test;
	// }
	
}
