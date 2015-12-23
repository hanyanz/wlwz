package com.wlwz.vo;

/**
 * 
 * @author root
 * 
 */
public class UserInfo {
	// private static UserInfo user = new UserInfo();
	// private Vector vector = null;

	static int counter = 0;

	public static int getCounter() {
		return counter;
	}

	public UserInfo() {
	}

	public static void addUser() {
		counter++;
	}

	public static void removeUser() {
		counter--;
	}
}
