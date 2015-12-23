package com.wlwz.dao;


import java.util.List;

import com.wlwz.entity.Device;


public interface IDeviceDAO {
	public Device getByIMEISeriers(String IMEISeriers);

	public Device findByDeviceNumber(Object value);

	public void save(Device transientInstance);

	public Device findById(java.lang.Integer id);
	
	public List<Device> findByImei(Object imei);

	public void attachDirty(Device instance);
}
