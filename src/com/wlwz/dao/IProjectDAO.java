package com.wlwz.dao;
import com.wlwz.entity.Project;

public interface IProjectDAO {
	public void save(Project transientInstance);

	public Project findById(java.lang.Integer id);

	public void delete(Project persistentInstance);

	public void attachDirty(Project instance);

	public Project findByProjectName(Object value);
}
