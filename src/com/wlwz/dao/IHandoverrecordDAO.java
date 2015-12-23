package com.wlwz.dao;
import com.wlwz.entity.Handoverrecord;

public interface IHandoverrecordDAO {
	public void save(Handoverrecord transientInstance);

	public Handoverrecord findById(java.lang.String id);

	public void attachDirty(Handoverrecord instance);
}
