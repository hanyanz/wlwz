package com.wlwz.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Unit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "unit", catalog = "wlwz")
public class Unit implements java.io.Serializable {

	// Fields

	private Integer unitId;
	private String unitName;
	private String unitBelonged;
	private String unitLeader;
	private String leaderTele;
	private Boolean isActive;
	private Set<Device> devices = new HashSet<Device>(0);

	// Constructors

	/** default constructor */
	public Unit() {
	}

	/** minimal constructor */
	public Unit(String unitName) {
		this.unitName = unitName;
	}

	/** full constructor */
	public Unit(String unitName, String unitBelonged, String unitLeader,
			String leaderTele, Boolean isActive, Set<Device> devices) {
		this.unitName = unitName;
		this.unitBelonged = unitBelonged;
		this.unitLeader = unitLeader;
		this.leaderTele = leaderTele;
		this.isActive = isActive;
		this.devices = devices;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "unitId", unique = true, nullable = false)
	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	@Column(name = "unitName", nullable = false, length = 50)
	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Column(name = "unitBelonged", length = 50)
	public String getUnitBelonged() {
		return this.unitBelonged;
	}

	public void setUnitBelonged(String unitBelonged) {
		this.unitBelonged = unitBelonged;
	}

	@Column(name = "unitLeader", length = 50)
	public String getUnitLeader() {
		return this.unitLeader;
	}

	public void setUnitLeader(String unitLeader) {
		this.unitLeader = unitLeader;
	}

	@Column(name = "leaderTele", length = 50)
	public String getLeaderTele() {
		return this.leaderTele;
	}

	public void setLeaderTele(String leaderTele) {
		this.leaderTele = leaderTele;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "unit")
	public Set<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

}