package com.wlwz.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.record.formula.functions.Now;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IDeviceDAO;
import com.wlwz.dao.IUnitDAO;
import com.wlwz.dao.IProjectDAO;
import com.wlwz.entity.Device;
import com.wlwz.entity.Unit;
import com.wlwz.entity.Project;
import com.wlwz.service.IDeviceService;

@Component("deviceService")
public class DeviceServiceImpl implements IDeviceService {

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

	private IProjectDAO projectDAO;

	@Resource(name = "project_DAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	private IUnitDAO unitDAO;

	@Resource(name = "unit_DAO")
	public void setUnitDAO(IUnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}

	// 根据项目、中队搜索设备数量
	public Long countDevice(String projectName, String midteamName) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Device.class);
		if (projectName != null && !"".equals(projectName)) {
			dtr.createAlias("project", "project");
			dtr.add(Restrictions.like("project.projectName", "%" + projectName
					+ "%"));
		}
		if (midteamName != null && !"".equals(midteamName)) {
			dtr.createAlias("midteam", "midteam");
			dtr.add(Restrictions.like("midteam.midteamName", "%" + midteamName
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	// 根据项目、中队搜索设备列表
	public List<Device> loadDeviceList(Integer start, Integer limit,
			String projectName, String midteamName) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Device.class);
		if (projectName != null && !"".equals(projectName)) {
			dtr.createAlias("project", "project");
			dtr.add(Restrictions.like("project.projectName", "%" + projectName
					+ "%"));
		}
		if (midteamName != null && !"".equals(midteamName)) {
			dtr.createAlias("midteam", "midteam");
			dtr.add(Restrictions.like("midteam.midteamName", "%" + midteamName
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("deviceId"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 新建设备信息
	public void createDevice(Integer unitId, Integer projectId,
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
			String rightLevel, Boolean isActive, Float weight, String deviceSize) {
		Device device = new Device();
		if (unitId != null && !"".equals(unitId)) {
			Unit unit = unitDAO.findById(unitId);
			device.setUnit(unit);
		} else {
			device.setUnit(null);
		}
		if (projectId != null && !"".equals(projectId)) {
			Project project = projectDAO.findById(projectId);
			device.setProject(project);
		} else {
			device.setProject(null);
		}
	//	device.setImeiSeriers(imeiSeriers);
		device.setDeviceKind(deviceKind);
		device.setDeviceNumber(deviceNumber);
	//	device.setUnitCode(unitCode);
		device.setAssetNumber(assetNumber);
	//	device.setUnitName(unitName);
		device.setDeviceName(deviceName);
		device.setDeviceBigKind(deviceBigKind);
		device.setTypeName(typeName);
		device.setOperationDate(operationDate);
		device.setModel(model);
		device.setManufactDate(manufactDate);
		device.setPosition(position);
		device.setFactoryArea(factoryArea);
		device.setAbclogo(abclogo);
		device.setCompany(company);
	//	device.setCostCenter(costCenter);
		device.setPlannersGroup(plannersGroup);
	//	device.setMaintainFuncCenter(maintainFuncCenter);
		device.setReportFuncPlace(reportFuncPlace);
		device.setTechnicNum(technicNum);
	//	device.setFuelConsumption(fuelConsumption);
		device.setAssetsProperty(assetsProperty);
		device.setAssetsOriginalValue(assetsOriginalValue);
		device.setAssetsAdded(assetsAdded);
		device.setAssetsAddDate(assetsAddDate);
		device.setSerialNumber(serialNumber);
		device.setInventory(inventory);
		device.setDeviceState(deviceState);
	//	device.setDeviceSize(deviceSize);
		device.setWeight(weight);
		device.setIsActive(true);
		deviceDAO.save(device);
	}

	public void deleteDevice(Integer deviceId) {
		if (deviceId != null && !"".equals(deviceId)) {
			Device device = deviceDAO.findById(deviceId);
			device.setIsActive(false);
			deviceDAO.attachDirty(device);
		}
	}

	// 获取项目列表，供新建设备时候选择所属项目
	public List<Project> getAllProjects() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Project.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("projectId"));
		return commonDAO.findByDetachedCriteria(dtr);
	}

	// 获取中队列表，供新建设备时候选择所属中队
	public List<Unit> getAllUnits() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Unit.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("midteamId"));
		return commonDAO.findByDetachedCriteria(dtr);
	}
}
