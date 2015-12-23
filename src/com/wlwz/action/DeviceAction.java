package com.wlwz.action;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Unit;
import com.wlwz.entity.Project;
import com.wlwz.service.IDeviceService;
import com.wlwz.util.ReqRes;

@Component("deviceAction")
@Scope("prototype")
public class DeviceAction extends BaseAction {

	private String imeiSeriers;
	private String deviceKind;
	private String typeName;
	private Timestamp operationDate;
	private String model;
	private Timestamp manufactDate;
	private String position;
	private String factoryArea;
	private String abclogo;
	private String company;
	private String costCenter;
	private String plannersGroup;
	private String maintainFuncCenter;
	private String reportFuncPlace;
	private String technicNum;
	private String assetsProperty;
	private Float assetsOriginalValue;
	private Float assetsAdded;
	private Timestamp assetsAddDate;

	private Float fuelConsumption;
	private Timestamp totalRunningTime;
	private Integer totalGoodDays;
	private Float totalDistance;
	private Integer toatlUesdDays;
	private Integer serialNumber;
	private String inventory;
	private Boolean deviceState;
	private String rightLevel;
	private Boolean isActive;
	private Float weight;
	private String deviceSize;

	private Integer deviceId;
	private String deviceNumber;
	private String unitCode;
	private String assetNumber;
	private String unitName;
	private String deviceName;
	private Integer deviceBigKind;
	private String projectName;
	private String midteamName;
	private Integer midteamId;
	private Integer projectId;

	public Integer getMidteamId() {
		return midteamId;
	}

	public void setMidteamId(Integer midteamId) {
		this.midteamId = midteamId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getMidteamName() {
		return midteamName;
	}

	public void setMidteamName(String midteamName) {
		this.midteamName = midteamName;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getDeviceBigKind() {
		return deviceBigKind;
	}

	public void setDeviceBigKind(Integer deviceBigKind) {
		this.deviceBigKind = deviceBigKind;
	}

	private IDeviceService deviceService;

	@Resource(name = "deviceService")
	public void setDeviceService(IDeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public void createDevice() {
		try {
			deviceService.createDevice(midteamId, projectId, imeiSeriers,
					deviceKind, deviceNumber, unitCode, assetNumber, unitName,
					deviceName, deviceBigKind, typeName, operationDate, model,
					manufactDate, position, factoryArea, abclogo, company,
					costCenter, plannersGroup, maintainFuncCenter,
					reportFuncPlace, technicNum, fuelConsumption,
					assetsProperty, assetsOriginalValue, assetsAdded,
					assetsAddDate, totalRunningTime, totalGoodDays,
					totalDistance, toatlUesdDays, serialNumber, inventory,
					deviceState, rightLevel, isActive, weight, deviceSize);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String getDeviceList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = deviceService.countDevice(projectName, midteamName);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "deviceAction!getDeviceList.action";
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
			queryList = deviceService.loadDeviceList(start + limit
					* (currentPage - 1), limit, projectName, midteamName);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public String getProjectAndMidteam() {
		try {
			HttpSession session = ReqRes.getSession();
			List<Project> p = deviceService.getAllProjects();
			List<Unit> m = deviceService.getAllUnits();
			session.setAttribute("p", p);
			session.setAttribute("m", m);
			return "add";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
