package com.wlwz.service;

import java.util.List;

import com.wlwz.entity.Unit;

public interface IUnitService {
	public Long countUnit();

	public List<Unit> loadUnitList(Integer start, Integer limit);

	public void createUnit(String unitName, String unitBelonged,
			String midteamLeader, String leaderTele);

	public Unit getUnit(Integer midteamId);

	public void deleteUnit(Integer midteamId);

	public void saveEdit(Integer midteamId, String midteamName,
			String unitBelonged, String midteamLeader, String leaderTele);

	public List<Unit> getList();
}
