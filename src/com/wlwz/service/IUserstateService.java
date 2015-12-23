package com.wlwz.service;

import com.wlwz.entity.Userstate;

public interface IUserstateService {
	public void createUserstate( String userSign,Integer state);
	public Integer getUsergroup(String userSign);
	public Userstate getUserState(Integer userGroup);
	public void  changeState(Integer userGroup,Integer state);
}
