package com.gn.practice00.controller;

import com.gn.practice00.dao.ProjectDao;

public class ProjectController {
	ProjectDao pd = new ProjectDao();
	
	public void selectMemberAll() {
		pd.selectMemberAll();
	}
}
