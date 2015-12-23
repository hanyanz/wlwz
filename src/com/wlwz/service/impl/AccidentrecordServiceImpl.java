package com.wlwz.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IAccidentrecordDAO;
import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IDeviceDAO;
import com.wlwz.entity.Accidentrecord;
import com.wlwz.entity.Device;
import com.wlwz.service.IAccidentrecordService;

@Component("accidentrecordService")
public class AccidentrecordServiceImpl implements IAccidentrecordService {

	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private IAccidentrecordDAO accidentrecordDAO;

	@Resource(name = "accidentrecordDAO")
	public void setAccidentrecordDAO(IAccidentrecordDAO accidentrecordDAO) {
		this.accidentrecordDAO = accidentrecordDAO;
	}

	private IDeviceDAO deviceDAO;

	@Resource(name = "deviceDAO")
	public void setDeviceDAO(IDeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	/**
	 * 查询数据记录条数，根据设备条件搜索
	 */
	public Long countAccidentrecord(Integer queryDeviceId) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Accidentrecord.class);
		if ((queryDeviceId != null && !"".equals(queryDeviceId)))
			dtr.add(Restrictions.like("Device.queryDeviceId", "%"
					+ queryDeviceId + "%"));
		dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	/**
	 * 查询数据记录，搜索条件为首尾页、设备代码
	 */
	public List<Accidentrecord> loadAllAccidentrecord(Integer start,
			Integer limit, Integer queryDeviceId) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Accidentrecord.class);
		if ((queryDeviceId != null && !"".equals(queryDeviceId)))
			dtr.add(Restrictions.like("Device.queryDeviceId", "%"
					+ queryDeviceId + "%"));
		dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	/**
	 * 查询数据记录条数，根据设备条件搜索
	 */
	public Long countAccidentrecord(String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Accidentrecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	/**
	 * 查询数据记录，搜索条件为首尾页、设备代码
	 */
	public List<Accidentrecord> loadAccidentrecordList(Integer start,
			Integer limit, String deviceNumber) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Accidentrecord.class);

		if (deviceNumber != null && !"".equals(deviceNumber)) {
			dtr.createAlias("device", "device");
			dtr.add(Restrictions.like("device.deviceNumber", "%" + deviceNumber
					+ "%"));
		}
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 新建一条事故记录
	public void creatAccidentRecord(Timestamp createTime, Short accidentType,
			String accidentUint, String responsiblePerson,
			String accidentReason, String damageAssessment, Float damageValue,
			String disposeRecord, String deviceNumber) {
		Device device = new Device();
		if (deviceNumber != null && !"".equals(deviceNumber)) {
			device = deviceDAO.findByDeviceNumber(deviceNumber);
		}
		Accidentrecord arecord = new Accidentrecord();
		UUID uuid = UUID.randomUUID();
		arecord.setAccidentRecordId(uuid.toString());
		arecord.setCreateTime(createTime);
		arecord.setAccidentType(accidentType);
		arecord.setAccidentUint(accidentUint);
		arecord.setAccidentReason(accidentReason);
		arecord.setResponsiblePerson(responsiblePerson);
		arecord.setDamageAssessment(damageAssessment);
		arecord.setDamageValue(damageValue);
		arecord.setDisposeRecord(disposeRecord);
		arecord.setIsActive(true);
		arecord.setDevice(device);

		accidentrecordDAO.save(arecord);
	}

	// 查询一条记录
	public Accidentrecord loadOneAccidentrecord(String accidentRecordId) {
		if (accidentRecordId != null && !"".equals(accidentRecordId)) {
			Accidentrecord a = new Accidentrecord();
			a = accidentrecordDAO.findById(accidentRecordId);
			return a;
		}
		return null;
	}

	// 保存对记录的修改
	public void saveEdit(String id, Timestamp createTime, Short accidentType,
			String accidentUint, String responsiblePerson,
			String accidentReason, String damageAssessment, Float damageValue,
			String disposeRecord) {
		if (id != null && !"".equals(id)) {
			Accidentrecord arecord = new Accidentrecord();
			arecord = accidentrecordDAO.findById(id);
			if (arecord != null) {
				arecord.setCreateTime(createTime);
				arecord.setAccidentType(accidentType);
				arecord.setAccidentUint(accidentUint);
				arecord.setAccidentReason(accidentReason);
				arecord.setResponsiblePerson(responsiblePerson);
				arecord.setDamageAssessment(damageAssessment);
				arecord.setDamageValue(damageValue);
				arecord.setDisposeRecord(disposeRecord);

				accidentrecordDAO.attachDirty(arecord);
			}
		}
	}

	// 暂时采用逻辑删除，对数据库内容不进行物理删除
	public void deleteRecord(String id) {
		if (id != null && !"".equals(id)) {
			Accidentrecord a = new Accidentrecord();
			a = accidentrecordDAO.findById(id);
			if (a != null) {
				a.setIsActive(false);
				accidentrecordDAO.attachDirty(a);
				// accidentrecordDAO.delete(a);
			}
		}
	}
}
