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
import com.wlwz.entity.Systemrole;
import com.wlwz.entity.User;
import com.wlwz.service.ISystemroleService;

@Component("systemrole_Service")
public class SystemroleServiceImpl implements ISystemroleService {

	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	ISystemroleDAO systemroleDAO;

	@Resource(name = "systemrole_DAO")
	public void setSystemroleDAO(ISystemroleDAO systemroleDAO) {
		this.systemroleDAO = systemroleDAO;
	}

	IUserDAO userDAO;

	@Resource(name = "user_DAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Long countSystemrole(String systemRoleSearchCondition) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Systemrole.class);
		if (systemRoleSearchCondition != null
				&& !"".equals(systemRoleSearchCondition)) {
			dtr.add(Restrictions.like("roleName", "%"
					+ systemRoleSearchCondition + "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	public List<Systemrole> loadSystemroleList(Integer start, Integer limit,
			String systemRoleSearchCondition) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Systemrole.class);
		if (systemRoleSearchCondition != null
				&& !"".equals(systemRoleSearchCondition)) {
			dtr.add(Restrictions.like("roleName", "%"
					+ systemRoleSearchCondition + "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("systemRoleId"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	public void createSystemrole(String roleName, String remark) {
		Systemrole systemrole = new Systemrole();
		systemrole.setRoleName(roleName);
		systemrole.setRemark(remark);
		systemrole.setIsActive(true);
		systemroleDAO.save(systemrole);
	}

	public void deleteSystemrole(Integer systemroleId) {
		Systemrole systemrole = systemroleDAO.findById(systemroleId);

		List<User> userList = userDAO.findByProperty("systemrole", systemrole);
		for (int index = 0; index < userList.size(); index++) {
			User user = userList.get(index);
			user.setIsActive(false);
			userDAO.attachDirty(user);
		}
		systemrole.setIsActive(false);
		systemroleDAO.attachDirty(systemrole);
	}

	public void modifySystemrole(Integer systemroleId, String name,
			String remark) {
		if (systemroleId != null && !"".equals(systemroleId)) {
			Systemrole systemrole = systemroleDAO.findById(systemroleId);
			if (systemrole != null) {
				systemrole.setRoleName(name);
				systemrole.setRemark(remark);
				systemroleDAO.attachDirty(systemrole);
			}
		}
	}

	public Systemrole loadOneSystemrole(Integer systemroleId) {
		if (systemroleId != null && !"".equals(systemroleId)) {
			Systemrole role = systemroleDAO.findById(systemroleId);
			return role;
		}
		return null;
	}

}
