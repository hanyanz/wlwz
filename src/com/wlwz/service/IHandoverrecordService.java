package com.wlwz.service;

import java.sql.Timestamp;
import java.util.List;

import com.wlwz.entity.Handoverrecord;

public interface IHandoverrecordService {
	public Long countHandoverrecord(String deviceNumber);

	public List<Handoverrecord> loadHandoverrecordList(Integer start,
			Integer limit, String deviceNumber);

	public void createHandoverrecord(String deviceNumber, Timestamp createTime,
			String transferUnit, String transferPerson, String acceptUint,
			String acceptPerson);

	public void saveEdit(String id, Timestamp createTime, String transferUnit,
			String transferPerson, String acceptUint, String acceptPerson);

	public Handoverrecord loadOneHandoverrecord(String id);

	public void deleteRecord(String id);
}
