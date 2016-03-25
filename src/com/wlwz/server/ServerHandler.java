/*

 *  Authors:                                      |
 */
package com.wlwz.server;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IDeviceDAO;
import com.wlwz.entity.Device;
import com.wlwz.protocol.BasePorotocol;
import com.wlwz.protocol.ProtocolUtils;
import com.wlwz.service.IRunningdataService;



@Component("Server_Handler")
public class ServerHandler implements IoHandler {
	/**
	 * Logger for this class
	 */

	static int count = 0;

	private IDeviceDAO deviceDAO;

	@Resource(name = "deviceDAO")
	public void setDeviceDAO(IDeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	private IRunningdataService runningdataService;

	@Resource(name = "runningdata_Service")
	public void setDataService(IRunningdataService runningdataService) {
		this.runningdataService = runningdataService;
	}

	// 将IMEI标志的ASCII形式转为Long型?	
	public String getIMEI(String data) {
		String imei = "";
		// 当IMEI按ASCII值传输时
		int a = 0;
		int b = 2;
		for (int i = 0; i < 16; i++) {
			Integer y = Integer.parseInt(data);
			a += 2;
			b += 2;
			if ((y >= 48) && (y <= 57)) {
				imei += (char) y.intValue();
			}
		}
		Long x = Long.parseLong(imei);
		imei = x.toString();
		return imei;
	}

	public char[] stringToChar(String data) {
		char[] test = new char[data.length()];
		for (int i = 0; i < data.length(); i++) {
			test[i] = data.charAt(i);
		}
		return test;
	}

	// //
	// public char intToChar(int mess){
	// char a = (char)mess;
	// return a;
	// }

	public byte[] charToByte(char[] x) {
		byte[] y = new byte[x.length];
		for (int j = 0; j < x.length; j++) {
			if ((x[j]) < 128) {
				y[j] = (byte) x[j];
			} else {
				y[j] = (byte) (x[j] - 256);
			}
		}
		return y;
	}

	public String analyticASCII(String data) {
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

	private static final Logger logger = LoggerFactory
			.getLogger(ServerHandler.class);

	/**
	 * 异常发生时触发
	 */
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.error("", cause);
	}

	/**
	 * 收到消息时触发
	 */
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// byte[] test = new byte[5];
		// test[0] = -2;
		// test[1] = -5;
		// test[3] = -2;
		// test[4] = -6;
		// if(ServerHandler.count%10==0){
		// test[2] = -3;
		// session.write(test);
		// }else if(ServerHandler.count%5==0){
		// test[2] =-4;
		// session.write(test);
		// }
		String mesString = analyticASCII(message.toString());
		System.out.println("接收数据十六进制" + mesString);
		System.out.println("========================接收到十六进制数据的长度"
				+ mesString.length() / 2 + "字节=========================");

		// 是否是转发过来的数据,是的话则执行
		// mesString = analyticASCII(mesString);
//
		BasePorotocol basePoro = ProtocolUtils.decode(session, mesString,
				runningdataService);
		ServerHandler.count += 1;
		if (basePoro != null) {
			Device device = new Device();
			String imei = basePoro.getIMEI();
			device = deviceDAO.findByImei(imei).get(0);
			if (device != null) {
				// ServerHandler.count+=1;
				System.out.println("十进制IMEI号为--------"
						+ device.getImei());
				 System.out.println("设备编码 ="+device.getDeviceNumber());
				 System.out.println("存储完成数据个数******"+ServerHandler.count+"*****");
			}
		}

		
	}

	/**
	 * 当发送消息后被触发
	 */
	public void messageSent(IoSession session, Object message) throws Exception {

	}

	/**
	 * 当会话创建时被触发
	 */
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("=====接收到数据，创建新的session=====");
	}

	/**
	 * session超过允许空闲时间时触发
	 */
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {

	}

	/**
	 * 会话打开时触发
	 */
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("========打开这个session=======");
	}

	/**
	 * 连接关闭时触发
	 */
	public void sessionClosed(IoSession session) throws Exception {
		Timestamp now2 = new Timestamp(System.currentTimeMillis());
		System.out.println("sessionClosed时间" + now2.toString());
	}
}
