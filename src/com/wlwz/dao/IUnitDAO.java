package com.wlwz.dao;

import com.wlwz.entity.Unit;

public interface IUnitDAO  {

	public Unit findById(java.lang.Integer id);
	public void save(Unit transientInstance);
	public void attachDirty(Unit instance);
	
}