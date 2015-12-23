//package com.wlwz.dao.impl;
//
//import java.util.List;
//
//import org.hibernate.LockMode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.wlwz.dao.IRunningdataDAO;
//import com.wlwz.entity.Runningdata;
//
///**
// * A data access object (DAO) providing persistence and search support for
// * Runningdata3 entities. Transaction control of the save(), update() and
// * delete() operations can directly support Spring container-managed
// * transactions or they can be augmented to handle user-managed Spring
// * transactions. Each of these methods provides additional information for how
// * to configure it for the desired type of transaction control.
// * 
// * @see com.wlwz.entity.Runningdata
// * @author MyEclipse Persistence Tools
// */
//
//public class CopyOfRunningdataDAOImpl extends SuperDao implements
//            IRunningdataDAO  {
//	private static final Logger log = LoggerFactory
//			.getLogger(CopyOfRunningdataDAOImpl.class);
//	// property constants
//	
//	public void save(Runningdata transientInstance) {
//		log.debug("saving Runningdata instance");
//		try {
//			getHibernateTemplate().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Runningdata persistentInstance) {
//		log.debug("deleting Runningdata instance");
//		try {
//			getHibernateTemplate().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Runningdata findById(java.lang.Integer id) {
//		log.debug("getting Runningdata instance with id: " + id);
//		try {
//			Runningdata instance = (Runningdata) getHibernateTemplate().get(
//					"com.wlwz.entity.Runningdata", id);
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//	public List<Runningdata> findByExample(Runningdata instance) {
//		log.debug("finding Runningdata instance by example");
//		try {
//			List<Runningdata> results = (List<Runningdata>) getHibernateTemplate()
//					.findByExample(instance);
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Runningdata instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Runningdata as model where model."
//					+ propertyName + "= ?";
//			return getHibernateTemplate().find(queryString, value);
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	
//	public List findAll() {
//		log.debug("finding all Runningdata instances");
//		try {
//			String queryString = "from Runningdata";
//			return getHibernateTemplate().find(queryString);
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
//
//	public Runningdata merge(Runningdata detachedInstance) {
//		log.debug("merging Runningdata instance");
//		try {
//			Runningdata result = (Runningdata) getHibernateTemplate().merge(
//					detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Runningdata instance) {
//		log.debug("attaching dirty Runningdata instance");
//		try {
//			getHibernateTemplate().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Runningdata instance) {
//		log.debug("attaching clean Runningdata instance");
//		try {
//			getHibernateTemplate().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	@Override
//	public void save(String sql) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//}