package com.wlwz.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Systemright entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "systemright", catalog = "wlwz")
public class Systemright implements java.io.Serializable {

	// Fields

	private String systemRightId;
	private String rightName;
	private String remark;
	private Timestamp creatTime;
	private Boolean isActive;
	private Set<Roleright> rolerights = new HashSet<Roleright>(0);

	// Constructors

	/** default constructor */
	public Systemright() {
	}

	/** minimal constructor */
	public Systemright(String systemRightId) {
		this.systemRightId = systemRightId;
	}

	/** full constructor */
	public Systemright(String systemRightId, String rightName, String remark,
			Timestamp creatTime, Boolean isActive, Set<Roleright> rolerights) {
		this.systemRightId = systemRightId;
		this.rightName = rightName;
		this.remark = remark;
		this.creatTime = creatTime;
		this.isActive = isActive;
		this.rolerights = rolerights;
	}

	// Property accessors
	@Id
	@Column(name = "systemRightId", unique = true, nullable = false, length = 50)
	public String getSystemRightId() {
		return this.systemRightId;
	}

	public void setSystemRightId(String systemRightId) {
		this.systemRightId = systemRightId;
	}

	@Column(name = "rightName", length = 100)
	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "creatTime", length = 19)
	public Timestamp getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "systemright")
	public Set<Roleright> getRolerights() {
		return this.rolerights;
	}

	public void setRolerights(Set<Roleright> rolerights) {
		this.rolerights = rolerights;
	}

}