package com.wlwz.dao.impl;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("Super_DAO")
public class SuperDao extends HibernateDaoSupport {
	//注入spring的bean文件
	@Resource(name = "hibernateTemplate")
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	public Long findByDetachedCriteriaForCount(DetachedCriteria dtr) {
		// TODO Auto-generated method stub
		return null;
	}

}
