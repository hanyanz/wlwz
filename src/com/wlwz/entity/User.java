package com.wlwz.entity;

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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "wlwz")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Systemrole systemrole;
	private Userstate userstate;
	private String userName;
	private String password;
	private String realName;
	private String unit;
	private String email;
	private String mobilephone;
	private String telephone;
	private String area;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Systemrole systemrole, Userstate userstate) {
		this.systemrole = systemrole;
		this.userstate = userstate;
	}

	/** full constructor */
	public User(Systemrole systemrole, Userstate userstate, String userName,
			String password, String realName, String unit, String email,
			String mobilephone, String telephone, String area, Boolean isActive) {
		this.systemrole = systemrole;
		this.userstate = userstate;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.unit = unit;
		this.email = email;
		this.mobilephone = mobilephone;
		this.telephone = telephone;
		this.area = area;
		this.isActive = isActive;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "systemRoleId", nullable = false)
	public Systemrole getSystemrole() {
		return this.systemrole;
	}

	public void setSystemrole(Systemrole systemrole) {
		this.systemrole = systemrole;
	}



	//@ManyToOne(fetch = FetchType.LAZY)  3月11日加zxy
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userGroup", nullable = false)
	public Userstate getUserstate() {
		return this.userstate;
	}

	public void setUserstate(Userstate userstate) {
		this.userstate = userstate;
	}

	@Column(name = "userName", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "realName", length = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "unit", length = 200)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobilephone", length = 20)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "telephone", length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "area", length = 200)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}