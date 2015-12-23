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
 * Handoverrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "handoverrecord", catalog = "wlwz")
public class Handoverrecord implements java.io.Serializable {

	// Fields

	private String handoverRecordId;
	private Device device;
	private Timestamp createTime;
	private String transferUnit;
	private String transferPerson;
	private String acceptUint;
	private String acceptPerson;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Handoverrecord() {
	}

	/** minimal constructor */
	public Handoverrecord(String handoverRecordId, Device device) {
		this.handoverRecordId = handoverRecordId;
		this.device = device;
	}

	/** full constructor */
	public Handoverrecord(String handoverRecordId, Device device,
			Timestamp createTime, String transferUnit, String transferPerson,
			String acceptUint, String acceptPerson, Boolean isActive) {
		this.handoverRecordId = handoverRecordId;
		this.device = device;
		this.createTime = createTime;
		this.transferUnit = transferUnit;
		this.transferPerson = transferPerson;
		this.acceptUint = acceptUint;
		this.acceptPerson = acceptPerson;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "handoverRecordId", unique = true, nullable = false, length = 50)
	public String getHandoverRecordId() {
		return this.handoverRecordId;
	}

	public void setHandoverRecordId(String handoverRecordId) {
		this.handoverRecordId = handoverRecordId;
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

	@Column(name = "transferUnit", length = 50)
	public String getTransferUnit() {
		return this.transferUnit;
	}

	public void setTransferUnit(String transferUnit) {
		this.transferUnit = transferUnit;
	}

	@Column(name = "transferPerson", length = 50)
	public String getTransferPerson() {
		return this.transferPerson;
	}

	public void setTransferPerson(String transferPerson) {
		this.transferPerson = transferPerson;
	}

	@Column(name = "acceptUint", length = 50)
	public String getAcceptUint() {
		return this.acceptUint;
	}

	public void setAcceptUint(String acceptUint) {
		this.acceptUint = acceptUint;
	}

	@Column(name = "acceptPerson", length = 50)
	public String getAcceptPerson() {
		return this.acceptPerson;
	}

	public void setAcceptPerson(String acceptPerson) {
		this.acceptPerson = acceptPerson;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}