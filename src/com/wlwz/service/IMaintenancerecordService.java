package com.wlwz.service;

import java.sql.Timestamp;
import java.util.List;

import com.wlwz.entity.Maintenancerecord;

public interface IMaintenancerecordService {
	public Long countMaintenancerecord(String deviceNumber);

	public List<Maintenancerecord> loadMaintenancerecordList(Integer start,
			Integer limit, String deviceNumber);

	public void createMaintenancerecord(Timestamp createTime,
			Integer maintenanceKind, Timestamp inFactoryDate,
			Timestamp workStartDate, Timestamp workEndDate,
			String maintenancePlace, Integer maintenanceDays,
			Timestamp thisRoundTime, String maintenanceContent,
			String changeRecord, String outFactoryState,
			String attentionMatters, String deviceNumber);

	public void saveEdit(String id, Timestamp createTime,
			Integer maintenanceKind, Timestamp inFactoryDate,
			Timestamp workStartDate, Timestamp workEndDate,
			String maintenancePlace, Integer maintenanceDays,
			Timestamp thisRoundTime, String maintenanceContent,
			String changeRecord, String outFactoryState, String attentionMatters);

	public Maintenancerecord loadOneMaintenancerecord(String id);

	public void deleteRecord(String id);
}
