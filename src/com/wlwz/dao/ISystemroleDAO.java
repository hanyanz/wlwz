package com.wlwz.dao;

import java.util.List;

import com.wlwz.entity.Systemrole;

public interface ISystemroleDAO {
	public void save(Systemrole transientInstance);

	public Systemrole findById(java.lang.Integer id);

	public void attachDirty(Systemrole instance);

	public List findAll();
}
