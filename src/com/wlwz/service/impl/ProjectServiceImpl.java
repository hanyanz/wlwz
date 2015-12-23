package com.wlwz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.wlwz.dao.ICommonDAO;
import com.wlwz.dao.IProjectDAO;
import com.wlwz.entity.Project;
import com.wlwz.service.IProjectService;

@Component("project_Service")
public class ProjectServiceImpl implements IProjectService {
	private static final Logger logger = Logger
			.getLogger(ProjectServiceImpl.class);

	private ICommonDAO commonDAO;

	@Resource(name = "comDAO")
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private IProjectDAO projectDAO;

	@Resource(name = "project_DAO")
	public void setProjectDAO(IProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	// 统计项目条数
	public Long countProject() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Project.class);
		dtr.add(Restrictions.eq("isActive", true));
		return commonDAO.findByDetachedCriteriaForCount(dtr);
	}

	// 搜索项目list，导入左侧菜单栏
	public List<Project> getList() {
		DetachedCriteria dtr = DetachedCriteria.forClass(Project.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.asc("projectId"));
		return commonDAO.findByDetachedCriteria(dtr);
	}

	// 固定页搜索项目list
	public List<Project> loadProjectList(Integer start, Integer limit) {
		DetachedCriteria dtr = DetachedCriteria.forClass(Project.class);
		dtr.add(Restrictions.eq("isActive", true));
		dtr.addOrder(Order.desc("projectId"));
		return commonDAO.findByDetachedCriteriaWithLimit(dtr, start, limit);
	}

	// 新建项目
	public void createProject(String projectName, String projectAddress,
			String projectLeader, String telephone) {
		Project project = new Project();
		project.setProjectName(projectName);
		project.setProjectLeader(projectLeader);
		project.setProjectAddress(projectAddress);
		project.setTelephone(telephone);
		project.setIsActive(true);
		projectDAO.save(project);
	}

	// 根据项目ID获取具体项目具体信息
	public Project getProject(Integer projectId) {
		if (projectId != null) {
			Project project = new Project();
			project = projectDAO.findById(projectId);
			if (project != null) {
				return project;
			}
		}
		return null;
	}

	// 删除项目
	public void deleteProject(Integer projectId) {
		if (projectId != null) {
			Project project = new Project();
			project = projectDAO.findById(projectId);
			if (project != null) {
				project.setIsActive(false);
				projectDAO.attachDirty(project);
				// projectDAO.delete(project);
			}
		}
	}

	// 保存对一个项目的修改
	public void saveEdit(Integer projectId, String projectName,
			String projectLeader, String projectAddress, String telephone) {
		Project p = new Project();
		p = projectDAO.findById(projectId);
		if (p != null) {
			p.setProjectName(projectName);
			p.setProjectAddress(projectAddress);
			p.setProjectLeader(projectLeader);
			p.setTelephone(telephone);
			projectDAO.attachDirty(p);
		}
	}
}
