package com.wlwz.action;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Accidentrecord;
import com.wlwz.entity.Device;
import com.wlwz.service.IAccidentrecordService;
import com.wlwz.util.ReqRes;

@Component("accidentrecordAction")
@Scope("prototype")
public class AccidentrecordAction extends BaseAction {

	private String accidentRecordId;
	private Device device;
	private Timestamp createTime;
	private Short accidentType;
	private String accidentUint;
	private String responsiblePerson;
	private String accidentReason;
	private String damageAssessment;
	private Float damageValue;
	private String disposeRecord;
	private Boolean isActive;
	private String deviceNumber;

	public String getAccidentRecordId() {
		return accidentRecordId;
	}

	public void setAccidentRecordId(String accidentRecordId) {
		this.accidentRecordId = accidentRecordId;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
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

	public Short getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(Short accidentType) {
		this.accidentType = accidentType;
	}

	public String getAccidentUint() {
		return accidentUint;
	}

	public void setAccidentUint(String accidentUint) {
		this.accidentUint = accidentUint;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public String getAccidentReason() {
		return accidentReason;
	}

	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	public String getDamageAssessment() {
		return damageAssessment;
	}

	public void setDamageAssessment(String damageAssessment) {
		this.damageAssessment = damageAssessment;
	}

	public Float getDamageValue() {
		return damageValue;
	}

	public void setDamageValue(Float damageValue) {
		this.damageValue = damageValue;
	}

	public String getDisposeRecord() {
		return disposeRecord;
	}

	public void setDisposeRecord(String disposeRecord) {
		this.disposeRecord = disposeRecord;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private Integer queryDeviceId;

	public void setQueryDeviceId(Integer queryDeviceId) {
		this.queryDeviceId = queryDeviceId;
	}

	private IAccidentrecordService accidentrecordService;

	@Resource(name = "accidentrecordService")
	public void setAccidentrecordService(
			IAccidentrecordService accidentrecordService) {
		this.accidentrecordService = accidentrecordService;
	}

	public String getAccidentList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = accidentrecordService
					.countAccidentrecord(deviceNumber);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);

			url = "accidentrecordAction!getAccidentList.action";

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
			queryList = accidentrecordService.loadAccidentrecordList(start
					+ limit * (currentPage - 1), limit, deviceNumber);
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createAccidentRecord() {
		try {
			accidentrecordService.creatAccidentRecord(createTime, accidentType,
					accidentUint, responsiblePerson, accidentReason,
					damageAssessment, damageValue, disposeRecord, deviceNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
			Accidentrecord a = accidentrecordService
					.loadOneAccidentrecord(accidentRecordId);
			session.setAttribute("a", a);
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
			Accidentrecord a = accidentrecordService
					.loadOneAccidentrecord(accidentRecordId);
			session.setAttribute("a", a);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveEdit() {
		try {
			accidentrecordService.saveEdit(accidentRecordId, createTime,
					accidentType, accidentUint, responsiblePerson,
					accidentReason, damageAssessment, damageValue,
					disposeRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 逻辑删除
	public String delRecord() {
		try {
			accidentrecordService.deleteRecord(accidentRecordId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getAccidentList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
