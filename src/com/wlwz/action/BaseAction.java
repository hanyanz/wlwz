package com.wlwz.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.wlwz.entity.User;
import com.wlwz.util.ReqRes;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Integer limit = 20;
	protected String msg;
	protected Integer start = 0;
	public boolean success = false;
	protected Integer totalPage; // 总页数
	protected Integer currentPage; // 当前页数
	protected Long totalRecord; // 总记录条数
	protected User user;
	protected User applicant;
	protected String username;
	protected String url;
	protected List queryList;

	public List getQueryList() {
		return queryList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 判断当前页数，控制其在一定范围内
	protected void initPage() {
		if (currentPage == null || currentPage <= 0) {
			currentPage = 1;
		}
		if (totalPage != 0 && currentPage > totalPage) {
			currentPage = totalPage;
		}
	}

	protected void CheckUser() throws Exception {
		try {
			HttpSession a = ReqRes.getSession();
			username = ReqRes.getSession().getAttribute("userName").toString();
			user = (User) ReqRes.getSession().getAttribute("user");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			username = null;
			throw e;
		}
	}

	protected int getUserID() {
		try {
			HttpSession a = ReqRes.getSession();
			user = (User) ReqRes.getSession().getAttribute("user");
			return user.getUserId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			username = null;
		}
		return limit;
	}

	public void ClearList(List lst) {
		if (lst != null) {
			lst.clear();
		} else
			lst = new ArrayList();
	}

	public Integer getLimit() {
		return limit;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getStart() {
		return start;
	}

	public Long getTotalRecord() {
		return totalRecord;
	}

	public User getUser() {
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	protected void UpdateSessionUser() throws Exception {
		try {
			// ReqRes.getSession().removeAttribute("user");
			// ReqRes.getSession().setAttribute("user",user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// user = null;
			throw e;
		}
	}

	private static final int BUFFER_SIZE = 16 * 1024;

	protected static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
