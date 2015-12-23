package com.wlwz.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wlwz.entity.Project;
import com.wlwz.service.IProjectService;
import com.wlwz.util.ReqRes;

@Component("project_Action")
@Scope("prototype")
public class ProjectAction extends BaseAction {

	private Integer projectId;
	private String projectName;
	private String projectAddress;
	private String projectLeader;
	private String telephone;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private IProjectService projectService;

	@Resource(name = "project_Service")
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	// 搜索list传给左侧菜单栏
	public String getList() {
		try {
			HttpSession session = ReqRes.getSession();
			List pList = projectService.getList();
			session.setAttribute("pList", pList);
			return "left";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String loadProjectList() {
		ClearList(queryList);
		success = false;
		try {
			HttpSession session = ReqRes.getSession();
			totalRecord = projectService.countProject();
			totalPage = (int) (totalRecord % limit == 0 ? totalRecord / limit
					: totalRecord / limit + 1);
			url = "projectAction!loadProjectList.action";

			if (currentPage == null || "".equals(currentPage)) {
				currentPage = 1;
			}

			initPage();
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("url", url);
			if (totalRecord == null || totalRecord.intValue() <= 0) {
				success = true;
				return SUCCESS;
			}

			queryList = projectService.loadProjectList(start + limit
					* (currentPage - 1), limit);
			success = true;
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public void createProject() {
		try {
			projectService.createProject(projectName, projectAddress,
					projectLeader, telephone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkProject() {
		try {
			Project pro = new Project();
			pro = projectService.getProject(projectId);
			if (pro != null) {
				HttpSession session = ReqRes.getSession();
				session.setAttribute("p", pro);
				return "check";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改项目内容
	public String editProject() {
		try {
			Project project = new Project();
			project = projectService.getProject(projectId);
			if (project != null) {
				HttpSession session = ReqRes.getSession();
				session.setAttribute("p", project);
				return "edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改后保存
	public void saveEdit() {
		try {
			projectService.saveEdit(projectId, projectName, projectLeader,
					projectAddress, telephone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除一个项目
	public String deleteProject() {
		try {
			projectService.deleteProject(projectId);
			HttpSession session = ReqRes.getSession();
			currentPage = (Integer) session.getAttribute("currentPage");
			loadProjectList();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
