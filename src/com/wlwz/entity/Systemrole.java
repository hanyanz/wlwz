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
 * Systemrole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "systemrole", catalog = "wlwz")
public class Systemrole implements java.io.Serializable {

	// Fields

	private Integer systemRoleId;
	private String roleName;
	private String remark;
	private Boolean isActive;
	private Set<Roleright> rolerights = new HashSet<Roleright>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Systemrole() {
	}

	/** full constructor */
	public Systemrole(String roleName, String remark, Boolean isActive,
			Set<Roleright> rolerights, Set<User> users) {
		this.roleName = roleName;
		this.remark = remark;
		this.isActive = isActive;
		this.rolerights = rolerights;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "systemRoleId", unique = true, nullable = false)
	public Integer getSystemRoleId() {
		return this.systemRoleId;
	}

	public void setSystemRoleId(Integer systemRoleId) {
		this.systemRoleId = systemRoleId;
	}

	@Column(name = "roleName", length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "systemrole")
	public Set<Roleright> getRolerights() {
		return this.rolerights;
	}

	public void setRolerights(Set<Roleright> rolerights) {
		this.rolerights = rolerights;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "systemrole")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}