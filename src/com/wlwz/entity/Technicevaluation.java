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
 * Technicevaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "technicevaluation", catalog = "wlwz")
public class Technicevaluation implements java.io.Serializable {

	// Fields

	private String evaluateId;
	private Device device;
	private Timestamp createTime;
	private Timestamp thisRoundTime;
	private String presentTechnicStatus;
	private String evaluateAdvice;
	private String identifier;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Technicevaluation() {
	}

	/** minimal constructor */
	public Technicevaluation(String evaluateId, Device device) {
		this.evaluateId = evaluateId;
		this.device = device;
	}

	/** full constructor */
	public Technicevaluation(String evaluateId, Device device,
			Timestamp createTime, Timestamp thisRoundTime,
			String presentTechnicStatus, String evaluateAdvice,
			String identifier, Boolean isActive) {
		this.evaluateId = evaluateId;
		this.device = device;
		this.createTime = createTime;
		this.thisRoundTime = thisRoundTime;
		this.presentTechnicStatus = presentTechnicStatus;
		this.evaluateAdvice = evaluateAdvice;
		this.identifier = identifier;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "evaluateId", unique = true, nullable = false, length = 50)
	public String getEvaluateId() {
		return this.evaluateId;
	}

	public void setEvaluateId(String evaluateId) {
		this.evaluateId = evaluateId;
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

	@Column(name = "thisRoundTime", length = 19)
	public Timestamp getThisRoundTime() {
		return this.thisRoundTime;
	}

	public void setThisRoundTime(Timestamp thisRoundTime) {
		this.thisRoundTime = thisRoundTime;
	}

	@Column(name = "presentTechnicStatus", length = 300)
	public String getPresentTechnicStatus() {
		return this.presentTechnicStatus;
	}

	public void setPresentTechnicStatus(String presentTechnicStatus) {
		this.presentTechnicStatus = presentTechnicStatus;
	}

	@Column(name = "evaluateAdvice", length = 300)
	public String getEvaluateAdvice() {
		return this.evaluateAdvice;
	}

	public void setEvaluateAdvice(String evaluateAdvice) {
		this.evaluateAdvice = evaluateAdvice;
	}

	@Column(name = "identifier", length = 20)
	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}