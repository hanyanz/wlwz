package com.wlwz.service;

import java.sql.Timestamp;
import java.util.List;

import com.wlwz.entity.Device;
import com.wlwz.entity.Unit;
import com.wlwz.entity.Project;

public interface IDeviceService {
	public Long countDevice(String projectName, String midteamName);

	public List<Device> loadDeviceList(Integer start, Integer limit,
			String projectName, String midteamName);

	public void createDevice(Integer midteamId, Integer projectId,
			String imeiSeriers, String deviceKind, String deviceNumber,
			String unitCode, String assetNumber, String unitName,
			String deviceName, Integer deviceBigKind, String typeName,
			Timestamp operationDate, String model, Timestamp manufactDate,
			String position, String factoryArea, String abclogo,
			String company, String costCenter, String plannersGroup,
			String maintainFuncCenter, String reportFuncPlace,
			String technicNum, Float fuelConsumption, String assetsProperty,
			Float assetsOriginalValue, Float assetsAdded,
			Timestamp assetsAddDate, Timestamp totalRunningTime,
			Integer totalGoodDays, Float totalDistance, Integer toatlUesdDays,
			Integer serialNumber, String inventory, Boolean deviceState,
			String rightLevel, Boolean isActive, Float weight, String deviceSize);

	public List<Project> getAllProjects();

	public List<Unit> getAllUnits();

	public void deleteDevice(Integer deviceId);
}
