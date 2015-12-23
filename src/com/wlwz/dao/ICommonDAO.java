package com.wlwz.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface ICommonDAO {

	public abstract Long findByDetachedCriteriaForCount(DetachedCriteria dtr);

	public List findByDetachedCriteriaWithLimit(DetachedCriteria dtr,
			Integer start, Integer limit);

	public abstract List findByDetachedCriteria(DetachedCriteria dtr);

	public abstract void deleteById(Integer id, String cls);
}