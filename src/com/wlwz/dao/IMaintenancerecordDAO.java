package com.wlwz.dao;

import com.wlwz.entity.Maintenancerecord;

public interface IMaintenancerecordDAO {
	public Maintenancerecord findById(java.lang.String id);

	public void save(Maintenancerecord transientInstance);

	public void attachDirty(Maintenancerecord instance);
}
