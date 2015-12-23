package com.wlwz.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IRolerightDAO;
import com.wlwz.entity.Roleright;


/**
 * A data access object (DAO) providing persistence and search support for
 * Roleright entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlw.Roleright
 * @author MyEclipse Persistence Tools
 */
@Component("rolerightDAO")
public class RolerightDAOImpl extends SuperDao implements IRolerightDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RolerightDAOImpl.class);
	// property constants
	public static final String RIGHT_TYPE = "rightType";
	public static final String IS_ACTIVE = "isActive";

	public void save(Roleright transientInstance) {
		log.debug("saving Roleright instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Roleright persistentInstance) {
		log.debug("deleting Roleright instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Roleright findById(java.lang.String id) {
		log.debug("getting Roleright instance with id: " + id);
		try {
			Roleright instance = (Roleright) getHibernateTemplate().get(
					"com.wlwz.entity.Roleright", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Roleright> findByExample(Roleright instance) {
		log.debug("finding Roleright instance by example");
		try {
			List<Roleright> results = (List<Roleright>)  getHibernateTemplate()
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
		log.debug("finding Roleright instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Roleright as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Roleright> findByRightType(Object rightType) {
		return findByProperty(RIGHT_TYPE, rightType);
	}

	

	public List findAll() {
		log.debug("finding all Roleright instances");
		try {
			String queryString = "from Roleright";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Roleright merge(Roleright detachedInstance) {
		log.debug("merging Roleright instance");
		try {
			Roleright result = (Roleright) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Roleright instance) {
		log.debug("attaching dirty Roleright instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Roleright instance) {
		log.debug("attaching clean Roleright instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}