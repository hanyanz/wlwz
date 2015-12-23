package com.wlwz.dao;

import java.util.List;

import com.wlwz.entity.Userstate;



public interface IUserstateDAO {
	public void save(Userstate transientInstance);

	public Userstate findById(java.lang.Integer id);

	public void attachDirty(Userstate instance);
	public Userstate findByUsersign(String userSign);
	public List findByProperty(String propertyName, Object value);
	public List findAll();
}