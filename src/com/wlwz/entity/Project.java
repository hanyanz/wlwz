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
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project", catalog = "wlwz")
public class Project implements java.io.Serializable {

	// Fields

	private Integer projectId;
	private String projectName;
	private String projectAddress;
	private String projectLeader;
	private String telephone;
	private Double xcoord;
	private Double ycoord;
	private Boolean isActive;
	private Set<Device> devices = new HashSet<Device>(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(String projectName) {
		this.projectName = projectName;
	}

	/** full constructor */
	public Project(String projectName, String projectAddress,
			String projectLeader, String telephone, Double xcoord,
			Double ycoord, Boolean isActive, Set<Device> devices) {
		this.projectName = projectName;
		this.projectAddress = projectAddress;
		this.projectLeader = projectLeader;
		this.telephone = telephone;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.isActive = isActive;
		this.devices = devices;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "projectId", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "projectName", nullable = false, length = 50)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "projectAddress", length = 50)
	public String getProjectAddress() {
		return this.projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	@Column(name = "projectLeader", length = 50)
	public String getProjectLeader() {
		return this.projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	@Column(name = "telephone", length = 50)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "Xcoord", precision = 22, scale = 0)
	public Double getXcoord() {
		return this.xcoord;
	}

	public void setXcoord(Double xcoord) {
		this.xcoord = xcoord;
	}

	@Column(name = "Ycoord", precision = 22, scale = 0)
	public Double getYcoord() {
		return this.ycoord;
	}

	public void setYcoord(Double ycoord) {
		this.ycoord = ycoord;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

}