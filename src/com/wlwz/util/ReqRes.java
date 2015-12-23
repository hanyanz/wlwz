package com.wlwz.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ReqRes {
	public static final HttpServletRequest getRequest() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		return request;
	}

	public static final HttpServletResponse getResponse() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;

	}

	public static final HttpSession getSession() throws Exception {
		HttpSession ses = ServletActionContext.getRequest().getSession();
		return ses;

	}

	/**
	 * 将字符串写回浏览�?
	 * 
	 * @param json
	 *            要写回浏览器的字符串
	 */
	public static void writeBack(String json) {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest Request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
