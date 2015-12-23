package com.wlwz.dao;

import java.util.List;

import com.wlwz.entity.User;

public interface IUserDAO {
	public List findByProperty(String propertyName, Object value);

	public void save(User transientInstance);

	public List<User> findByUserName(Object userName);

	public User findById(java.lang.Integer id);

	public List findAll();

	public void attachDirty(User instance);
}
