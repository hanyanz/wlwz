package com.wlwz.dao;

import java.util.List;

import com.wlwz.entity.Videoinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Videoinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlwz.entity.Videoinfo
 * @author MyEclipse Persistence Tools
 */

public interface IVideoinfoDAO  {
	
	public void save(Videoinfo transientInstance); 

	public void delete(Videoinfo persistentInstance); 

	public Videoinfo findById(java.lang.Integer id); 

	public List<Videoinfo> findByExample(Videoinfo instance); 

	public List findByProperty(String propertyName, Object value);

	public List<Videoinfo> findByImei(Object imei);
	

	public List findAll();

	public Videoinfo merge(Videoinfo detachedInstance);

	public void attachDirty(Videoinfo instance); 

	public void attachClean(Videoinfo instance); 
}