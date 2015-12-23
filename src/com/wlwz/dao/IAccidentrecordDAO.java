package com.wlwz.dao;

import com.wlwz.entity.Accidentrecord;

public interface IAccidentrecordDAO  {
	
	public void save(Accidentrecord transientInstance); 
	
	public void delete(Accidentrecord persistentInstance); 

	public Accidentrecord findById(java.lang.String id); 

	public void attachDirty(Accidentrecord instance); 
}