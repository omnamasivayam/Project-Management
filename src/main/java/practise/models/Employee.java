package practise.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

//import org.hibernate.annotations.CollectionOfElements; 

@Entity
@Table(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
/*
	public Project getEmpProject() {
		return empProject;
	}

	public void setEmpProject(Project empProject) {
		this.empProject = empProject;
	}*/

	public Set<String> getEmpSkillSet() {
		return empSkillSet;
	}

	public void setEmpSkillSet(Set<String> empSkillSet) {
		this.empSkillSet = empSkillSet;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public List<KnowledgeTransfer> getEmpKnowledgeTransferSet() {
		return empKnowledgeTransferSet;
	}

	public void setEmpKnowledgeTransferSet(
			List<KnowledgeTransfer> empKnowledgeTransferSet) {
		this.empKnowledgeTransferSet = empKnowledgeTransferSet;
	}

	@Column
	private String empName;
	
	
	//@ManyToOne
	//@JoinColumn(name="projectId",insertable=false, updatable=false)
	//private Project empProject;
	
	@ElementCollection
	@Column
	private Set<String> empSkillSet = new HashSet<String>();
	
	@Column
	private String empDesignation;
	
	
	 @OneToMany(cascade={CascadeType.ALL})
	 @JoinColumn(name="empId")
	 @IndexColumn(name="kdx")
	 private List <KnowledgeTransfer> empKnowledgeTransferSet;
	
	//private Set<KnowledgeTransfer> empKnowledgeTransferSet = new HashSet <KnowledgeTransfer>();
	
	public Employee() { }

	  public Employee(long id) { 
	    this.empId = id;
	  }
	  
	  //public Employee(String name, Project project, Set<String> skillSet, String designation) {  
	  public Employee(String name, Set<String> skillSet, String designation) {   
		  this.empName = name;
	//    this.empProject = project;
	    this.empSkillSet = skillSet;
	    this.empDesignation = designation;
	  }

	
	
	
}
