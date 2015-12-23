package com.wlwz.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IUnitDAO;
import com.wlwz.entity.Unit;



/**
 * A data access object (DAO) providing persistence and search support for Unit
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wlw.Unit
 * @author MyEclipse Persistence Tools
 */
@Component("unit_DAO")
public class UnitDAOImpl extends SuperDao implements IUnitDAO {
	private static final Logger log = LoggerFactory.getLogger(UnitDAOImpl.class);
	// property constants
	public static final String UNIT_NAME = "unitName";
	public static final String UNIT_BELONGED = "unitBelonged";
	public static final String UNIT_LEADER = "unitLeader";
	public static final String LEADER_TELE = "leaderTele";
	public static final String IS_ACTIVE = "isActive";

	public void save(Unit transientInstance) {
		log.debug("saving Unit instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Unit persistentInstance) {
		log.debug("deleting Unit instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Unit findById(java.lang.Integer id) {
		log.debug("getting Unit instance with id: " + id);
		try {
			Unit instance = (Unit) getHibernateTemplate().get("com.wlwz.entity.Unit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Unit> findByExample(Unit instance) {
		log.debug("finding Unit instance by example");
		try {
			List<Unit> results = (List<Unit>) getHibernateTemplate()
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
		log.debug("finding Unit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Unit as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Unit> findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List<Unit> findByUnitBelonged(Object unitBelonged) {
		return findByProperty(UNIT_BELONGED, unitBelonged);
	}

	public List<Unit> findByUnitLeader(Object unitLeader) {
		return findByProperty(UNIT_LEADER, unitLeader);
	}

	public List<Unit> findByLeaderTele(Object leaderTele) {
		return findByProperty(LEADER_TELE, leaderTele);
	}

	

	public List findAll() {
		log.debug("finding all Unit instances");
		try {
			String queryString = "from Unit";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Unit merge(Unit detachedInstance) {
		log.debug("merging Unit instance");
		try {
			Unit result = (Unit) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Unit instance) {
		log.debug("attaching dirty Unit instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Unit instance) {
		log.debug("attaching clean Unit instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}