package com.wlwz.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Videoinfo;
import com.wlwz.service.IVideoinfoService;
import com.wlwz.util.ReqRes;

@Component("videoAction")
@Scope("prototype")
public class VideoAction extends BaseAction{
	private Integer videoRecordId;
	private String imei;
	private Integer userGroup;
	private String videoUrl;

	public Integer getVideoRecordId() {
		return videoRecordId;
	}

	public void setVideoRecordId(Integer videoRecordId) {
		this.videoRecordId = videoRecordId;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Integer getUserGroup() throws Exception{
		if(userGroup == null){
			this.userGroup = (Integer)ReqRes.getSession().getAttribute("userGroup");
		}
	    return this.userGroup;
	}
	public void setUserGroup(Integer userGroup) throws Exception {
		if(userGroup == null){
			userGroup = (Integer)ReqRes.getSession().getAttribute("userGroup");
		}
		this.userGroup = userGroup;
	}
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	private IVideoinfoService videoinfoService;

	@Resource(name = "videoinfoService")
	public void setVideoinfoService(
			IVideoinfoService videoinfoService) {
		this.videoinfoService = videoinfoService;
	}
	
	public String getVideoinfoList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord = videoinfoService.countVideoinforecord(imei,getUserGroup());
			System.out.println("usergroup in getVideoinfoList "+userGroup);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);

			url = "videoinfoAction!getVideoinfoList.action";

			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}

			initPage();

			ses.setAttribute("totalPage", totalPage);
			ses.setAttribute("currentPage", currentPage);
			ses.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}
			queryList = videoinfoService.loadVideoreinfocordList(start
					+ limit * (currentPage - 1), limit, imei,getUserGroup());
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createVideoinfoRecord() {
		try {
			System.out.println("imei in createVideoinfoRecord "+imei);
			videoinfoService.creatVideoinforecord(imei,getUserGroup(), videoUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String check() {
		try {
			HttpSession session = ReqRes.getSession();
            Videoinfo a = videoinfoService.loadByVideoRecodId(videoRecordId);
			session.setAttribute("a", a);
			return "check";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String edit() {
		try {
			HttpSession session = ReqRes.getSession();
			Videoinfo a = videoinfoService.loadByVideoRecodId(videoRecordId);
			session.setAttribute("a", a);
			return "edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String saveEdit() {
		try {
			videoinfoService.saveEdit(videoRecordId, imei, getUserGroup(), videoUrl);
            getVideoinfoList();
            return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
            return "edit";
		}
	}

	// 逻辑删除
	public String delRecord() {
		try {
			videoinfoService.deleteRecord(videoRecordId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			getVideoinfoList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
