package com.gl.controllers;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.beans.Student;
import com.gl.dao.StudentDao; 



@Controller
public class StudentController {
	
	@Autowired    
	StudentDao dao;
	
	 /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/studentform")    
    public String showform(Model m){    
        m.addAttribute("command", new Student());  
        return "studentform";   
    }  
    
    /*  It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/ 
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("Student") Student stud){    
        dao.save(stud);    
        return "redirect:/viewstudents"; //will redirect to view request mapping    
    }    
    
    /* It provides list of students in model object */    
    
    @RequestMapping("/viewstudents")    
    public String viewStudents(Model m){    
        List<Student> list=dao.getStudents();    
        m.addAttribute("list",list);  
        return "viewstudents";    
    } 
    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/   
    
    @RequestMapping(value="/studeditform/{id}")    
    public String edit(@PathVariable int id, Model m){    
    	Student emp=dao.getStudentById(id);    
        m.addAttribute("command",emp);  
        return "studeditform";    
    }  
    
    /* It updates model object. */   
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("Student") Student stud){    
        dao.update(stud);    
        return "redirect:/viewstudents";    
    }   
    
    /* It deletes record for the given id in URL and redirects to /viewstudent */    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewstudents";    
    }   
    

}
