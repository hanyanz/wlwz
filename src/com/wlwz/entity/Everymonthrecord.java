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
 * Everymonthrecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "everymonthrecord", catalog = "wlwz")
public class Everymonthrecord implements java.io.Serializable {

	// Fields

	private String everymonthRecordId;
	private Device device;
	private Timestamp createTime;
	private Timestamp thisMonthTime;
	private Integer thisMonthDays;
	private Float fuelOil;
	private Float lubeOil;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Everymonthrecord() {
	}

	/** minimal constructor */
	public Everymonthrecord(String everymonthRecordId, Device device) {
		this.everymonthRecordId = everymonthRecordId;
		this.device = device;
	}

	/** full constructor */
	public Everymonthrecord(String everymonthRecordId, Device device,
			Timestamp createTime, Timestamp thisMonthTime,
			Integer thisMonthDays, Float fuelOil, Float lubeOil,
			Boolean isActive) {
		this.everymonthRecordId = everymonthRecordId;
		this.device = device;
		this.createTime = createTime;
		this.thisMonthTime = thisMonthTime;
		this.thisMonthDays = thisMonthDays;
		this.fuelOil = fuelOil;
		this.lubeOil = lubeOil;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "everymonthRecordId", unique = true, nullable = false, length = 50)
	public String getEverymonthRecordId() {
		return this.everymonthRecordId;
	}

	public void setEverymonthRecordId(String everymonthRecordId) {
		this.everymonthRecordId = everymonthRecordId;
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

	@Column(name = "thisMonthTime", length = 19)
	public Timestamp getThisMonthTime() {
		return this.thisMonthTime;
	}

	public void setThisMonthTime(Timestamp thisMonthTime) {
		this.thisMonthTime = thisMonthTime;
	}

	@Column(name = "thisMonthDays")
	public Integer getThisMonthDays() {
		return this.thisMonthDays;
	}

	public void setThisMonthDays(Integer thisMonthDays) {
		this.thisMonthDays = thisMonthDays;
	}

	@Column(name = "fuelOil", precision = 12, scale = 0)
	public Float getFuelOil() {
		return this.fuelOil;
	}

	public void setFuelOil(Float fuelOil) {
		this.fuelOil = fuelOil;
	}

	@Column(name = "lubeOil", precision = 12, scale = 0)
	public Float getLubeOil() {
		return this.lubeOil;
	}

	public void setLubeOil(Float lubeOil) {
		this.lubeOil = lubeOil;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}