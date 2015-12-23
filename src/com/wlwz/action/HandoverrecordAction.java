package com.wlwz.action;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Device;
import com.wlwz.entity.Handoverrecord;
import com.wlwz.service.IHandoverrecordService;
import com.wlwz.util.ReqRes;

@Component("handoverrecordAction")
@Scope("prototype")
public class HandoverrecordAction extends BaseAction {
	private String handoverRecordId;
	private Device device;
	private Timestamp createTime;
	private String transferUnit;
	private String transferPerson;
	private String acceptUint;
	private String acceptPerson;
	private Boolean isActive;
	private String deviceNumber;

	public String getHandoverRecordId() {
		return handoverRecordId;
	}

	public void setHandoverRecordId(String handoverRecordId) {
		this.handoverRecordId = handoverRecordId;
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

	public String getTransferUnit() {
		return transferUnit;
	}

	public void setTransferUnit(String transferUnit) {
		this.transferUnit = transferUnit;
	}

	public String getTransferPerson() {
		return transferPerson;
	}

	public void setTransferPerson(String transferPerson) {
		this.transferPerson = transferPerson;
	}

	public String getAcceptUint() {
		return acceptUint;
	}

	public void setAcceptUint(String acceptUint) {
		this.acceptUint = acceptUint;
	}

	public String getAcceptPerson() {
		return acceptPerson;
	}

	public void setAcceptPerson(String acceptPerson) {
		this.acceptPerson = acceptPerson;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	private IHandoverrecordService handoverrecordService;

	@Resource(name = "handoverrecordService")
	public void setHandoverrecordService(
			IHandoverrecordService handoverrecordService) {
		this.handoverrecordService = handoverrecordService;
	}

	public String getHandoverrecordList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = handoverrecordService
					.countHandoverrecord(deviceNumber);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "handoverrecordAction!getHandoverrecordList.action";
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
			queryList = handoverrecordService.loadHandoverrecordList(start
					+ limit * (currentPage - 1), limit, deviceNumber);
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createHandoverrecord() {
		try {
			handoverrecordService.createHandoverrecord(deviceNumber,
					createTime, transferUnit, transferPerson, acceptUint,
					acceptPerson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
			Handoverrecord h = handoverrecordService
					.loadOneHandoverrecord(handoverRecordId);
			session.setAttribute("h", h);
			return "check";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String edit() {
		try {
			HttpSession session = ReqRes.getSession();
			Handoverrecord h = handoverrecordService
					.loadOneHandoverrecord(handoverRecordId);
			session.setAttribute("h", h);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveEdit() {
		try {
			handoverrecordService.saveEdit(handoverRecordId, createTime,
					transferUnit, transferPerson, acceptUint, acceptPerson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String delete() {
		try {
			handoverrecordService.deleteRecord(handoverRecordId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getHandoverrecordList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
