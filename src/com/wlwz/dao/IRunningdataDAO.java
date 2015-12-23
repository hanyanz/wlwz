package com.wlwz.dao;


import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * Runningdata3 entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlwz.entity.Runningdata
 * @author MyEclipse Persistence Tools
 */

public interface IRunningdataDAO  {
	

	public void save(int userGroup, String sql) throws Exception;

	public List queryBySql(final String sql);

	public int excuteBySql(String sql);


}