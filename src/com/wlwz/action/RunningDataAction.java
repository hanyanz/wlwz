package com.wlwz.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.dao.IRunningdataDAO;
import com.wlwz.service.IRunningdataService;
import com.wlwz.util.ReqRes;

@Component("runningdata_Action")
@Scope("prototype")
public class RunningDataAction extends BaseAction {

	private Integer queryDeviceId;

	public void setQueryDeviceId(Integer queryDeviceId) {
		this.queryDeviceId = queryDeviceId;
	}

	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	private IRunningdataService runningdataService;

	@Resource(name = "runningdata_Service")
	public void setCService(
			IRunningdataService runningdataService) {
		this.runningdataService = runningdataService;
	}

	private IRunningdataDAO runningdataDAO;

	@Resource(name = "runningdataDAO")
	public void setRunningdataDAO(IRunningdataDAO runningdataDAO) {
		this.runningdataDAO = runningdataDAO;
	}

	public String loadRunningdataList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession ses = ReqRes.getSession();
			totalRecord =  runningdataService.countRunningdata(deviceId);
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);

			url = "runningdataAction!loadRunningdataList.action";
			initPage();

			ses.setAttribute("totalPage", totalPage);
			ses.setAttribute("currentPage", currentPage);
			ses.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}

			queryList = runningdataService.loadRunningdataList(start
					+ limit * (currentPage - 1), limit, deviceId);
			success = true;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}


}
