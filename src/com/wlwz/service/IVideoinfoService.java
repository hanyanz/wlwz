package com.wlwz.service;

import java.util.List;

import com.wlwz.entity.Videoinfo;

public interface IVideoinfoService {
	public Long countVideoinforecord(Integer queryVideoRecordId); 

	public List<Videoinfo> loadAllVideoinforecord(Integer start,
			Integer limit, Integer queryVideoRecordId);

	public Videoinfo loadByVideoRecodId(Integer videoRecodId);
	
	public Long countVideoinforecord(String IMEI,Integer userGroup);
	
	public List<Videoinfo> loadVideoreinfocordList(Integer start,
			Integer limit, String IMEI,Integer userGroup);
	
	public void creatVideoinforecord( String imei, Integer userGroup,String videoUrl);
	
	public Videoinfo loadOneVideoinforecord(String imei);
	
	public void saveEdit(Integer id,String imei, Integer userGroup, String videoUrl );

	public void deleteRecord(Integer id) ;

}
