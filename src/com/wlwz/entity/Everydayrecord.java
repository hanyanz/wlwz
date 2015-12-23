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
 * Everydayrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "everydayrecord", catalog = "wlwz")
public class Everydayrecord implements java.io.Serializable {

	// Fields

	private String everydayRecordId;
	private Device device;
	private Timestamp createTime;
	private Timestamp turnOnTime;
	private Timestamp turnOffTime;
	private Timestamp workTime;
	private String workContent;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Everydayrecord() {
	}

	/** minimal constructor */
	public Everydayrecord(String everydayRecordId, Device device) {
		this.everydayRecordId = everydayRecordId;
		this.device = device;
	}

	/** full constructor */
	public Everydayrecord(String everydayRecordId, Device device,
			Timestamp createTime, Timestamp turnOnTime, Timestamp turnOffTime,
			Timestamp workTime, String workContent, Boolean isActive) {
		this.everydayRecordId = everydayRecordId;
		this.device = device;
		this.createTime = createTime;
		this.turnOnTime = turnOnTime;
		this.turnOffTime = turnOffTime;
		this.workTime = workTime;
		this.workContent = workContent;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "everydayRecordId", unique = true, nullable = false, length = 50)
	public String getEverydayRecordId() {
		return this.everydayRecordId;
	}

	public void setEverydayRecordId(String everydayRecordId) {
		this.everydayRecordId = everydayRecordId;
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

	@Column(name = "turnOnTime", length = 19)
	public Timestamp getTurnOnTime() {
		return this.turnOnTime;
	}

	public void setTurnOnTime(Timestamp turnOnTime) {
		this.turnOnTime = turnOnTime;
	}

	@Column(name = "turnOffTime", length = 19)
	public Timestamp getTurnOffTime() {
		return this.turnOffTime;
	}

	public void setTurnOffTime(Timestamp turnOffTime) {
		this.turnOffTime = turnOffTime;
	}

	@Column(name = "workTime", length = 19)
	public Timestamp getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(Timestamp workTime) {
		this.workTime = workTime;
	}

	@Column(name = "workContent", length = 300)
	public String getWorkContent() {
		return this.workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}