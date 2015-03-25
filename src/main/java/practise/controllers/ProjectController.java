package practise.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import practise.models.Employee;
import practise.models.EmployeeDao;
import practise.models.KnowledgeTransfer;
import practise.models.KnowledgeTransferDao;
import practise.models.Project;
import practise.models.ProjectDao;

@Controller
public class ProjectController {

	@Autowired
	  public ProjectDao projectDao;
	
	@Autowired
	public EmployeeDao employeeDao;
	
	@Autowired
	public KnowledgeTransferDao knowledgeTransferDao;

  @RequestMapping("/")
  @ResponseBody
  public ModelAndView index() {
	  ModelAndView modelAndView = new ModelAndView("SamplePage");
	  modelAndView.addObject("project", new Project());
	  modelAndView.addObject("employee", new Employee());
	  modelAndView.addObject("knowledgeTransfer", new KnowledgeTransfer());
	  /*Object projectList = projectDao.findAll();
	   Object employeeList = employeeDao.findAll();
	    Object knowledgeTransferList = knowledgeTransferDao.findAll();
	    modelAndView.addObject("projectList", projectList);
	    modelAndView.addObject("employeeList", employeeList);
	    modelAndView.addObject("knowledgeTransferList", knowledgeTransferList);*/
	  return modelAndView;
  }
  
  @RequestMapping(value="/project" , method=RequestMethod.POST)
	public ModelAndView projectActions(@ModelAttribute Project project, BindingResult result, @RequestParam Map<String, Object> map){
	    ModelAndView modelAndView = new ModelAndView("SamplePage");
	    System.out.println("client is " + project.getProjectId());
	    System.out.println("client is " + project.getProjectClient());
	    projectDao.save(project);
	    
	   
	   /* Object projectList = projectDao.findAll();
	    Object employeeList = employeeDao.findAll();
	    Object knowledgeTransferList = knowledgeTransferDao.findAll();
	    modelAndView.addObject("projectList", projectList);
	    modelAndView.addObject("employeeList", employeeList);
	    modelAndView.addObject("knowledgeTransferList", knowledgeTransferList);
	    */
		return modelAndView;
	}
  
  @RequestMapping(value="/employee")
	public ModelAndView employeetActions(@ModelAttribute Employee employee, BindingResult result, @RequestParam Map<String, Object> map){
	    ModelAndView modelAndView = new ModelAndView("SamplePage");
	    employeeDao.save(employee);
	    
	    Object projectList = projectDao.findAll();
	    Object employeeList = employeeDao.findAll();
	    Object knowledgeTransferList = knowledgeTransferDao.findAll();
	    modelAndView.addObject("projectList", projectList);
	    modelAndView.addObject("employeeList", employeeList);
	    modelAndView.addObject("knowledgeTransferList", knowledgeTransferList);
	    
		return modelAndView;
	}
  
  @RequestMapping(value="/knowledgeTransfer", method=RequestMethod.POST)
	public ModelAndView projectActions(@ModelAttribute KnowledgeTransfer knowledgeTransfer, BindingResult result, @RequestParam Map<String, Object> map){
	    ModelAndView modelAndView = new ModelAndView("SamplePage");
	    knowledgeTransferDao.save(knowledgeTransfer);
	    
	    Object projectList = projectDao.findAll();
	    Object employeeList = employeeDao.findAll();
	    Object knowledgeTransferList = knowledgeTransferDao.findAll();
	    modelAndView.addObject("projectList", projectList);
	    modelAndView.addObject("employeeList", employeeList);
	    modelAndView.addObject("knowledgeTransferList", knowledgeTransferList);
	    
		return modelAndView;
	}

}