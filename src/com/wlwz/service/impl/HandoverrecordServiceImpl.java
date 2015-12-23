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
import com.wlwz.dao.IHandoverrecordDAO;
import com.wlwz.entity.Device;
import com.wlwz.entity.Handoverrecord;
import com.wlwz.service.IHandoverrecordService;

@Component("handoverrecordService")
public class HandoverrecordServiceImpl implements IHandoverrecordService {
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

	private IHandoverrecordDAO handoverrecordDAO;

	@Resource(name = "handoverrecordDAO")
	public void setHandoverrecordDAO(IHandoverrecordDAO handoverrecordDAO) {
		this.handoverrecordDAO = handoverrecordDAO;
	}

	// 统计交接记录条数
	public Long countHandoverrecord(String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Handoverrecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	// 搜索交接记录list
	public List<Handoverrecord> loadHandoverrecordList(Integer start,
			Integer limit, String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Handoverrecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 创建一条新的交接记录
	public void createHandoverrecord(String deviceNumber, Timestamp createTime,
			String transferUnit, String transferPerson, String acceptUint,
			String acceptPerson) {
		Device device = new Device();
		if (deviceNumber != null && !"".equals(deviceNumber)) {
			device = deviceDAO.findByDeviceNumber(deviceNumber);
		}
		Handoverrecord h = new Handoverrecord();
		UUID uuid = UUID.randomUUID();
		h.setHandoverRecordId(uuid.toString());
		h.setDevice(device);
		h.setCreateTime(createTime);
		h.setTransferUnit(transferUnit);
		h.setTransferPerson(transferPerson);
		h.setAcceptUint(acceptUint);
		h.setAcceptPerson(acceptPerson);
		h.setIsActive(true);
		handoverrecordDAO.save(h);
	}

	// 保存对交接记录的修改
	public void saveEdit(String id, Timestamp createTime, String transferUnit,
			String transferPerson, String acceptUint, String acceptPerson) {
		if (id != null && !"".equals(id)) {
			Handoverrecord h = new Handoverrecord();
			h = handoverrecordDAO.findById(id);
			if (h != null) {
				h.setCreateTime(createTime);
				h.setTransferUnit(transferUnit);
				h.setTransferPerson(transferPerson);
				h.setAcceptUint(acceptUint);
				h.setAcceptPerson(acceptPerson);
				handoverrecordDAO.attachDirty(h);
			}
		}
	}

	// 根据ID搜索一条具体的交接记录
	public Handoverrecord loadOneHandoverrecord(String id) {
		if (id != null && !"".equals(id)) {
			Handoverrecord h = new Handoverrecord();
			h = handoverrecordDAO.findById(id);
			return h;
		}
		return null;
	}

	// 删除一条交接记录
	public void deleteRecord(String id) {
		if (id != null && !"".equals(id)) {
			Handoverrecord h = new Handoverrecord();
			h = handoverrecordDAO.findById(id);
			if (h != null) {
				h.setIsActive(false);
				handoverrecordDAO.attachDirty(h);
			}
		}
	}
}
