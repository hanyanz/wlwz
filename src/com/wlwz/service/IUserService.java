package com.wlwz.service;

import java.util.List;

import com.wlwz.entity.Systemrole;
import com.wlwz.entity.User;

public interface IUserService {
	@SuppressWarnings("unchecked")
	User login(String loginName, String password);

	public void createUser(Integer systemRoleId, String userName,
			String realName, String unit, String email, String mobilephone,
			String telephone, String area);
	public void createUser(Integer userGroup,Integer systemRoleId, String userName, String  password,
			String realName, String unit, String email, String mobilephone,
			String telephone, String area);

	public void deleteUser(Integer userId);

	public void modifyUser(Integer userId, Integer systemRoleId,
			String userName, String password, String realName, String unit,
			String email, String mobilephone, String telephone, String area);

	public Long countUser(String userNameTop);

	public List<User> loadUserList(Integer start, Integer limit,
			String userNameTop);

	public User loadOneUser(Integer userId);

	public List<Systemrole> getAllSystemrole();
}
