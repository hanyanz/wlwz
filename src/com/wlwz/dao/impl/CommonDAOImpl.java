package com.wlwz.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;

@Component("comDAO")
public class CommonDAOImpl extends SuperDao implements ICommonDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dmlab.oa.dao.impl.CommonDAO#findByDetachedCriteriaForCount(org.hibernate
	 * .criterion.DetachedCriteria)
	 */
	@Override
	public Long findByDetachedCriteriaForCount(DetachedCriteria dtr) {
		Session ses = null;
		try {
			ses = this.getHibernateTemplate().getSessionFactory().openSession();
			Criteria ctr = dtr.getExecutableCriteria(ses);
			Long count = (Long) ctr.setProjection(Projections.rowCount())
					.uniqueResult();
			//通过DetachedCriteria创建一个Criteria。此处Criteria才有uniqueResult()的方法
			//dtr.setProjection(Projections.rowCount()).
			ses.close();
			ses = null;
			return count;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (ses != null)
				ses.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dmlab.oa.dao.impl.CommonDAO#findByDetachedCriteriaWithLimit(org.hibernate
	 * .criterion.DetachedCriteria, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List findByDetachedCriteriaWithLimit(DetachedCriteria dtr,
			Integer start, Integer limit) {
		Session ses = null;
		try {
			ses = this.getHibernateTemplate().getSessionFactory().openSession();
			Criteria ctr = dtr.getExecutableCriteria(ses);
			if (start != null)
				ctr.setFirstResult(start);
			if (limit != null)
				ctr.setMaxResults(limit);
			List lst = ctr.list();
			ses.close();
			ses = null;
			// Date now = new Date();
			// System.out.println(now.toString());
			return lst;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (ses != null)
				ses.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dmlab.oa.dao.impl.CommonDAO#findByDetachedCriteria(org.hibernate.
	 * criterion.DetachedCriteria)
	 */
	public List findByDetachedCriteria(DetachedCriteria dtr) {
		Session ses = null;
		try {
			ses = this.getHibernateTemplate().getSessionFactory().openSession();
			Criteria ctr = dtr.getExecutableCriteria(ses);
			List lst = ctr.list();
			ses.close();
			ses = null;
			return lst;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (ses != null)
				ses.close();
		}
	}

	public void deleteById(Integer id, String cls) {
		Session ses = null;
		try {
			ses = getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = ses.beginTransaction();
			String deletsql = "delete from " + cls + " where id= '" + id + "'";
			Query q = ses.createQuery(deletsql);
			q.executeUpdate();
			tx.commit();
			ses.close();
			ses = null;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (ses != null) {
				ses.close();
			}
		}
	}
}
