package com.wlwz.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IUserDAO;
import com.wlwz.entity.Systemrole;
import com.wlwz.entity.User;
import com.wlwz.service.ISystemroleService;
import com.wlwz.service.IUserService;
import com.wlwz.util.ReqRes;

@Component("user_Action")
@Scope("prototype")
public class UserAction extends BaseAction {

	private Integer userId;
	private Systemrole systemrole;
	private String userName;
	private String password;
	private String realName;
	private String unit;
	private String email;
	private String mobilephone;
	private String telephone;
	private String area;
	private Boolean isActive;
	private String userNameTop;
	private Integer systemRoleId;

	public Integer getSystemRoleId() {
		return systemRoleId;
	}

	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	public String getUserNameTop() {
		return userNameTop;
	}

	public void setUserNameTop(String userNameTop) {
		this.userNameTop = userNameTop;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Systemrole getSystemrole() {
		return systemrole;
	}

	public void setSystemrole(Systemrole systemrole) {
		this.systemrole = systemrole;
	}

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private IUserDAO userDAO;

	@Resource(name = "user_DAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private ISystemroleService systemroleService;

	@Resource(name = "systemrole_Service")
	public void setSystemroleService(ISystemroleService systemroleService) {
		this.systemroleService = systemroleService;
	}

	private IUserService userService;

	@Resource(name = "user_Service")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getRightList() {
		try {
			List<User> list = userDAO.findAll();
			if (list.size() > 0) {
				HttpSession ses = ReqRes.getSession();
				ses.setAttribute("userName", list.get(0).getUserName());
				ses.setAttribute("urlList", list);
				return SUCCESS;
			} else {
				return INPUT;
			}
		} catch (Exception e) {
			return INPUT;
		}
	}

	public String getUserList() {
		ClearList(queryList);
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = userService.countUser(userNameTop);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "userAction!getUserList.action";
			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}
			initPage();
			ses.setAttribute("totalPage", totalPage);
			ses.setAttribute("currentPage", currentPage);
			ses.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				return "list";
			}
			queryList = userService.loadUserList(start + limit
					* (currentPage - 1), limit, userNameTop);
			return "list";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createUser() {
		try {
			userService.createUser(systemRoleId, userName, realName, unit,
					email, mobilephone, telephone, area);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
			User user = userService.loadOneUser(userId);
			session.setAttribute("user", user);
			return "check";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String edit() {
		ClearList(queryList);
		try {
			HttpSession session = ReqRes.getSession();
			User user = userService.loadOneUser(userId);
			session.setAttribute("user", user);
			queryList = userService.getAllSystemrole();

			for (int i = 0; i < queryList.size(); i++) {
				// System.out.println("==="+queryList.get(i));
				// System.out.println(user.getSystemrole().getRoleName());
				Systemrole s = (Systemrole) queryList.get(i);
				// System.out.println(s.getRoleName());
				// if(s.equals(user.getSystemrole()))
				if (s.getRoleName().equals(user.getSystemrole().getRoleName())) {
					queryList.remove(queryList.get(i));
				}
			}
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveEdit() {
		try {
			userService.modifyUser(userId, systemRoleId, userName, password,
					realName, unit, email, mobilephone, telephone, area);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String delete() {
		try {
			userService.deleteUser(userId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getUserList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取所有角色名list
	public String getSystemroleName() {
		ClearList(queryList);
		try {
			queryList = userService.getAllSystemrole();
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
