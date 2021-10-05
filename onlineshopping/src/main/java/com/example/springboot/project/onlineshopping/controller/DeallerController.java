package com.example.springboot.project.onlineshopping.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.project.onlineshopping.entity.Dealler;
import com.example.springboot.project.onlineshopping.service.DeallerService;

@Controller

public class DeallerController {

	@Value("$(uploadDir)")
	private String uploadFolder;
	
	@Autowired
	DeallerService deallerService;
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	
	
	
	@RequestMapping("/")
	public String viewDealler(Model model) {
		List<Dealler> deallerList =  deallerService.getAllDealler();
		model.addAttribute("deallerList", deallerList);
		return "index";
	}
	/*
	@PostMapping("/file")
    public String uploadFile(@RequestParam("myfile") MultipartFile myfile) throws IOException {
        System.out.println("Image Size in Bytes - " + myfile.getBytes().length);
        Dealler obj = new Dealler();
        obj.setProduct_name(myfile.getOriginalFilename());
        obj.setProduct_description(myfile.getContentType());
        obj.setImage(myfile.getBytes());
        deallerService.saveDealler(obj);
        return "new_dealler";
    }
	*/
	
	@RequestMapping("/new")
	public String viewNewDeallerPage(Model model , MultipartFile file)throws IOException {
		Dealler dealler = new Dealler();
		model.addAttribute("dealler", dealler);
		return "new_dealler";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//@PostMapping("/save")
	public String saveDealler(@ModelAttribute("dealler") Dealler dealler) {
		deallerService.saveDealler(dealler);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditDealler(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_dealler");
		Dealler dealler = deallerService.getDeallerByid(id);
		mav.addObject("dealler", dealler);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable(name = "id") int id) {
		deallerService.deleteDealler(id);
		return "redirect:/";		
	}
}
