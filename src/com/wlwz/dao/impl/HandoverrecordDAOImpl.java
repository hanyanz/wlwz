package com.wlwz.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IHandoverrecordDAO;
import com.wlwz.entity.Handoverrecord;


/**
 * A data access object (DAO) providing persistence and search support for
 * Handoverrecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Handoverrecord
 * @author MyEclipse Persistence Tools
 */
@Component("handoverrecordDAO")
public class HandoverrecordDAOImpl extends SuperDao implements
      IHandoverrecordDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HandoverrecordDAOImpl.class);
	// property constants
	public static final String TRANSFER_UNIT = "transferUnit";
	public static final String TRANSFER_PERSON = "transferPerson";
	public static final String ACCEPT_UINT = "acceptUint";
	public static final String ACCEPT_PERSON = "acceptPerson";
	public static final String IS_ACTIVE = "isActive";

	public void save(Handoverrecord transientInstance) {
		log.debug("saving Handoverrecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Handoverrecord persistentInstance) {
		log.debug("deleting Handoverrecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Handoverrecord findById(java.lang.String id) {
		log.debug("getting Handoverrecord instance with id: " + id);
		try {
			Handoverrecord instance = (Handoverrecord) getHibernateTemplate().get(
					"com.wlwz.entity.Handoverrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Handoverrecord> findByExample(Handoverrecord instance) {
		log.debug("finding Handoverrecord instance by example");
		try {
			List<Handoverrecord> results = (List<Handoverrecord>) getHibernateTemplate()
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
		log.debug("finding Handoverrecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Handoverrecord as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Handoverrecord> findByTransferUnit(Object transferUnit) {
		return findByProperty(TRANSFER_UNIT, transferUnit);
	}

	public List<Handoverrecord> findByTransferPerson(Object transferPerson) {
		return findByProperty(TRANSFER_PERSON, transferPerson);
	}

	public List<Handoverrecord> findByAcceptUint(Object acceptUint) {
		return findByProperty(ACCEPT_UINT, acceptUint);
	}

	public List<Handoverrecord> findByAcceptPerson(Object acceptPerson) {
		return findByProperty(ACCEPT_PERSON, acceptPerson);
	}

	public List<Handoverrecord> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Handoverrecord instances");
		try {
			String queryString = "from Handoverrecord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Handoverrecord merge(Handoverrecord detachedInstance) {
		log.debug("merging Handoverrecord instance");
		try {
			Handoverrecord result = (Handoverrecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Handoverrecord instance) {
		log.debug("attaching dirty Handoverrecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Handoverrecord instance) {
		log.debug("attaching clean Handoverrecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}