package com.wlwz.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IDeviceDAO;
import com.wlwz.dao.IMaintenancerecordDAO;
import com.wlwz.entity.Device;
import com.wlwz.entity.Maintenancerecord;
import com.wlwz.service.IMaintenancerecordService;

@Component("maintenancerecordService")
public class MaintenancerecordServiceImpl implements IMaintenancerecordService {
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

	private IMaintenancerecordDAO maintenancerecordDAO;

	@Resource(name = "maintenancerecordDAO")
	public void setMaintenancerecordDAO(
			IMaintenancerecordDAO maintenancerecordDAO) {
		this.maintenancerecordDAO = maintenancerecordDAO;
	}

	// 根据设备编码搜索保修记录条数
	public Long countMaintenancerecord(String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria
				.forClass(Maintenancerecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	// 根据设备编码搜索保修记录list
	public List<Maintenancerecord> loadMaintenancerecordList(Integer start,
			Integer limit, String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria
				.forClass(Maintenancerecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 创建一条新的维修记录
	public void createMaintenancerecord(Timestamp createTime,
			Integer maintenanceKind, Timestamp inFactoryDate,
			Timestamp workStartDate, Timestamp workEndDate,
			String maintenancePlace, Integer maintenanceDays,
			Timestamp thisRoundTime, String maintenanceContent,
			String changeRecord, String outFactoryState,
			String attentionMatters, String deviceNumber) {
		Device device = new Device();
		if (deviceNumber != null && !"".equals(deviceNumber)) {
			device = deviceDAO.findByDeviceNumber(deviceNumber);
		}
		Maintenancerecord m = new Maintenancerecord();
		UUID uuid = UUID.randomUUID();
		m.setMaintenanceRecordId(uuid.toString());
		m.setCreateTime(createTime);
		m.setMaintenanceKind(maintenanceKind);
		m.setInFactoryDate(inFactoryDate);
		m.setWorkStartDate(workStartDate);
		m.setWorkEndDate(workEndDate);
		m.setMaintenancePlace(maintenancePlace);
		m.setMaintenanceDays(maintenanceDays);
		m.setThisRoundTime(thisRoundTime);
		m.setMaintenanceContent(maintenanceContent);
		m.setChangeRecord(changeRecord);
		m.setOutFactoryState(outFactoryState);
		m.setAttentionMatters(attentionMatters);
		m.setDevice(device);
		m.setIsActive(true);
		maintenancerecordDAO.save(m);
	}

	// 保存维修记录
	public void saveEdit(String id, Timestamp createTime,
			Integer maintenanceKind, Timestamp inFactoryDate,
			Timestamp workStartDate, Timestamp workEndDate,
			String maintenancePlace, Integer maintenanceDays,
			Timestamp thisRoundTime, String maintenanceContent,
			String changeRecord, String outFactoryState, String attentionMatters) {
		if (id != null && !"".equals(id)) {
			Maintenancerecord m = new Maintenancerecord();
			m = maintenancerecordDAO.findById(id);
			if (m != null) {
				m.setCreateTime(createTime);
				m.setMaintenanceKind(maintenanceKind);
				m.setInFactoryDate(inFactoryDate);
				m.setWorkStartDate(workStartDate);
				m.setWorkEndDate(workEndDate);
				m.setMaintenancePlace(maintenancePlace);
				m.setMaintenanceDays(maintenanceDays);
				m.setThisRoundTime(thisRoundTime);
				m.setMaintenanceContent(maintenanceContent);
				m.setChangeRecord(changeRecord);
				m.setOutFactoryState(outFactoryState);
				m.setAttentionMatters(attentionMatters);

				maintenancerecordDAO.attachDirty(m);
			}
		}
	}

	// 搜索一条维修记录具体内容
	public Maintenancerecord loadOneMaintenancerecord(String id) {
		if (id != null && !"".equals(id)) {
			Maintenancerecord m = new Maintenancerecord();
			m = maintenancerecordDAO.findById(id);
			return m;
		}
		return null;
	}

	// 删除一条维修记录
	public void deleteRecord(String id) {
		if (id != null && !"".equals(id)) {
			Maintenancerecord m = new Maintenancerecord();
			m = maintenancerecordDAO.findById(id);
			if (m != null) {
				m.setIsActive(false);
				maintenancerecordDAO.attachDirty(m);
			}
		}
	}
}
