package com.wlwz.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Maintenancerecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "maintenancerecord", catalog = "wlwz")
public class Maintenancerecord implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public Maintenancerecord() {
	}

	/** minimal constructor */
	public Maintenancerecord(String maintenanceRecordId, Device device) {
		this.maintenanceRecordId = maintenanceRecordId;
		this.device = device;
	}

	/** full constructor */
	public Maintenancerecord(String maintenanceRecordId, Device device,
			Timestamp createTime, Integer maintenanceKind,
			Timestamp inFactoryDate, Timestamp workStartDate,
			Timestamp workEndDate, String maintenancePlace,
			Integer maintenanceDays, Timestamp thisRoundTime,
			String maintenanceContent, String changeRecord,
			String outFactoryState, String attentionMatters, Boolean isActive) {
		this.maintenanceRecordId = maintenanceRecordId;
		this.device = device;
		this.createTime = createTime;
		this.maintenanceKind = maintenanceKind;
		this.inFactoryDate = inFactoryDate;
		this.workStartDate = workStartDate;
		this.workEndDate = workEndDate;
		this.maintenancePlace = maintenancePlace;
		this.maintenanceDays = maintenanceDays;
		this.thisRoundTime = thisRoundTime;
		this.maintenanceContent = maintenanceContent;
		this.changeRecord = changeRecord;
		this.outFactoryState = outFactoryState;
		this.attentionMatters = attentionMatters;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "maintenanceRecordId", unique = true, nullable = false, length = 50)
	public String getMaintenanceRecordId() {
		return this.maintenanceRecordId;
	}

	public void setMaintenanceRecordId(String maintenanceRecordId) {
		this.maintenanceRecordId = maintenanceRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deviceId", nullable = false)
	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "maintenanceKind")
	public Integer getMaintenanceKind() {
		return this.maintenanceKind;
	}

	public void setMaintenanceKind(Integer maintenanceKind) {
		this.maintenanceKind = maintenanceKind;
	}

	@Column(name = "inFactoryDate", length = 19)
	public Timestamp getInFactoryDate() {
		return this.inFactoryDate;
	}

	public void setInFactoryDate(Timestamp inFactoryDate) {
		this.inFactoryDate = inFactoryDate;
	}

	@Column(name = "workStartDate", length = 19)
	public Timestamp getWorkStartDate() {
		return this.workStartDate;
	}

	public void setWorkStartDate(Timestamp workStartDate) {
		this.workStartDate = workStartDate;
	}

	@Column(name = "workEndDate", length = 19)
	public Timestamp getWorkEndDate() {
		return this.workEndDate;
	}

	public void setWorkEndDate(Timestamp workEndDate) {
		this.workEndDate = workEndDate;
	}

	@Column(name = "maintenancePlace", length = 200)
	public String getMaintenancePlace() {
		return this.maintenancePlace;
	}

	public void setMaintenancePlace(String maintenancePlace) {
		this.maintenancePlace = maintenancePlace;
	}

	@Column(name = "maintenanceDays")
	public Integer getMaintenanceDays() {
		return this.maintenanceDays;
	}

	public void setMaintenanceDays(Integer maintenanceDays) {
		this.maintenanceDays = maintenanceDays;
	}

	@Column(name = "thisRoundTime", length = 19)
	public Timestamp getThisRoundTime() {
		return this.thisRoundTime;
	}

	public void setThisRoundTime(Timestamp thisRoundTime) {
		this.thisRoundTime = thisRoundTime;
	}

	@Column(name = "maintenanceContent", length = 500)
	public String getMaintenanceContent() {
		return this.maintenanceContent;
	}

	public void setMaintenanceContent(String maintenanceContent) {
		this.maintenanceContent = maintenanceContent;
	}

	@Column(name = "changeRecord", length = 100)
	public String getChangeRecord() {
		return this.changeRecord;
	}

	public void setChangeRecord(String changeRecord) {
		this.changeRecord = changeRecord;
	}

	@Column(name = "outFactoryState", length = 100)
	public String getOutFactoryState() {
		return this.outFactoryState;
	}

	public void setOutFactoryState(String outFactoryState) {
		this.outFactoryState = outFactoryState;
	}

	@Column(name = "attentionMatters", length = 300)
	public String getAttentionMatters() {
		return this.attentionMatters;
	}

	public void setAttentionMatters(String attentionMatters) {
		this.attentionMatters = attentionMatters;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}