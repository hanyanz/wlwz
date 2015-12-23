package com.wlwz.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IMaintenancerecordDAO;
import com.wlwz.entity.Maintenancerecord;


/**
 * A data access object (DAO) providing persistence and search support for
 * Maintenancerecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Maintenancerecord
 * @author MyEclipse Persistence Tools
 */
@Component("maintenancerecordDAO")
public class MaintenancerecordDAOImpl extends SuperDao implements
    IMaintenancerecordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MaintenancerecordDAOImpl.class);
	// property constants
	public static final String MAINTENANCE_KIND = "maintenanceKind";
	public static final String MAINTENANCE_PLACE = "maintenancePlace";
	public static final String MAINTENANCE_DAYS = "maintenanceDays";
	public static final String MAINTENANCE_CONTENT = "maintenanceContent";
	public static final String CHANGE_RECORD = "changeRecord";
	public static final String OUT_FACTORY_STATE = "outFactoryState";
	public static final String ATTENTION_MATTERS = "attentionMatters";
	public static final String IS_ACTIVE = "isActive";

	public void save(Maintenancerecord transientInstance) {
		log.debug("saving Maintenancerecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Maintenancerecord persistentInstance) {
		log.debug("deleting Maintenancerecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Maintenancerecord findById(java.lang.String id) {
		log.debug("getting Maintenancerecord instance with id: " + id);
		try {
			Maintenancerecord instance = (Maintenancerecord) getHibernateTemplate().get(
					"com.wlwz.entity.Maintenancerecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Maintenancerecord> findByExample(Maintenancerecord instance) {
		log.debug("finding Maintenancerecord instance by example");
		try {
			List<Maintenancerecord> results = (List<Maintenancerecord>) getHibernateTemplate()
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
		log.debug("finding Maintenancerecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Maintenancerecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Maintenancerecord> findByMaintenanceKind(Object maintenanceKind) {
		return findByProperty(MAINTENANCE_KIND, maintenanceKind);
	}

	public List<Maintenancerecord> findByMaintenancePlace(
			Object maintenancePlace) {
		return findByProperty(MAINTENANCE_PLACE, maintenancePlace);
	}

	public List<Maintenancerecord> findByMaintenanceDays(Object maintenanceDays) {
		return findByProperty(MAINTENANCE_DAYS, maintenanceDays);
	}

	public List<Maintenancerecord> findByMaintenanceContent(
			Object maintenanceContent) {
		return findByProperty(MAINTENANCE_CONTENT, maintenanceContent);
	}

	public List<Maintenancerecord> findByChangeRecord(Object changeRecord) {
		return findByProperty(CHANGE_RECORD, changeRecord);
	}

	public List<Maintenancerecord> findByOutFactoryState(Object outFactoryState) {
		return findByProperty(OUT_FACTORY_STATE, outFactoryState);
	}

	public List<Maintenancerecord> findByAttentionMatters(
			Object attentionMatters) {
		return findByProperty(ATTENTION_MATTERS, attentionMatters);
	}

	public List<Maintenancerecord> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Maintenancerecord instances");
		try {
			String queryString = "from Maintenancerecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Maintenancerecord merge(Maintenancerecord detachedInstance) {
		log.debug("merging Maintenancerecord instance");
		try {
			Maintenancerecord result = (Maintenancerecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Maintenancerecord instance) {
		log.debug("attaching dirty Maintenancerecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Maintenancerecord instance) {
		log.debug("attaching clean Maintenancerecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}