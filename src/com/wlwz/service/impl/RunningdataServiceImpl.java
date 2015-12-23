package com.wlwz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.wlwz.util.ReqRes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IDeviceDAO;
import com.wlwz.dao.IRunningdataDAO;
import com.wlwz.dao.IUserDAO;
import com.wlwz.entity.Device;
import com.wlwz.entity.User;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IRunningdataService;

@Component("runningdata_Service")
public class RunningdataServiceImpl implements IRunningdataService {
	private static final Logger logger = Logger
			.getLogger(RunningdataServiceImpl.class);
	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private IDeviceDAO deviceDAO;

	@Resource(name = "deviceDAO")
	public void setDeviceDAO(IDeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	private IUserDAO userDAO;

	@Resource(name = "user_DAO")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private IRunningdataDAO runningdataDAO;

	@Resource(name = "runningdataDAO")
	public void setRunningdataDAO(IRunningdataDAO runningdataDAO) {
		this.runningdataDAO = runningdataDAO;
	}


	//接收数据时，验证身份有效性，即IMEI和user信息是否一致,一致则返回deviceId
	public int[] getDeviceIdByIdtify(String IMEI, String userName){
		System.out.println(IMEI+" "+userName);
		int[] result = {-1, -1};
		
		//通过用户名得到userGroup
		List usersList = userDAO.findByProperty("userName", userName);
		if (usersList == null || usersList.size() != 1)
			return null;
		User u = (User) usersList.get(0);
		Userstate userstate = u.getUserstate();
		int userGroup1 =userstate.getUserGroup();
		
		//通过Imei得到userGroup
		List<Device> deviceList = deviceDAO.findByImei(IMEI);
		if (deviceList == null || deviceList.size() == 0)
			return result;
		int userGroup2 = -1;
		for(Device ss : deviceList){
			 userGroup2 = ss.getUserstate().getUserGroup();
			
			if(userGroup1 == userGroup2){
				int deviceId = deviceList.get(1).getDeviceId();
				result[0] = deviceId;
				result[1] = userGroup1;
				return result;
			}
		}
		  return result;
		
	}
	
	public void saveRunningdata(String sql,int userGroup) throws Exception{
		runningdataDAO.save(userGroup, sql);
		System.out.println("save runningdata successfully");
		
	}

	// 根据设备编码搜索记录条数
	public long countRunningdata(String deviceId) {
		Integer userGroup = null;
		try{
			userGroup  = (Integer) ReqRes.getSession().getAttribute("userGroup");
		}catch ( Exception e){
			System.out.println(e.getCause());
		}
		if(userGroup == null){
			return 0;
		}
		String sqlStr = "select * from " + ("runningdata"+userGroup);
		if(deviceId != null){
			sqlStr += " WHERE deviceId = " + deviceId;
		}


		return runningdataDAO.excuteBySql(sqlStr);
	}
	
	public List loadRunningdataList(Integer start,Integer limit, String deviceId){
		Integer userGroup = null;
		try{
			userGroup  = (Integer) ReqRes.getSession().getAttribute("userGroup");
		}catch ( Exception e){
			System.out.println(e.getCause());
		}
		if(userGroup == null){
			return null;
		}
		String sqlStr = "select * from " + ("runningdata"+userGroup);
		if(deviceId != null){
			sqlStr += " WHERE deviceId = " + deviceId;
		}

		sqlStr += " limit "+ start +"," + limit;

		List result = runningdataDAO.queryBySql(sqlStr);
		return result;

	}
   
}
