package com.telusko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.Response.Response;
import com.telusko.model.Student;
import com.telusko.service.StudentService;

@Controller
public class IndexController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
    public String root(Model model) {
		model.addAttribute("reqUser", new Student());
        return "reg.html";
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
	
	@RequestMapping("/showStudent1/{start}")
    public ModelAndView show1(@PathVariable int start) {
		List<Student> cust = new ArrayList<Student>();
		ModelAndView modelAndView = new ModelAndView("showResultAge");
		if(start==1) {
			modelAndView.addObject("students", studentService.findByAgeGroup(1,10));
			//cust=studentService.findByAgeGroup(1, 10);
		}else if(start==2) {
			modelAndView.addObject("students", studentService.findByAgeGroup(11,20));
			//cust=studentService.findByAgeGroup(1, 10);
		}else if(start==3) {
			modelAndView.addObject("students", studentService.findByAgeGroup(20,30));
			//cust=studentService.findByAgeGroup(1, 10);
		}
		Response response = new Response("Done", cust);
		return modelAndView;
    }
	
	@RequestMapping("/showStudent/{start}")
	@ResponseBody
    public List<Student> rest(@PathVariable int start) {
		if(start==1) {
			return studentService.findByAgeGroup(1, 10);
		}else if(start==2) {
			return studentService.findByAgeGroup(11, 20);
		}else if(start==3) {
			return studentService.findByAgeGroup(21, 30);
		}else {
			return null;
		}
	}
	
	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public @ResponseBody ModelAndView register(@ModelAttribute Student student,@ModelAttribute("reqUser") Student reqUser) {
		
		ModelAndView andView = new ModelAndView("userdata.html");
		andView.addObject("user",student);
		// Create Response Object
		com.telusko.Response.Response response = new com.telusko.Response.Response("Done", student);
		studentService.save(reqUser);
		return andView;
    }

}
