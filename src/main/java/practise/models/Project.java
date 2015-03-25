package practise.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long projectId;
	
	@Column
	public String projectName;
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public List<Employee> getProjectEmployees() {
		return projectEmployees;
	}

	public void setProjectEmployees(List<Employee> projectEmployees) {
		this.projectEmployees = projectEmployees;
	}

	@Column
	public String projectClient;
	
	@Column
	public String projectLocation;
	
	@Column
	public String projectDescription;
	
	//@OneToMany(mappedBy="empProject")
	 @OneToMany(cascade={CascadeType.ALL})
	 @JoinColumn(name="projectId")
	 @IndexColumn(name="idx")
	 private List <Employee> projectEmployees;
	
	
	public Project() { }

	public Project(long id) { 	
		this.projectId = id;  
	}
  
	public Project(String name, String client, String location, String description) {  
		this.projectName = name;
		this.projectClient = client;
		this.projectLocation = location;
		this.projectDescription = description;
	}


}
