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
 * Accidentrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "accidentrecord", catalog = "wlwz")
public class Accidentrecord implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public Accidentrecord() {
	}

	/** minimal constructor */
	public Accidentrecord(String accidentRecordId, Device device) {
		this.accidentRecordId = accidentRecordId;
		this.device = device;
	}

	/** full constructor */
	public Accidentrecord(String accidentRecordId, Device device,
			Timestamp createTime, Short accidentType, String accidentUint,
			String responsiblePerson, String accidentReason,
			String damageAssessment, Float damageValue, String disposeRecord,
			Boolean isActive) {
		this.accidentRecordId = accidentRecordId;
		this.device = device;
		this.createTime = createTime;
		this.accidentType = accidentType;
		this.accidentUint = accidentUint;
		this.responsiblePerson = responsiblePerson;
		this.accidentReason = accidentReason;
		this.damageAssessment = damageAssessment;
		this.damageValue = damageValue;
		this.disposeRecord = disposeRecord;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "accidentRecordId", unique = true, nullable = false, length = 50)
	public String getAccidentRecordId() {
		return this.accidentRecordId;
	}

	public void setAccidentRecordId(String accidentRecordId) {
		this.accidentRecordId = accidentRecordId;
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

	@Column(name = "accidentType")
	public Short getAccidentType() {
		return this.accidentType;
	}

	public void setAccidentType(Short accidentType) {
		this.accidentType = accidentType;
	}

	@Column(name = "accidentUint", length = 50)
	public String getAccidentUint() {
		return this.accidentUint;
	}

	public void setAccidentUint(String accidentUint) {
		this.accidentUint = accidentUint;
	}

	@Column(name = "responsiblePerson", length = 50)
	public String getResponsiblePerson() {
		return this.responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	@Column(name = "accidentReason", length = 1000)
	public String getAccidentReason() {
		return this.accidentReason;
	}

	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	@Column(name = "damageAssessment", precision = 12, scale = 0)
	public String getDamageAssessment() {
		return this.damageAssessment;
	}

	public void setDamageAssessment(String damageAssessment) {
		this.damageAssessment = damageAssessment;
	}

	@Column(name = "damageValue", precision = 12, scale = 0)
	public Float getDamageValue() {
		return this.damageValue;
	}

	public void setDamageValue(Float damageValue) {
		this.damageValue = damageValue;
	}

	@Column(name = "disposeRecord", length = 200)
	public String getDisposeRecord() {
		return this.disposeRecord;
	}

	public void setDisposeRecord(String disposeRecord) {
		this.disposeRecord = disposeRecord;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}