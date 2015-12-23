package com.wlwz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IUnitDAO;
import com.wlwz.entity.Unit;
import com.wlwz.service.IUnitService;

@Component("unitService")
public class UnitServiceImpl implements IUnitService {
	private static final Logger logger = Logger
			.getLogger(UnitServiceImpl.class);

	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private IUnitDAO unitDAO;

	@Resource(name = "unit_DAO")
	public void setUnitDAO(IUnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}

	// 统计中队数量
	public Long countUnit() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Unit.class);
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	// 固定页面搜索中队列表
	public List<Unit> loadUnitList(Integer start, Integer limit) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Unit.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("unitId"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 获取list传入左侧菜单栏
	public List<Unit> getList() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Unit.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.asc("unitId"));
		return commonDAO.findByDetachedCriteria(dtr);
	}

	// 新建一个中队
	public void createUnit(String unitName, String unitBelonged,
			String unitLeader, String leaderTele) {
		Unit unit = new Unit();
		unit.setUnitName(unitName);
		unit.setUnitBelonged(unitBelonged);
		unit.setUnitLeader(unitLeader);
		unit.setLeaderTele(leaderTele);
		unit.setIsActive(true);
		unitDAO.save(unit);
	}

	// 获取一个中队具体信息
	public Unit getUnit(Integer unitId) {
		if (unitId != null) {
			Unit unit = new Unit();
			unit = unitDAO.findById(unitId);
			return unit;
		}
		return null;
	}

	// 删除一条中队信息
	public void deleteUnit(Integer unitId) {
		if (unitId != null) {
			Unit unit = new Unit();
			unit = unitDAO.findById(unitId);
			if (unit != null) {
				unit.setIsActive(false);
				unitDAO.attachDirty(unit);
			}
		}
	}

	// 保存对一条中队信息的修改
	public void saveEdit(Integer unitId, String unitName,
			String unitBelonged, String unitLeader, String leaderTele) {
		Unit unit = unitDAO.findById(unitId);
		if (unit != null) {
			unit.setUnitName(unitName);
			unit.setUnitBelonged(unitBelonged);
			unit.setUnitLeader(unitLeader);
			unit.setLeaderTele(leaderTele);
			unitDAO.attachDirty(unit);
		}
	}
}
