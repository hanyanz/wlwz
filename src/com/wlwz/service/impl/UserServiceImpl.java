package com.wlwz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.ISystemroleDAO;
import com.wlwz.dao.IUserDAO;
import com.wlwz.dao.IUserstateDAO;
import com.wlwz.entity.Systemrole;
import com.wlwz.entity.User;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IUserService;
import com.wlwz.util.MD5Code;

@Component("user_Service")
public class UserServiceImpl implements IUserService {
	private IUserDAO userDAO;

	@Resource(name = "user_DAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	ISystemroleDAO systemroleDAO;

	@Resource(name = "systemrole_DAO")
	public void setSystemroleDAO(ISystemroleDAO systemroleDAO) {
		this.systemroleDAO = systemroleDAO;
	}
	
	IUserstateDAO userstateDAO;

	@Resource(name = "userstateDAO")
	public void setUserstateDAO(IUserstateDAO userstateDAO) {
		this.userstateDAO = userstateDAO;
	}
	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	public User login(String userName, String password) {
		List usersList = userDAO.findByProperty("userName", userName);
		if (usersList == null || usersList.size() != 1)
			return null;
		User u = (User) usersList.get(0);
		MD5Code md5 = new MD5Code();
		if (!u.getPassword().equals(md5.getMD5ofStr(password)))
			return null;
		return u;
	}

	// 新建用户，初试密码为123456
	public void createUser( Integer systemRoleId,String userName,
			String realName, String unit, String email, String mobilephone,
			String telephone, String area) {
		User user = new User();	
		user.setUserName(userName);
		user.setRealName(realName);
		user.setUnit(unit);
		user.setEmail(email);
		user.setMobilephone(mobilephone);
		user.setTelephone(telephone);
		user.setArea(area);
		user.setIsActive(true);
		Systemrole systemrole = systemroleDAO.findById(systemRoleId);
		user.setSystemrole(systemrole);
		MD5Code md5 = new MD5Code();
		user.setPassword(md5.getMD5ofStr("123456"));
		try {
			userDAO.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//注册新用户时，与上一个creatUser()方法不同的是要用户设定密码，且要设定用户组号
	public void createUser( Integer userGroup,Integer systemRoleId,String userName, String password,
			String realName, String unit, String email, String mobilephone,
			String telephone, String area) {
		User user = new User();
		user.setUserName(userName);
		user.setRealName(realName);
		user.setUnit(unit);
		user.setEmail(email);
		user.setMobilephone(mobilephone);
		user.setTelephone(telephone);
		user.setArea(area);
		user.setIsActive(true);
		Userstate userstate = userstateDAO.findById(userGroup);
		user.setUserstate(userstate);
		Systemrole systemrole = systemroleDAO.findById(systemRoleId);
		user.setSystemrole(systemrole);	
		MD5Code md5 = new MD5Code();
		user.setPassword(md5.getMD5ofStr(password));
		try {
			userDAO.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void deleteUser(Integer userId) {
		User user = userDAO.findById(userId);
		if (user != null) {
			user.setIsActive(false);
		}
		userDAO.attachDirty(user);
	}

	public void modifyUser(Integer userId, Integer systemRoleId,
			String userName, String password, String realName, String unit,
			String email, String mobilephone, String telephone, String area) {
		User user = userDAO.findById(userId);
		user.setUserName(userName);
		user.setRealName(realName);
		user.setUnit(unit);
		user.setEmail(email);
		user.setMobilephone(mobilephone);
		user.setTelephone(telephone);
		user.setArea(area);
		Systemrole systemrole = systemroleDAO.findById(systemRoleId);
		user.setSystemrole(systemrole);
		MD5Code md5 = new MD5Code();
		if (password != null && !"".equals(password)) {
			user.setPassword(md5.getMD5ofStr(password));
		} else {
			user.setPassword(md5.getMD5ofStr("123456"));
		}
		try {
			userDAO.attachDirty(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Long countUser(String userNameTop) {
		DetachedCriteria dtr = DetachedCriteria.forClass(User.class);
		if (userNameTop != null && !"".equals(userNameTop)) {
			dtr.add(Restrictions.like("userName", "%" + userNameTop + "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	public List<User> loadUserList(Integer start, Integer limit,
			String userNameTop) {
		DetachedCriteria dtr = DetachedCriteria.forClass(User.class);
		if (userNameTop != null && !"".equals(userNameTop)) {
			dtr.add(Restrictions.like("userName", "%" + userNameTop + "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("userId"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	public User loadOneUser(Integer userId) {
		if (userId != null && !"".equals(userId)) {
			User user = userDAO.findById(userId);
			return user;
		}
		return null;
	}

	// 搜索所用角色类型，在新建用户的时候进行选择
	public List<Systemrole> getAllSystemrole() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Systemrole.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("systemRoleId"));
		return commonDAO.findByDetachedCriteria(dtr);
	}
}
