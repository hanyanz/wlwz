package com.wlwz.service;

import java.util.List;

//import com.wlwz.entity.Newdata;
//import com.wlwz.entity.Surveillancedata;

import com.wlwz.protocol.MessageReceived;

public interface IRunningdataService {
	public int[] getDeviceIdByIdtify(String IMEI, String userName);

	// 根据设备编码搜索记录条数
	public long countRunningdata(String deviceId);
	
	public void saveRunningdata(String sql,int userGroup) throws Exception;
	
	public List loadRunningdataList(Integer start,
			Integer limit, String deviceId);
}
