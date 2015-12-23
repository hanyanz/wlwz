package com.wlwz.action;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Device;
import com.wlwz.entity.Maintenancerecord;
import com.wlwz.service.IMaintenancerecordService;
import com.wlwz.util.ReqRes;

@Component("maintenancerecordAction")
@Scope("prototype")
public class MaintenancerecordAction extends BaseAction {
	private String maintenanceRecordId;
	private Device device;
	private Timestamp createTime;
	private Integer maintenanceKind;
	private Timestamp inFactoryDate;
	private Timestamp workStartDate;
	private Timestamp workEndDate;
	private String maintenancePlace;
	private Integer maintenanceDays;
	private Timestamp thisRoundTime;
	private String maintenanceContent;
	private String changeRecord;
	private String outFactoryState;
	private String attentionMatters;
	private Boolean isActive;
	private String deviceNumber;

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getMaintenanceRecordId() {
		return maintenanceRecordId;
	}

	public void setMaintenanceRecordId(String maintenanceRecordId) {
		this.maintenanceRecordId = maintenanceRecordId;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getMaintenanceKind() {
		return maintenanceKind;
	}

	public void setMaintenanceKind(Integer maintenanceKind) {
		this.maintenanceKind = maintenanceKind;
	}

	public Timestamp getInFactoryDate() {
		return inFactoryDate;
	}

	public void setInFactoryDate(Timestamp inFactoryDate) {
		this.inFactoryDate = inFactoryDate;
	}

	public Timestamp getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(Timestamp workStartDate) {
		this.workStartDate = workStartDate;
	}

	public Timestamp getWorkEndDate() {
		return workEndDate;
	}

	public void setWorkEndDate(Timestamp workEndDate) {
		this.workEndDate = workEndDate;
	}

	public String getMaintenancePlace() {
		return maintenancePlace;
	}

	public void setMaintenancePlace(String maintenancePlace) {
		this.maintenancePlace = maintenancePlace;
	}

	public Integer getMaintenanceDays() {
		return maintenanceDays;
	}

	public void setMaintenanceDays(Integer maintenanceDays) {
		this.maintenanceDays = maintenanceDays;
	}

	public Timestamp getThisRoundTime() {
		return thisRoundTime;
	}

	public void setThisRoundTime(Timestamp thisRoundTime) {
		this.thisRoundTime = thisRoundTime;
	}

	public String getMaintenanceContent() {
		return maintenanceContent;
	}

	public void setMaintenanceContent(String maintenanceContent) {
		this.maintenanceContent = maintenanceContent;
	}

	public String getChangeRecord() {
		return changeRecord;
	}

	public void setChangeRecord(String changeRecord) {
		this.changeRecord = changeRecord;
	}

	public String getOutFactoryState() {
		return outFactoryState;
	}

	public void setOutFactoryState(String outFactoryState) {
		this.outFactoryState = outFactoryState;
	}

	public String getAttentionMatters() {
		return attentionMatters;
	}

	public void setAttentionMatters(String attentionMatters) {
		this.attentionMatters = attentionMatters;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private IMaintenancerecordService maintenancerecordService;

	@Resource(name = "maintenancerecordService")
	public void setMaintenancerecordService(
			IMaintenancerecordService maintenancerecordService) {
		this.maintenancerecordService = maintenancerecordService;
	}

	public String getMaintenanceList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = maintenancerecordService
					.countMaintenancerecord(deviceNumber);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);

			url = "maintenancerecordAction!getMaintenanceList.action";

			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}

			initPage();

			ses.setAttribute("totalPage", totalPage);
			ses.setAttribute("currentPage", currentPage);
			ses.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}
			queryList = maintenancerecordService.loadMaintenancerecordList(
					start + limit * (currentPage - 1), limit, deviceNumber);
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createMaintenancerecord() {
		try {
			maintenancerecordService.createMaintenancerecord(createTime,
					maintenanceKind, inFactoryDate, workStartDate, workEndDate,
					maintenancePlace, maintenanceDays, thisRoundTime,
					maintenanceContent, changeRecord, outFactoryState,
					attentionMatters, deviceNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
			Maintenancerecord m = maintenancerecordService
					.loadOneMaintenancerecord(maintenanceRecordId);
			session.setAttribute("m", m);
			return "check";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String edit() {
		try {
			HttpSession session = ReqRes.getSession();
			Maintenancerecord m = maintenancerecordService
					.loadOneMaintenancerecord(maintenanceRecordId);
			session.setAttribute("m", m);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveEdit() {
		try {
			maintenancerecordService.saveEdit(maintenanceRecordId, createTime,
					maintenanceKind, inFactoryDate, workStartDate, workEndDate,
					maintenancePlace, maintenanceDays, thisRoundTime,
					maintenanceContent, changeRecord, outFactoryState,
					attentionMatters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 逻辑删除
	public String delRecord() {
		try {
			maintenancerecordService.deleteRecord(maintenanceRecordId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getMaintenanceList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
