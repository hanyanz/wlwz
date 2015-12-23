package com.wlwz.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ISystemrightDAO;
import com.wlwz.entity.Systemright;


/**
 * A data access object (DAO) providing persistence and search support for
 * Systemright entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Systemright
 * @author MyEclipse Persistence Tools
 */
@Component("systemright_DAO")
public class SystemrightDAOImpl extends SuperDao implements ISystemrightDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SystemrightDAOImpl.class);
	// property constants
	public static final String RIGHT_NAME = "rightName";
	public static final String REMARK = "remark";
	public static final String IS_ACTIVE = "isActive";

	public void save(Systemright transientInstance) {
		log.debug("saving Systemright instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Systemright persistentInstance) {
		log.debug("deleting Systemright instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Systemright findById(java.lang.String id) {
		log.debug("getting Systemright instance with id: " + id);
		try {
			Systemright instance = (Systemright) getHibernateTemplate().get(
					"com.wlwz.entity.Systemright", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Systemright> findByExample(Systemright instance) {
		log.debug("finding Systemright instance by example");
		try {
			List<Systemright> results = (List<Systemright>) getHibernateTemplate()
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
		log.debug("finding Systemright instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Systemright as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Systemright> findByRightName(Object rightName) {
		return findByProperty(RIGHT_NAME, rightName);
	}

	public List<Systemright> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}



	public List findAll() {
		log.debug("finding all Systemright instances");
		try {
			String queryString = "from Systemright";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Systemright merge(Systemright detachedInstance) {
		log.debug("merging Systemright instance");
		try {
			Systemright result = (Systemright) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Systemright instance) {
		log.debug("attaching dirty Systemright instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Systemright instance) {
		log.debug("attaching clean Systemright instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}