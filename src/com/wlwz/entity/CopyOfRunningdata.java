package com.wlwz.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Runningdata3 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "runningdata3", catalog = "wlwz")
public class CopyOfRunningdata implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private Device device;
	private Timestamp createTime;
	private Integer field1;
	private String field2;

	// Constructors

	/** default constructor */
	public CopyOfRunningdata() {
	}

	/** full constructor */
	public CopyOfRunningdata(Device device, Timestamp createTime, Integer field1,
			String field2) {
		this.device = device;
		this.createTime = createTime;
		this.field1 = field1;
		this.field2 = field2;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "recordId", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deviceId")
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

	@Column(name = "field_1")
	public Integer getField1() {
		return this.field1;
	}

	public void setField1(Integer field1) {
		this.field1 = field1;
	}

	@Column(name = "field_2", length = 20)
	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

}