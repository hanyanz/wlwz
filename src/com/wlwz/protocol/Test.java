package com.wlwz.protocol;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	InetAddress myIPaddress = null;

	InetAddress myServer = null;

	public static void main(String args[]) {
		Test mytool;
		mytool = new Test();
		System.out.println("My host IP is: " + mytool.getMyIP());
		System.out.println("The Server IP is :" + mytool.getServerIP());

	}

	// 取得LOCALHOST的IP地址
	public InetAddress getMyIP() {
		try {
			myIPaddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
		}
		return (myIPaddress);
	}

	// 取得 www.abc.com 的IP地址
	public InetAddress getServerIP() {
		try {
			myServer = InetAddress.getByName("cdtest.crane-safety.net");
		} catch (UnknownHostException e) {
		}
		return (myServer);
	}
}
