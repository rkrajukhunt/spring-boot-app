package com.telusko.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.telusko.model.Student;
import com.telusko.service.StudentService;

@Controller
public class IndexController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
    public String root(Model model) {
		model.addAttribute("reqUser", new Student());
        return "reg";
    }
	
	@RequestMapping("/reg")
    public String root1(Model model) {
		model.addAttribute("reqUser", new Student());
        return "reg.html";
    }
	
	@RequestMapping("/showStudent")
    public ModelAndView show() {
		ModelAndView modelAndView = new ModelAndView("showResult");
		modelAndView.addObject("students", studentService.findAll());
		modelAndView.addObject("city",studentService.findCity());
		return modelAndView;
    }
	
	@RequestMapping("/showStudentAPI/{age}")
	@ResponseBody
    public List<Object[]> api(@PathVariable int age) {
		if(age==1) 
			return studentService.findByAgeGroup(1,10);
		else if(age==2)
			return studentService.findByAgeGroup(11,20);
		else if(age==3)
			return studentService.findByAgeGroup(21,30);
		else
			return null;
    }
	
	@RequestMapping("/showStudentAPI/{age}/{city}")
	@ResponseBody
    public List<Object[]> api(@PathVariable int age,@PathVariable String city) {
		if(age==1) 
			return studentService.findByAgeWithCityGroup(1, 10, city);
		else if(age==2)
			return studentService.findByAgeWithCityGroup(11, 20, city);
		else if(age==3)
			return studentService.findByAgeWithCityGroup(21, 30, city);
		else
			return null;
    }
	
	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public @ResponseBody ModelAndView register(@ModelAttribute Student student,@ModelAttribute("reqUser") Student reqUser) {
		ModelAndView andView = new ModelAndView("userdata.html");
		andView.addObject("user",student);
		studentService.save(reqUser);
		return andView;
    }

	@RequestMapping("/showStudent2/{age}")
    public ModelAndView show1(@PathVariable int age) {
		ModelAndView modelAndView = new ModelAndView("showResultAge");
		if(age==1) 
			modelAndView.addObject("students", studentService.findByAgeGroup(1,10));
		else if(age==2)
			modelAndView.addObject("students", studentService.findByAgeGroup(11,20));
		else if(age==3)
			modelAndView.addObject("students", studentService.findByAgeGroup(20,30));
		 return modelAndView;
    }
	
}
