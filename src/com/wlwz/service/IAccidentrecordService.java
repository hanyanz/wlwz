package com.wlwz.service;

import java.sql.Timestamp;
import java.util.List;

import com.wlwz.entity.Accidentrecord;

public interface IAccidentrecordService {
	public Long countAccidentrecord(Integer queryDeviceId);

	public List<Accidentrecord> loadAllAccidentrecord(Integer start,
			Integer limit, Integer queryDeviceId);

	public Long countAccidentrecord(String deviceNumber);

	public List<Accidentrecord> loadAccidentrecordList(Integer start,
			Integer limit, String deviceNumber);

	public void creatAccidentRecord(Timestamp createTime, Short accidentType,
			String accidentUint, String responsiblePerson,
			String accidentReason, String damageAssessment, Float damageValue,
			String disposeRecord, String deviceNumber);

	public Accidentrecord loadOneAccidentrecord(String accidentRecordId);

	public void saveEdit(String id, Timestamp createTime, Short accidentType,
			String accidentUint, String responsiblePerson,
			String accidentReason, String damageAssessment, Float damageValue,
			String disposeRecord);

	public void deleteRecord(String id);
}
