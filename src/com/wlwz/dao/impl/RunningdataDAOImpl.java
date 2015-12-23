package com.wlwz.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IRunningdataDAO;

import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Runningdata3 entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wlwz.entity.Runningdata
 * @author MyEclipse Persistence Tools
 */
@Component("runningdataDAO")
public class RunningdataDAOImpl extends SuperDao implements
            IRunningdataDAO  {
	private static final Logger log = LoggerFactory
			.getLogger(RunningdataDAOImpl.class);
	// property constants


	private String driverName = "com.mysql.jdbc.Driver";
	 private String sourceURL = "jdbc:mysql://localhost:3306/wlwz";
	 private Connection conn = null;
	 private Statement statement = null;
	 
	public void save(int userGroup, String sql) throws Exception {
		log.debug("saving Runningdata"+userGroup+" instance");
		try {
			Class.forName(driverName);
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "102023");
			conn = DriverManager.getConnection(sourceURL, prop);
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			log.debug("save successful");
		} catch (RuntimeException re) {
				log.error("save failed", re);
				throw re;
		}finally {
				try {
					// 切记要关闭
					statement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		}
	}

	public List queryBySql(final String sql){
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		return list;
	}

	public int excuteBySql(String sql){
		int result ;
		if(sql.startsWith("select")){
			List<Object[]> list = getSession().createSQLQuery(sql).list();
			result = list.size();
		}else{
			SQLQuery query = getSession().createSQLQuery(sql);
			result = query.executeUpdate();
		}
		return result;
	}



}