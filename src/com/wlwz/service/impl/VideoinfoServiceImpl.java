package com.wlwz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IVideoinfoDAO;
import com.wlwz.entity.Videoinfo;
import com.wlwz.service.IVideoinfoService;
import com.wlwz.util.ReqRes;


@Component("videoinfoService")
public class VideoinfoServiceImpl implements IVideoinfoService{
	private ICommonDAO commonDAO;
//	private static  Integer userGroup ;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	private IVideoinfoDAO videoinfoDAO;
	@Resource(name = "videoinfoDAO")
	public void setVideoinfoDAO(IVideoinfoDAO videoinfoDAO){
		this.videoinfoDAO = videoinfoDAO;
	}
	
//	public Integer getUserGroup() throws Exception{
//		if(userGroup == null){
//			userGroup = (Integer)ReqRes.getSession().getAttribute("userGroup");
//		}
//	    return userGroup;
//	}
	
	/**
	 * 查询数据记录条数，根据设备条件搜索
	 */
	public Long countVideoinforecord(Integer queryVideoRecordId) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Videoinfo.class);
		if ((queryVideoRecordId != null && !"".equals(queryVideoRecordId)))
			dtr.add(Restrictions.like("Videoinfo.queryVideoRecordId", "%"
					+ queryVideoRecordId + "%"));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	/**
	 * 查询数据记录，搜索条件为首尾页、设备代码
	 */
	public List<Videoinfo> loadAllVideoinforecord(Integer start,
			Integer limit, Integer queryVideoRecordId) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Videoinfo.class);
		if ((queryVideoRecordId != null && !"".equals(queryVideoRecordId)))
			dtr.add(Restrictions.like("videoRecordId", "%"
					+ queryVideoRecordId + "%"));
		//dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	/**
	 * 查询数据记录条数，根据设备条件搜索
	 * @throws Exception 
	 */
	public Long countVideoinforecord(String IMEI,Integer userGroup)  {
		DetachedCriteria dtr = DetachedCriteria.forClass(Videoinfo.class);
		
   
		if (IMEI != null && !"".equals(IMEI)) {
//			dtr.createAlias("videoinfo", "videoinfo");
			dtr.add(Restrictions.like("imei", "%" + IMEI
					+ "%"));
//			dtr.add(Restrictions.like("videoinfo.userGroup", userGroup));
		}
		dtr.add(Restrictions.eq("userGroup",userGroup));
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	/**
	 * 查询数据记录，搜索条件为首尾页、设备代码
	 * @throws Exception 
	 */
	public List<Videoinfo> loadVideoreinfocordList(Integer start,
			Integer limit, String IMEI,Integer userGroup)  {
		DetachedCriteria dtr = DetachedCriteria.forClass(Videoinfo.class);

		if (IMEI != null && !"".equals(IMEI)) {
//			dtr.createAlias("videoinfo", "videoinfo");
			dtr.add(Restrictions.like("imei", "%" + IMEI
					+ "%"));
		}
		dtr.add(Restrictions.eq("userGroup", userGroup));
		dtr.add(Restrictions.eq("isActive", true));
	//	dtr.addOrder(Order.desc("createTime"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 新建一条记录
	public void creatVideoinforecord( String imei, Integer userGroup,String videoUrl)  {
		Videoinfo videoinfo = new Videoinfo();	
		videoinfo.setImei(imei);
		videoinfo.setUserGroup(userGroup);
		videoinfo.setVideoUrl(videoUrl);	
		videoinfo.setIsActive(true);
		videoinfoDAO.save(videoinfo);
		System.out.println("saved a videoinfo successfully");
	}

	// 查询一条记录
	public Videoinfo loadOneVideoinforecord(String imei) {
		if (imei != null && !"".equals(imei)) {
			Videoinfo videoinfo = new Videoinfo();
			videoinfo = (Videoinfo) videoinfoDAO.findByImei(imei);
			return videoinfo;
		}
		return null;
	}

	public Videoinfo loadByVideoRecodId(Integer videoRecodId){
		Videoinfo videoinfo = null;
		if (videoRecodId != null && !"".equals(videoRecodId)) {
			videoinfo = videoinfoDAO.findById(videoRecodId);
		}
		return videoinfo;
	}

	// 保存对记录的修改
	public void saveEdit(Integer id,String imei, Integer userGroup, String videoUrl ) {
		if (id != null && !"".equals(id)) {
			Videoinfo videoinfo = videoinfoDAO.findById(id);
			if (videoinfo != null) {
				videoinfo.setImei(imei);
				videoinfo.setUserGroup(userGroup);
				videoinfo.setVideoUrl(videoUrl);			
				videoinfoDAO.attachDirty(videoinfo);
			}
		}
	}

	// 暂时采用逻辑删除，对数据库内容不进行物理删除
	public void deleteRecord(Integer id) {
		if (id != null && !"".equals(id)) {
			Videoinfo videoinfo = videoinfoDAO.findById(id);
			if (videoinfo != null) {
				videoinfo.setIsActive(false);
				videoinfoDAO.attachDirty(videoinfo);
				// accidentrecordDAO.delete(a);
			}
		}
	}
	
	
	
	

}
