package com.gn.practice00.controller;

import java.util.List;

import com.gn.practice00.dao.ProjectDao;
import com.gn.practice00.vo.Project;

public class ProjectController {
	ProjectDao pd = new ProjectDao();
	
	public List<Project> selectMemberAll() {
		return pd.selectMemberAll();
	}
}
