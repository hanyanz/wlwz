package com.wlwz.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IProjectDAO;
import com.wlwz.entity.Project;


/**
 * A data access object (DAO) providing persistence and search support for
 * Project entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlw.Project
 * @author MyEclipse Persistence Tools
 */
@Component("project_DAO")
public class ProjectDAOImpl extends SuperDao implements IProjectDAO {
	private static final Logger log = LoggerFactory.getLogger(ProjectDAOImpl.class);
	// property constants
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_ADDRESS = "projectAddress";
	public static final String PROJECT_LEADER = "projectLeader";
	public static final String TELEPHONE = "telephone";
	public static final String XCOORD = "xcoord";
	public static final String YCOORD = "ycoord";
	public static final String IS_ACTIVE = "isActive";

	public void save(Project transientInstance) {
		log.debug("saving Project instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Project persistentInstance) {
		log.debug("deleting Project instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Project findById(java.lang.Integer id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = (Project) getHibernateTemplate()
					.get("com.wlwz.entity.Project", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Project> findByExample(Project instance) {
		log.debug("finding Project instance by example");
		try {
			List<Project> results = (List<Project>) getHibernateTemplate()
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
		log.debug("finding Project instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Project as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Project> findByProjectName1(Object projectName) {
		return findByProperty(PROJECT_NAME, projectName);
	}

	public List<Project> findByProjectAddress(Object projectAddress) {
		return findByProperty(PROJECT_ADDRESS, projectAddress);
	}

	public List<Project> findByProjectLeader(Object projectLeader) {
		return findByProperty(PROJECT_LEADER, projectLeader);
	}

	public List<Project> findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List<Project> findByXcoord(Object xcoord) {
		return findByProperty(XCOORD, xcoord);
	}

	public List<Project> findByYcoord(Object ycoord) {
		return findByProperty(YCOORD, ycoord);
	}

	public List<Project> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Project instances");
		try {
			String queryString = "from Project";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = (Project) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Project instance) {
		log.debug("attaching dirty Project instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Project instance) {
		log.debug("attaching clean Project instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public Project findByProjectName(Object value) {
		try {
			String queryString = "from Project as model where model.projectName ='"
					+ value + "'";
			List<Project> list = getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
}