package org.ajdai.CMS.tables;

import org.hibernate.annotations.Audited.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "Project")
public class Project {
	
	@Id
	private String ProjectName;
	
	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	
}
