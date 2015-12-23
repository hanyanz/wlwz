package com.wlwz.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Systemrole;
import com.wlwz.service.ISystemroleService;
import com.wlwz.util.ReqRes;

@Component("systemrole_Action")
@Scope("prototype")
public class SystemroleAction extends BaseAction {

	private Integer systemRoleId;
	private String roleName;
	private String remark;
	private Boolean isActive;
	private String systemRoleSearchCondition;

	public String getSystemRoleSearchCondition() {
		return systemRoleSearchCondition;
	}

	public void setSystemRoleSearchCondition(String systemRoleSearchCondition) {
		this.systemRoleSearchCondition = systemRoleSearchCondition;
	}

	public Integer getSystemRoleId() {
		return systemRoleId;
	}

	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private ISystemroleService systemroleService;

	@Resource(name = "systemrole_Service")
	public void setSystemroleService(ISystemroleService systemroleService) {
		this.systemroleService = systemroleService;
	}

	public String getSystemroleList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = systemroleService
					.countSystemrole(systemRoleSearchCondition);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "systemroleAction!getSystemroleList.action";
			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}
			initPage();
			ses.setAttribute("totalPage", totalPage);
			ses.setAttribute("currentPage", currentPage);
			ses.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}
			queryList = systemroleService.loadSystemroleList(start + limit
					* (currentPage - 1), limit, systemRoleSearchCondition);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createSystemrole() {
		try {
			systemroleService.createSystemrole(roleName, remark);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
			Systemrole role = systemroleService.loadOneSystemrole(systemRoleId);
			session.setAttribute("role", role);
			return "check";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String edit() {
		try {
			HttpSession session = ReqRes.getSession();
			Systemrole role = systemroleService.loadOneSystemrole(systemRoleId);
			session.setAttribute("role", role);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveEdit() {
		try {
			systemroleService.modifySystemrole(systemRoleId, roleName, remark);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String delete() {
		try {
			systemroleService.deleteSystemrole(systemRoleId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getSystemroleList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
