package com.wlwz.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ISystemroleDAO;
import com.wlwz.entity.Systemrole;


/**
 * A data access object (DAO) providing persistence and search support for
 * Systemrole entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlw.Systemrole
 * @author MyEclipse Persistence Tools
 */
@Component("systemrole_DAO")
public class SystemroleDAOImpl extends SuperDao implements ISystemroleDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SystemroleDAOImpl.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String REMARK = "remark";
	public static final String IS_ACTIVE = "isActive";

	public void save(Systemrole transientInstance) {
		log.debug("saving Systemrole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Systemrole persistentInstance) {
		log.debug("deleting Systemrole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Systemrole findById(java.lang.Integer id) {
		log.debug("getting Systemrole instance with id: " + id);
		try {
			Systemrole instance = (Systemrole) getHibernateTemplate().get(
					"com.wlwz.entity.Systemrole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Systemrole> findByExample(Systemrole instance) {
		log.debug("finding Systemrole instance by example");
		try {
			List<Systemrole> results = (List<Systemrole>) getHibernateTemplate()
			     .findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Systemrole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Systemrole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Systemrole> findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List<Systemrole> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	
	public List findAll() {
		log.debug("finding all Systemrole instances");
		try {
			String queryString = "from Systemrole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Systemrole merge(Systemrole detachedInstance) {
		log.debug("merging Systemrole instance");
		try {
			Systemrole result = (Systemrole) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Systemrole instance) {
		log.debug("attaching dirty Systemrole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Systemrole instance) {
		log.debug("attaching clean Systemrole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}