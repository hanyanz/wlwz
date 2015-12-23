package com.wlwz.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IDeviceDAO;
import com.wlwz.entity.Device;

/**
 * A data access object (DAO) providing persistence and search support for
 * Device entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wlw.Device
 * @author MyEclipse Persistence Tools
 */
@Component("deviceDAO")
public class DeviceDAOImpl extends SuperDao implements IDeviceDAO {
	private static final Logger log = LoggerFactory.getLogger(DeviceDAOImpl.class);
	// property constants
	public static final String IMEI = "imei";
	public static final String DEVICE_KIND = "deviceKind";
	public static final String DEVICE_NUMBER = "deviceNumber";
	public static final String ASSET_NUMBER = "assetNumber";
	public static final String DEVICE_NAME = "deviceName";
	public static final String DEVICE_BIG_KIND = "deviceBigKind";
	public static final String TYPE_NAME = "typeName";
	public static final String MODEL = "model";
	public static final String POSITION = "position";
	public static final String FACTORY_AREA = "factoryArea";
	public static final String ABCLOGO = "abclogo";
	public static final String COMPANY = "company";
	public static final String PLANNERS_GROUP = "plannersGroup";
	public static final String REPORT_FUNC_PLACE = "reportFuncPlace";
	public static final String TECHNIC_NUM = "technicNum";
	public static final String ASSETS_PROPERTY = "assetsProperty";
	public static final String ASSETS_ORIGINAL_VALUE = "assetsOriginalValue";
	public static final String ASSETS_ADDED = "assetsAdded";
	public static final String TOATL_UESD_DAYS = "toatlUesdDays";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String INVENTORY = "inventory";
	public static final String DEVICE_STATE = "deviceState";
	public static final String WEIGHT = "weight";
	public static final String DEVICE_SIZE = "deviceSize";
	public static final String IS_ACTIVE = "isActive";

	public void save(Device transientInstance) {
		log.debug("saving Device instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Device persistentInstance) {
		log.debug("deleting Device instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Device findById(java.lang.Integer id) {
		log.debug("getting Device instance with id: " + id);
		try {
			Device instance = (Device) getHibernateTemplate().get("com.wlwz.entity.Device", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Device> findByExample(Device instance) {
		log.debug("finding Device instance by example");
		try {
			List<Device> results = (List<Device>) getHibernateTemplate()
			.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Device instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Device as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Device getByIMEISeriers(String IMEISeriers) {
		String queryString = "from Device as d where d.isActive = true and d.imeiSeriers = "
				+ IMEISeriers + " order by d.deviceId ASC";
		List<Device> list = getHibernateTemplate().find(queryString);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}


	public List<Device> findByImei(Object imei) {
		return findByProperty(IMEI, imei);
	}

	public List<Device> findByDeviceKind(Object deviceKind) {
		return findByProperty(DEVICE_KIND, deviceKind);
	}

	
	
	public List<Device> findByAssetNumber(Object assetNumber) {
		return findByProperty(ASSET_NUMBER, assetNumber);
	}

	
	public List<Device> findByDeviceName(Object deviceName) {
		return findByProperty(DEVICE_NAME, deviceName);
	}

	public List<Device> findByDeviceBigKind(Object deviceBigKind) {
		return findByProperty(DEVICE_BIG_KIND, deviceBigKind);
	}

	public List<Device> findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List<Device> findByModel(Object model) {
		return findByProperty(MODEL, model);
	}

	public List<Device> findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List<Device> findByFactoryArea(Object factoryArea) {
		return findByProperty(FACTORY_AREA, factoryArea);
	}

	public List<Device> findByAbclogo(Object abclogo) {
		return findByProperty(ABCLOGO, abclogo);
	}

	public List<Device> findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List<Device> findByPlannersGroup(Object plannersGroup) {
		return findByProperty(PLANNERS_GROUP, plannersGroup);
	}

	public List<Device> findByReportFuncPlace(Object reportFuncPlace) {
		return findByProperty(REPORT_FUNC_PLACE, reportFuncPlace);
	}

	public List<Device> findByTechnicNum(Object technicNum) {
		return findByProperty(TECHNIC_NUM, technicNum);
	}

	public List<Device> findByAssetsProperty(Object assetsProperty) {
		return findByProperty(ASSETS_PROPERTY, assetsProperty);
	}

	public List<Device> findByAssetsOriginalValue(Object assetsOriginalValue) {
		return findByProperty(ASSETS_ORIGINAL_VALUE, assetsOriginalValue);
	}

	public List<Device> findByAssetsAdded(Object assetsAdded) {
		return findByProperty(ASSETS_ADDED, assetsAdded);
	}

	public List<Device> findByToatlUesdDays(Object toatlUesdDays) {
		return findByProperty(TOATL_UESD_DAYS, toatlUesdDays);
	}

	public List<Device> findBySerialNumber(Object serialNumber) {
		return findByProperty(SERIAL_NUMBER, serialNumber);
	}

	public List<Device> findByInventory(Object inventory) {
		return findByProperty(INVENTORY, inventory);
	}

	public List<Device> findByDeviceState(Object deviceState) {
		return findByProperty(DEVICE_STATE, deviceState);
	}

	public List<Device> findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List<Device> findByDeviceSize(Object deviceSize) {
		return findByProperty(DEVICE_SIZE, deviceSize);
	}

	public List<Device> findByIsActive(Object isActive) {
		return findByProperty(IS_ACTIVE, isActive);
	}

	public List findAll() {
		log.debug("finding all Device instances");
		try {
			String queryString = "from Device";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Device merge(Device detachedInstance) {
		log.debug("merging Device instance");
		try {
			Device result = (Device)  getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Device instance) {
		log.debug("attaching dirty Device instance");
		try {
			 getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Device instance) {
		log.debug("attaching clean Device instance");
		try {
			 getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public Device findByDeviceNumber(Object value) {
		try {
			String queryString = "from Device as model where model.deviceNumber='"
					+ value + "'";
			List<Device> list = getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}