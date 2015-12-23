package com.wlwz.service;

import java.util.List;

import com.wlwz.entity.Systemrole;

public interface ISystemroleService {
	public Long countSystemrole(String systemRoleSearchCondition);

	public List<Systemrole> loadSystemroleList(Integer start, Integer limit,
			String systemRoleSearchCondition);

	public void createSystemrole(String roleName, String remark);

	public void modifySystemrole(Integer systemroleId, String name,
			String remark);

	public void deleteSystemrole(Integer systemroleId);

	public Systemrole loadOneSystemrole(Integer systemroleId);
}
