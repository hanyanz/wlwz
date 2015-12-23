package com.wlwz.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ITechnicevaluationDAO;
import com.wlwz.entity.Technicevaluation;


/**
 * A data access object (DAO) providing persistence and search support for
 * Technicevaluation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlw.Technicevaluation
 * @author MyEclipse Persistence Tools
 */
@Component("technicevaluationDAO")
public class TechnicevaluationDAOImpl extends SuperDao implements
                    ITechnicevaluationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TechnicevaluationDAOImpl.class);
	// property constants
	public static final String PRESENT_TECHNIC_STATUS = "presentTechnicStatus";
	public static final String EVALUATE_ADVICE = "evaluateAdvice";
	public static final String IDENTIFIER = "identifier";
	public static final String IS_ACTIVE = "isActive";

	public void save(Technicevaluation transientInstance) {
		log.debug("saving Technicevaluation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Technicevaluation persistentInstance) {
		log.debug("deleting Technicevaluation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Technicevaluation findById(java.lang.String id) {
		log.debug("getting Technicevaluation instance with id: " + id);
		try {
			Technicevaluation instance = (Technicevaluation) getHibernateTemplate().get(
					"com.wlwz.entity.Technicevaluation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Technicevaluation> findByExample(Technicevaluation instance) {
		log.debug("finding Technicevaluation instance by example");
		try {
			List<Technicevaluation> results = (List<Technicevaluation>) getHibernateTemplate()
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
		log.debug("finding Technicevaluation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Technicevaluation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Technicevaluation> findByPresentTechnicStatus(
			Object presentTechnicStatus) {
		return findByProperty(PRESENT_TECHNIC_STATUS, presentTechnicStatus);
	}

	public List<Technicevaluation> findByEvaluateAdvice(Object evaluateAdvice) {
		return findByProperty(EVALUATE_ADVICE, evaluateAdvice);
	}

	public List<Technicevaluation> findByIdentifier(Object identifier) {
		return findByProperty(IDENTIFIER, identifier);
	}

	

	public List findAll() {
		log.debug("finding all Technicevaluation instances");
		try {
			String queryString = "from Technicevaluation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Technicevaluation merge(Technicevaluation detachedInstance) {
		log.debug("merging Technicevaluation instance");
		try {
			Technicevaluation result = (Technicevaluation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Technicevaluation instance) {
		log.debug("attaching dirty Technicevaluation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Technicevaluation instance) {
		log.debug("attaching clean Technicevaluation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}