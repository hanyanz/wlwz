package com.wlwz.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.wlwz.depoly.PropertyData;
import com.wlwz.depoly.depolyTable;
import com.wlwz.entity.Userstate;
import com.wlwz.service.IDepolyService;
import com.wlwz.service.IUserService;
import com.wlwz.util.ReqRes;


@Component("depoly_Action")
@Scope("prototype")
public class DepolyAction extends BaseAction{
	
	private String depolyStr;
	
	public String getDepolyStr() {
		return depolyStr;
	}

	public void setDepolyStr(String depolyStr) {
		this.depolyStr = depolyStr;
	}
	
	private IDepolyService depolyService;
	@Resource(name = "depolyService")
	public void setDepolyService(IDepolyService depolyService) {
		this.depolyService = depolyService;
	}
	
	public String acceptDepolyData() {
		  
		try {
			
			 if(depolyStr == null) {	
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("msg", "无效配置输入，请重新配置");
				return INPUT;
			}
			
			else if((depolyStr != null)) {				
				String[] depoly = depolyStr.split(",");
				/*如果配置参数字符串为1,34,varchar,8,,,，那么 下面语句打印的数组的长度为4，
				也就是其上限和下限不存在，会造成下面数组越界*/
		//		System.out.print("配置数组的长度是："+depoly.length);
				
		        //从session中得到userGroup的值
				Integer userGroup = (Integer)ReqRes.getSession().getAttribute("userGroup");
				System.out.println(userGroup);
				System.out.println("配置参数字符串为"+depolyStr);	
				depolyService.depolyWriteProperty(userGroup,depoly);
				depolyService.depolyDatabase(userGroup);				
				return SUCCESS;
			}
		} catch (Exception e) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "系统处理错误，请重新配置");
			return INPUT;
		}
		return INPUT;
	}

}
