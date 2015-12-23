package com.wlwz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.ISystemrightDAO;
import com.wlwz.service.ISystemrightService;

@Component("systemright_Service")
public class SystemrightServiceImpl implements ISystemrightService {

	ISystemrightDAO systemrightDAO;

	@Resource(name = "systemright_DAO")
	public void setSystemrightDAO(ISystemrightDAO systemrightDAO) {
		this.systemrightDAO = systemrightDAO;
	}

	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

}
