package com.wlwz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Videoinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "videoinfo", catalog = "wlwz")
public class Videoinfo implements java.io.Serializable {

	// Fields

	private Integer videoRecordId;
	private String imei;
	private Integer userGroup;
	private String videoUrl;
	private Boolean isActive;

	// Constructors

	/** default constructor */
	public Videoinfo() {
	}

	/** full constructor */
	public Videoinfo(String imei, Integer userGroup, String videoUrl) {
		this.imei = imei;
		this.userGroup = userGroup;
		this.videoUrl = videoUrl;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "videoRecordId", unique = true, nullable = false)
	public Integer getVideoRecordId() {
		return this.videoRecordId;
	}

	public void setVideoRecordId(Integer videoRecordId) {
		this.videoRecordId = videoRecordId;
	}

	@Column(name = "IMEI", nullable = false, length = 20)
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "userGroup", nullable = false)
	public Integer getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

	@Column(name = "videoURL", nullable = false, length = 200)
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}