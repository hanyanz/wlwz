package com.wlwz.action;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Userstate;
import com.wlwz.service.IUserService;
import com.wlwz.service.IUserstateService;

@Component("register_Action")
@Scope("prototype")
public class RegisterAction extends BaseAction{
    private String userName;
	private String password;
	private String realName;
	private String unit;
	private String email;
	private String mobilephone;
	private String telephone;
	private String area;
	private String isActive;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit ) {
		this.unit= unit;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email ) {
		this.email = email;
	}
	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone ) {
		this.mobilephone = mobilephone;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive ) {
		this.isActive = isActive;
	}

	private IUserService userService;

	@Resource(name = "user_Service")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	private IUserstateService userstateService;

	@Resource(name = "userstateService")
	public void setUserstateService(IUserstateService userstateService) {
		this.userstateService = userstateService;
	}
	
	//注册界面注册新用户
	public String register() {
		try {
			
		if (userName == null || password == null || realName == null || unit == null || email == null || mobilephone == null || area == null ) {
					HttpServletRequest request = ServletActionContext.getRequest();
					request.setAttribute("msg", "请填写完整注册信息，*标记的为必填");
					return INPUT;
				}			
				
				else  {
			   //这里要先生成用户标志和用户组号，即要先生成一条用户状态表的记录(默认为2，对应配置前的状态)；然后再创建新用户
					String userSign = generateShortUuid();
					userstateService.createUserstate(userSign, 2);
					Integer userGroup = userstateService.getUsergroup(userSign);
					System.out.println(userSign+" "+userGroup);
					userService.createUser(userGroup,1, userName, password, realName,unit,
							email, mobilephone, telephone, area);
					
					return SUCCESS;
				}
		} catch (Exception e) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "系统处理错误，请重新配置");
			return INPUT;
		}
		
	}
	
	
	private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
		"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
		"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
		"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
		"W", "X", "Y", "Z" };


	private static String generateShortUuid() {
	StringBuffer shortBuffer = new StringBuffer();
	String uuid = UUID.randomUUID().toString().replace("-", "");
	for (int i = 0; i < 8; i++) {
		String str = uuid.substring(i * 4, i * 4 + 4);
		int x = Integer.parseInt(str, 16);
		shortBuffer.append(chars[x % 0x3E]);
	}
	return shortBuffer.toString();
	
	}

}
