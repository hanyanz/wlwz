package com.wlwz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Roleright entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roleright", catalog = "wlwz")
public class Roleright implements java.io.Serializable {

	// Fields

	private String roleRightId;
	private Systemrole systemrole;
	private Systemright systemright;
	private Integer rightType;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Roleright() {
	}

	/** minimal constructor */
	public Roleright(String roleRightId) {
		this.roleRightId = roleRightId;
	}

	/** full constructor */
	public Roleright(String roleRightId, Systemrole systemrole,
			Systemright systemright, Integer rightType, Boolean isActive) {
		this.roleRightId = roleRightId;
		this.systemrole = systemrole;
		this.systemright = systemright;
		this.rightType = rightType;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@Column(name = "roleRightId", unique = true, nullable = false, length = 50)
	public String getRoleRightId() {
		return this.roleRightId;
	}

	public void setRoleRightId(String roleRightId) {
		this.roleRightId = roleRightId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemRoleId")
	public Systemrole getSystemrole() {
		return this.systemrole;
	}

	public void setSystemrole(Systemrole systemrole) {
		this.systemrole = systemrole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemRightId")
	public Systemright getSystemright() {
		return this.systemright;
	}

	public void setSystemright(Systemright systemright) {
		this.systemright = systemright;
	}

	@Column(name = "rightType")
	public Integer getRightType() {
		return this.rightType;
	}

	public void setRightType(Integer rightType) {
		this.rightType = rightType;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}