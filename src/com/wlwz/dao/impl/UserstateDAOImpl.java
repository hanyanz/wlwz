package com.wlwz.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IUserstateDAO;
import com.wlwz.entity.Userstate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userstate entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlw.Userstate
 * @author MyEclipse Persistence Tools
 */
@Component("userstateDAO")
public class UserstateDAOImpl extends SuperDao  implements IUserstateDAO{
	private static final Logger log = LoggerFactory
			.getLogger(UserstateDAOImpl.class);
	// property constants
	public static final String USERSIGN = "userSign";
	public static final String STATE = "state";
	public static final String IS_ACTIVE = "isActive";

	public void save(Userstate transientInstance) {
		log.debug("saving Userstate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userstate persistentInstance) {
		log.debug("deleting Userstate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userstate findById(java.lang.Integer id) {
		log.debug("getting Userstate instance with id: " + id);
		try {
			Userstate instance = (Userstate) getHibernateTemplate().get(
					"com.wlwz.entity.Userstate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userstate> findByExample(Userstate instance) {
		log.debug("finding Userstate instance by example");
		try {
			List<Userstate> results = (List<Userstate>) getHibernateTemplate()
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
		log.debug("finding Userstate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userstate as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//这个方法是我自己加的
	@SuppressWarnings("unchecked")
	public Userstate findByUsersign(String userSign) {
		log.debug("getting Userstate instance with userSign: " + userSign);
		try {
			String queryString = "from Userstate as model where model.userSign = ?"   ;
		    List<Userstate> list=  getHibernateTemplate().find(queryString,userSign);
			Userstate instance = list.get(0);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userstate> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	

	public List findAll() {
		log.debug("finding all Userstate instances");
		try {
			String queryString = "from Userstate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userstate merge(Userstate detachedInstance) {
		log.debug("merging Userstate instance");
		try {
			Userstate result = (Userstate) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userstate instance) {
		log.debug("attaching dirty Userstate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userstate instance) {
		log.debug("attaching clean Userstate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}