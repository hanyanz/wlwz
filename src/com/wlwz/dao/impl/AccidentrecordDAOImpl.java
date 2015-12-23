package com.wlwz.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IAccidentrecordDAO;
import com.wlwz.entity.Accidentrecord;

/**
 * A data access object (DAO) providing persistence and search support for
 * Accidentrecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Accidentrecord
 * @author MyEclipse Persistence Tools
 */

@Component("accidentrecordDAO")
public class AccidentrecordDAOImpl extends SuperDao implements
             IAccidentrecordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AccidentrecordDAOImpl.class);
	// property constants
	public static final String ACCIDENT_TYPE = "accidentType";
	public static final String ACCIDENT_UINT = "accidentUint";
	public static final String RESPONSIBLE_PERSON = "responsiblePerson";
	public static final String ACCIDENT_REASON = "accidentReason";
	public static final String DAMAGE_ASSESSMENT = "damageAssessment";
	public static final String DAMAGE_VALUE = "damageValue";
	public static final String DISPOSE_RECORD = "disposeRecord";
	public static final String IS_ACTIVE = "isActive";

	public void save(Accidentrecord transientInstance) {
		log.debug("saving Accidentrecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Accidentrecord persistentInstance) {
		log.debug("deleting Accidentrecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Accidentrecord findById(java.lang.String id) {
		log.debug("getting Accidentrecord instance with id: " + id);
		try {
			Accidentrecord instance = (Accidentrecord) getHibernateTemplate()
			          .get("com.wlwz.entity.Accidentrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Accidentrecord> findByExample(Accidentrecord instance) {
		log.debug("finding Accidentrecord instance by example");
		try {
			List<Accidentrecord> results = (List<Accidentrecord>) getHibernateTemplate()
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
		log.debug("finding Accidentrecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Accidentrecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Accidentrecord> findByAccidentType(Object accidentType) {
		return findByProperty(ACCIDENT_TYPE, accidentType);
	}

	public List<Accidentrecord> findByAccidentUint(Object accidentUint) {
		return findByProperty(ACCIDENT_UINT, accidentUint);
	}

	public List<Accidentrecord> findByResponsiblePerson(Object responsiblePerson) {
		return findByProperty(RESPONSIBLE_PERSON, responsiblePerson);
	}

	public List<Accidentrecord> findByAccidentReason(Object accidentReason) {
		return findByProperty(ACCIDENT_REASON, accidentReason);
	}

	public List<Accidentrecord> findByDamageAssessment(Object damageAssessment) {
		return findByProperty(DAMAGE_ASSESSMENT, damageAssessment);
	}

	public List<Accidentrecord> findByDamageValue(Object damageValue) {
		return findByProperty(DAMAGE_VALUE, damageValue);
	}

	public List<Accidentrecord> findByDisposeRecord(Object disposeRecord) {
		return findByProperty(DISPOSE_RECORD, disposeRecord);
	}

	public List<Accidentrecord> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Accidentrecord instances");
		try {
			String queryString = "from Accidentrecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Accidentrecord merge(Accidentrecord detachedInstance) {
		log.debug("merging Accidentrecord instance");
		try {
			Accidentrecord result = (Accidentrecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Accidentrecord instance) {
		log.debug("attaching dirty Accidentrecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Accidentrecord instance) {
		log.debug("attaching clean Accidentrecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
}