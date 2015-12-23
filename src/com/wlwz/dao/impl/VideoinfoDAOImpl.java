package com.wlwz.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IVideoinfoDAO;
import com.wlwz.entity.Videoinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Videoinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlwz.entity.Videoinfo
 * @author MyEclipse Persistence Tools
 */
@Component("videoinfoDAO")
public class VideoinfoDAOImpl extends SuperDao  implements IVideoinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VideoinfoDAOImpl.class);
	// property constants
	public static final String IMEI = "imei";
	public static final String USER_GROUP = "userGroup";
	public static final String VIDEO_URL = "videoUrl";

	public void save(Videoinfo transientInstance) {
		log.debug("saving Videoinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Videoinfo persistentInstance) {
		log.debug("deleting Videoinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Videoinfo findById(java.lang.Integer id) {
		log.debug("getting Videoinfo instance with id: " + id);
		try {
			Videoinfo instance = (Videoinfo) getHibernateTemplate().get(
					"com.wlwz.entity.Videoinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Videoinfo> findByExample(Videoinfo instance) {
		log.debug("finding Videoinfo instance by example");
		try {
			List<Videoinfo> results = (List<Videoinfo>) getHibernateTemplate()
					.findByExample(instance);;
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Videoinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Videoinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Videoinfo> findByImei(Object imei) {
		return findByProperty(IMEI, imei);
	}

	public List<Videoinfo> findByUserGroup(Object userGroup) {
		return findByProperty(USER_GROUP, userGroup);
	}

	public List<Videoinfo> findByVideoUrl(Object videoUrl) {
		return findByProperty(VIDEO_URL, videoUrl);
	}

	public List findAll() {
		log.debug("finding all Videoinfo instances");
		try {
			String queryString = "from Videoinfo";		
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Videoinfo merge(Videoinfo detachedInstance) {
		log.debug("merging Videoinfo instance");
		try {
			Videoinfo result = (Videoinfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Videoinfo instance) {
		log.debug("attaching dirty Videoinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Videoinfo instance) {
		log.debug("attaching clean Videoinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}