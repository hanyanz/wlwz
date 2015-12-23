package com.wlwz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IUserstateDAO;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IUserstateService;

@Component("userstateService")
public class UserstateServiceImpl implements IUserstateService {
		private static final Logger logger = Logger
		.getLogger(UserstateServiceImpl.class);
	
		private ICommonDAO commonDAO;
		
		@Resource(name = "comDAO")
		public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
		}
		
		private IUserstateDAO userstateDAO;
		
		@Resource(name = "userstateDAO")
		public void setUserstateDAO(IUserstateDAO userstateDAO) {
		this.userstateDAO = userstateDAO;
		}
		//新建一个用户组的状态信息
		public void createUserstate( String userSign,Integer state) {
			Userstate userstate = new Userstate();
			userstate.setUserSign(userSign);
			userstate.setState(state);
			userstate.setIsActive(true);
			userstateDAO.save(userstate);
		}
		//根据用户标志来查找用户组号
		public Integer getUsergroup(String userSign){
			  if(userSign != null){
				  Userstate userstate = new Userstate();
				  userstate = userstateDAO.findByUsersign(userSign);
				  return userstate.getUserGroup();
			  }
			
			return null;
		}
		//获取一条用户状态信息,以下可用于以id查找记录（得到用户状态信息，便于登录时页面跳转）
		public Userstate getUserState(Integer userGroup){
			  if(userGroup != null){
				  Userstate userstate = new Userstate();
				  userstate = userstateDAO.findById(userGroup);
				  return userstate;
			  }
			
			return null;
		}
		
		//修改用户状态信息
		public void  changeState(Integer userGroup,Integer state){
			
			try {
				if(userGroup != null){		
				  Userstate userstate = new Userstate();
				  userstate = userstateDAO.findById(userGroup);
				  userstate.setState(state);
				  userstateDAO.attachDirty(userstate);
				  System.out.print("状态信息修改成功！");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		

}
