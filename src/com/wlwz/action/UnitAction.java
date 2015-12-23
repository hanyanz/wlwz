package com.wlwz.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Unit;
import com.wlwz.service.IUnitService;
import com.wlwz.util.ReqRes;

@Component("unitAction")
@Scope("prototype")
public class UnitAction extends BaseAction {

	private Integer unitId;
	private String unitName;
	private String unitBelonged;
	private String unitLeader;
	private String leaderTele;
	private Boolean isActive;

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitBelonged() {
		return unitBelonged;
	}

	public void setUnitBelonged(String unitBelonged) {
		this.unitBelonged = unitBelonged;
	}

	public String getUnitLeader() {
		return unitLeader;
	}

	public void setUnitLeader(String unitLeader) {
		this.unitLeader = unitLeader;
	}

	public String getLeaderTele() {
		return leaderTele;
	}

	public void setLeaderTele(String leaderTele) {
		this.leaderTele = leaderTele;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private IUnitService unitService;

	@Resource(name = "unitService")
	public void setUnitService(IUnitService unitService) {
		this.unitService = unitService;
	}

	// 获取list传入左侧菜单栏
	public String getList() {
		try {
			HttpSession session = ReqRes.getSession();
			List mList = unitService.getList();
			session.setAttribute("mList", mList);
			return "left";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// 前台获取中队列表
	public String loadUnitList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession session = ReqRes.getSession();
			totalRecord = unitService.countUnit();
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "unitAction!loadUnitList.action";

			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}

			initPage();
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}

			queryList = unitService.loadUnitList(start + limit
					* (currentPage - 1), limit);
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	// 新建中队
	public void createUnit() {
		try {
			unitService.createUnit(unitName, unitBelonged,
					unitLeader, leaderTele);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String checkUnit() {
		try {
			Unit unit = new Unit();
			unit = unitService.getUnit(unitId);
			if (unit != null) {
				ReqRes.getSession().setAttribute("m", unit);
				return "check";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 搜索中队信息送入编辑页面
	public String editUnit() {
		try {
			Unit unit = new Unit();
			unit = unitService.getUnit(unitId);
			if (unit != null) {
				ReqRes.getSession().setAttribute("m", unit);
				return "edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 保存中队编辑后的内容
	public void saveEdit() {
		try {
			unitService.saveEdit(unitId, unitName, unitBelonged,
					unitLeader, leaderTele);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除中队信息
	public String deleteUnit() {
		try {
			unitService.deleteUnit(unitId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			loadUnitList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
