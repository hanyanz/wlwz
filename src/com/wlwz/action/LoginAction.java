package com.wlwz.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.wlwz.entity.User;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IUserService;
import com.wlwz.util.ReqRes;

@Component("login_Action")
@Scope("prototype")
public class LoginAction extends BaseAction {
	private String userName;
	private String password;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private IUserService userService;

	@Resource(name = "user_Service")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
//	private IUserstateService userstateService;
//
//	@Resource(name = "userstateService")
//	public void setUserstateService(IUserstateService userstateService) {
//		this.userstateService = userstateService;
//	}

	public String login() {
		try {
			
			HttpSession ses = ReqRes.getSession();
			//ses = ReqRes.getSession();
			ses.removeAttribute("userName");
			if (userName == null || password == null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("msg", "请输入用户名和密码");
				return INPUT;
			}
			User u = userService.login(userName, password);
			if (u != null) {
				//验证用户状态（跳转到配置，支付，还是监控页面）
				Userstate userstate = u.getUserstate();
				Integer userGroup =userstate.getUserGroup();
//				System.out.print(userGroup);
				Integer state = userstate.getState();	
//				System.out.println(state);
				//暂时只分为是否配置两种情况，不考虑支付问题。
				if(state.equals(3) ){ 
					ses.setAttribute("userName", u.getUserName());
					ses.setAttribute("userId", u.getUserId());
				//zxy 以下是尝试后用户登录后可直接得到用户的用户组号
					ses.setAttribute("userGroup", userGroup);
					ses.setAttribute("user", u);
					return SUCCESS;  
				}
				else {
					ses.setAttribute("userGroup", userGroup);
					ses.setAttribute("userName", u.getUserName());
					ses.setAttribute("userId", u.getUserId());
					ses.setAttribute("user", u);
					return "depoly";
				}
//				else  {
//			     	ses.setAttribute("userGroup", userGroup);
//					ses.setAttribute("userName", u.getUserName());
//					ses.setAttribute("userId", u.getUserId());
//					ses.setAttribute("user", u);
//					return "pay";
//				}
			} else {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("msg", "用户名无效或密码错误");
				return INPUT;
			}
		} catch (Exception e) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "系统处理错误，请重新尝试登陆");
			return INPUT;
		}
		
	}

	
	
}