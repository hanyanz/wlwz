package com.wlwz.service;

import java.util.List;

import com.wlwz.entity.Project;

public interface IProjectService {
	public Long countProject();

	public List<Project> loadProjectList(Integer start, Integer limit);

	public Project getProject(Integer projectId);

	public void deleteProject(Integer projectId);

	public void createProject(String projectName, String projectAddress,
			String projectLeader, String telephone);

	public void saveEdit(Integer projectId, String projectName,
			String projectLeader, String projectAddress, String telephone);

	public List<Project> getList();
}
