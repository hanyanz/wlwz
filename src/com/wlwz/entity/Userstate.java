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
 * Userstate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userstate", catalog = "wlwz")
public class Userstate implements java.io.Serializable {

	// Fields

	private Integer userGroup;
	private String userSign;
	private Integer state;
	private Boolean isActive;
	private Set<Device> devices = new HashSet<Device>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Userstate() {
	}

	/** minimal constructor */
	public Userstate(String userSign, Integer state) {
		this.userSign = userSign;
		this.state = state;
	}

	/** full constructor */
	public Userstate(String userSign, Integer state, Boolean isActive,
			Set<Device> devices, Set<User> users) {
		this.userSign = userSign;
		this.state = state;
		this.isActive = isActive;
		this.devices = devices;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userGroup", unique = true, nullable = false)
	public Integer getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

	@Column(name = "userSign", nullable = false, length = 20)
	public String getUserSign() {
		return this.userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	@Column(name = "state", nullable = false)
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userstate")
	public Set<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userstate")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}