package com.wlwz.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IEverymonthrecordDAO;
import com.wlwz.entity.Everymonthrecord;


/**
 * A data access object (DAO) providing persistence and search support for
 * Everymonthrecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Everymonthrecord
 * @author MyEclipse Persistence Tools
 */
@Component("everymonthrecordDAO")
public class EverymonthrecordDAOImpl extends SuperDao implements
     IEverymonthrecordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EverymonthrecordDAOImpl.class);
	// property constants
	public static final String THIS_MONTH_DAYS = "thisMonthDays";
	public static final String FUEL_OIL = "fuelOil";
	public static final String LUBE_OIL = "lubeOil";
	public static final String IS_ACTIVE = "isActive";

	public void save(Everymonthrecord transientInstance) {
		log.debug("saving Everymonthrecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Everymonthrecord persistentInstance) {
		log.debug("deleting Everymonthrecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Everymonthrecord findById(java.lang.String id) {
		log.debug("getting Everymonthrecord instance with id: " + id);
		try {
			Everymonthrecord instance = (Everymonthrecord) getHibernateTemplate().get(
					"com.wlwz.entity.Everymonthrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Everymonthrecord> findByExample(Everymonthrecord instance) {
		log.debug("finding Everymonthrecord instance by example");
		try {
			List<Everymonthrecord> results = (List<Everymonthrecord>) getHibernateTemplate()
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
		log.debug("finding Everymonthrecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Everymonthrecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Everymonthrecord> findByThisMonthDays(Object thisMonthDays) {
		return findByProperty(THIS_MONTH_DAYS, thisMonthDays);
	}

	public List<Everymonthrecord> findByFuelOil(Object fuelOil) {
		return findByProperty(FUEL_OIL, fuelOil);
	}

	public List<Everymonthrecord> findByLubeOil(Object lubeOil) {
		return findByProperty(LUBE_OIL, lubeOil);
	}

	public List<Everymonthrecord> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Everymonthrecord instances");
		try {
			String queryString = "from Everymonthrecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Everymonthrecord merge(Everymonthrecord detachedInstance) {
		log.debug("merging Everymonthrecord instance");
		try {
			Everymonthrecord result = (Everymonthrecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Everymonthrecord instance) {
		log.debug("attaching dirty Everymonthrecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Everymonthrecord instance) {
		log.debug("attaching clean Everymonthrecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}