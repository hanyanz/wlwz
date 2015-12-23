package com.wlwz.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Device entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "device", catalog = "wlwz")
public class Device implements java.io.Serializable {

	// Fields

	private Integer deviceId;
	private Project project;
	private Userstate userstate;
	private Unit unit;
	private String imei;
	private String deviceKind;
	private String deviceNumber;
	private String assetNumber;
	private String deviceName;
	private Integer deviceBigKind;
	private String typeName;
	private Timestamp operationDate;
	private String model;
	private Timestamp manufactDate;
	private String position;
	private String factoryArea;
	private String abclogo;
	private String company;
	private String plannersGroup;
	private String reportFuncPlace;
	private String technicNum;
	private String assetsProperty;
	private Float assetsOriginalValue;
	private Float assetsAdded;
	private Timestamp assetsAddDate;
	private Timestamp totalRunningTime;
	private Integer toatlUesdDays;
	private Integer serialNumber;
	private String inventory;
	private Boolean deviceState;
	private Float weight;
	private Float deviceSize;
	private Boolean isActive;
	private Set<Handoverrecord> handoverrecords = new HashSet<Handoverrecord>(0);
	private Set<Maintenancerecord> maintenancerecords = new HashSet<Maintenancerecord>(
			0);
	private Set<Everymonthrecord> everymonthrecords = new HashSet<Everymonthrecord>(
			0);
	private Set<Everydayrecord> everydayrecords = new HashSet<Everydayrecord>(0);
	private Set<Accidentrecord> accidentrecords = new HashSet<Accidentrecord>(0);
	private Set<Technicevaluation> technicevaluations = new HashSet<Technicevaluation>(
			0);

	// Constructors

	/** default constructor */
	public Device() {
	}

	/** minimal constructor */
	public Device(Userstate userstate, String imei) {
		this.userstate = userstate;
		this.imei = imei;
	}

	/** full constructor */
	public Device(Project project, Userstate userstate, Unit unit, String imei,
			String deviceKind, String deviceNumber, String assetNumber,
			String deviceName, Integer deviceBigKind, String typeName,
			Timestamp operationDate, String model, Timestamp manufactDate,
			String position, String factoryArea, String abclogo,
			String company, String plannersGroup, String reportFuncPlace,
			String technicNum, String assetsProperty,
			Float assetsOriginalValue, Float assetsAdded,
			Timestamp assetsAddDate, Timestamp totalRunningTime,
			Integer toatlUesdDays, Integer serialNumber, String inventory,
			Boolean deviceState, Float weight, Float deviceSize,
			Boolean isActive, Set<Handoverrecord> handoverrecords,
			Set<Maintenancerecord> maintenancerecords,
			Set<Everymonthrecord> everymonthrecords,
			Set<Everydayrecord> everydayrecords,
			Set<Accidentrecord> accidentrecords,
			Set<Technicevaluation> technicevaluations) {
		this.project = project;
		this.userstate = userstate;
		this.unit = unit;
		this.imei = imei;
		this.deviceKind = deviceKind;
		this.deviceNumber = deviceNumber;
		this.assetNumber = assetNumber;
		this.deviceName = deviceName;
		this.deviceBigKind = deviceBigKind;
		this.typeName = typeName;
		this.operationDate = operationDate;
		this.model = model;
		this.manufactDate = manufactDate;
		this.position = position;
		this.factoryArea = factoryArea;
		this.abclogo = abclogo;
		this.company = company;
		this.plannersGroup = plannersGroup;
		this.reportFuncPlace = reportFuncPlace;
		this.technicNum = technicNum;
		this.assetsProperty = assetsProperty;
		this.assetsOriginalValue = assetsOriginalValue;
		this.assetsAdded = assetsAdded;
		this.assetsAddDate = assetsAddDate;
		this.totalRunningTime = totalRunningTime;
		this.toatlUesdDays = toatlUesdDays;
		this.serialNumber = serialNumber;
		this.inventory = inventory;
		this.deviceState = deviceState;
		this.weight = weight;
		this.deviceSize = deviceSize;
		this.isActive = isActive;
		this.handoverrecords = handoverrecords;
		this.maintenancerecords = maintenancerecords;
		this.everymonthrecords = everymonthrecords;
		this.everydayrecords = everydayrecords;
		this.accidentrecords = accidentrecords;
		this.technicevaluations = technicevaluations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "deviceId", unique = true, nullable = false)
	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userGroup", nullable = false)
	public Userstate getUserstate() {
		return this.userstate;
	}

	public void setUserstate(Userstate userstate) {
		this.userstate = userstate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitId")
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Column(name = "IMEI", nullable = false, length = 50)
	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Column(name = "deviceKind", length = 50)
	public String getDeviceKind() {
		return this.deviceKind;
	}

	public void setDeviceKind(String deviceKind) {
		this.deviceKind = deviceKind;
	}

	@Column(name = "deviceNumber", length = 50)
	public String getDeviceNumber() {
		return this.deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	@Column(name = "assetNumber", length = 50)
	public String getAssetNumber() {
		return this.assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	@Column(name = "deviceName", length = 50)
	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name = "deviceBigKind")
	public Integer getDeviceBigKind() {
		return this.deviceBigKind;
	}

	public void setDeviceBigKind(Integer deviceBigKind) {
		this.deviceBigKind = deviceBigKind;
	}

	@Column(name = "typeName", length = 50)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "operationDate", length = 19)
	public Timestamp getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Timestamp operationDate) {
		this.operationDate = operationDate;
	}

	@Column(name = "model", length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "manufactDate", length = 19)
	public Timestamp getManufactDate() {
		return this.manufactDate;
	}

	public void setManufactDate(Timestamp manufactDate) {
		this.manufactDate = manufactDate;
	}

	@Column(name = "position", length = 50)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "factoryArea", length = 50)
	public String getFactoryArea() {
		return this.factoryArea;
	}

	public void setFactoryArea(String factoryArea) {
		this.factoryArea = factoryArea;
	}

	@Column(name = "ABCLogo", length = 50)
	public String getAbclogo() {
		return this.abclogo;
	}

	public void setAbclogo(String abclogo) {
		this.abclogo = abclogo;
	}

	@Column(name = "company", length = 50)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "plannersGroup", length = 50)
	public String getPlannersGroup() {
		return this.plannersGroup;
	}

	public void setPlannersGroup(String plannersGroup) {
		this.plannersGroup = plannersGroup;
	}

	@Column(name = "reportFuncPlace", length = 50)
	public String getReportFuncPlace() {
		return this.reportFuncPlace;
	}

	public void setReportFuncPlace(String reportFuncPlace) {
		this.reportFuncPlace = reportFuncPlace;
	}

	@Column(name = "technicNum", length = 50)
	public String getTechnicNum() {
		return this.technicNum;
	}

	public void setTechnicNum(String technicNum) {
		this.technicNum = technicNum;
	}

	@Column(name = "assetsProperty", length = 50)
	public String getAssetsProperty() {
		return this.assetsProperty;
	}

	public void setAssetsProperty(String assetsProperty) {
		this.assetsProperty = assetsProperty;
	}

	@Column(name = "assetsOriginalValue", precision = 12, scale = 0)
	public Float getAssetsOriginalValue() {
		return this.assetsOriginalValue;
	}

	public void setAssetsOriginalValue(Float assetsOriginalValue) {
		this.assetsOriginalValue = assetsOriginalValue;
	}

	@Column(name = "assetsAdded", precision = 12, scale = 0)
	public Float getAssetsAdded() {
		return this.assetsAdded;
	}

	public void setAssetsAdded(Float assetsAdded) {
		this.assetsAdded = assetsAdded;
	}

	@Column(name = "assetsAddDate", length = 19)
	public Timestamp getAssetsAddDate() {
		return this.assetsAddDate;
	}

	public void setAssetsAddDate(Timestamp assetsAddDate) {
		this.assetsAddDate = assetsAddDate;
	}

	@Column(name = "totalRunningTime", length = 19)
	public Timestamp getTotalRunningTime() {
		return this.totalRunningTime;
	}

	public void setTotalRunningTime(Timestamp totalRunningTime) {
		this.totalRunningTime = totalRunningTime;
	}

	@Column(name = "toatlUesdDays")
	public Integer getToatlUesdDays() {
		return this.toatlUesdDays;
	}

	public void setToatlUesdDays(Integer toatlUesdDays) {
		this.toatlUesdDays = toatlUesdDays;
	}

	@Column(name = "serialNumber")
	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "inventory", length = 50)
	public String getInventory() {
		return this.inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	@Column(name = "deviceState")
	public Boolean getDeviceState() {
		return this.deviceState;
	}

	public void setDeviceState(Boolean deviceState) {
		this.deviceState = deviceState;
	}

	@Column(name = "weight", precision = 12, scale = 0)
	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	@Column(name = "deviceSize", precision = 12, scale = 0)
	public Float getDeviceSize() {
		return this.deviceSize;
	}

	public void setDeviceSize(Float deviceSize) {
		this.deviceSize = deviceSize;
	}

	@Column(name = "isActive")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Handoverrecord> getHandoverrecords() {
		return this.handoverrecords;
	}

	public void setHandoverrecords(Set<Handoverrecord> handoverrecords) {
		this.handoverrecords = handoverrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Maintenancerecord> getMaintenancerecords() {
		return this.maintenancerecords;
	}

	public void setMaintenancerecords(Set<Maintenancerecord> maintenancerecords) {
		this.maintenancerecords = maintenancerecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Everymonthrecord> getEverymonthrecords() {
		return this.everymonthrecords;
	}

	public void setEverymonthrecords(Set<Everymonthrecord> everymonthrecords) {
		this.everymonthrecords = everymonthrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Everydayrecord> getEverydayrecords() {
		return this.everydayrecords;
	}

	public void setEverydayrecords(Set<Everydayrecord> everydayrecords) {
		this.everydayrecords = everydayrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Accidentrecord> getAccidentrecords() {
		return this.accidentrecords;
	}

	public void setAccidentrecords(Set<Accidentrecord> accidentrecords) {
		this.accidentrecords = accidentrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "device")
	public Set<Technicevaluation> getTechnicevaluations() {
		return this.technicevaluations;
	}

	public void setTechnicevaluations(Set<Technicevaluation> technicevaluations) {
		this.technicevaluations = technicevaluations;
	}

}