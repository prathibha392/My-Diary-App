package com.mca.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mca.spring.mydiary.bussiness.EntryBussinessinterface;
import com.mca.spring.mydiary.bussiness.UserBussinessinterface;
import com.mca.spring.mydiary.entities.Entry;
import com.mca.spring.mydiary.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserBussinessinterface userBussinessinterface;
	
	@Autowired
	HttpSession session;
	
	public UserBussinessinterface getUserBussinessinterface() {
		return userBussinessinterface;
	}
	public void setUserBussinessinterface(UserBussinessinterface userBussinessinterface) {
		this.userBussinessinterface = userBussinessinterface;
	}
	
	
	@Autowired
	private EntryBussinessinterface entryBussinessinterface;
	
	
	public EntryBussinessinterface getEntryBussinessinterface() {
		return entryBussinessinterface;
	}
	public void setEntryBussinessinterface(EntryBussinessinterface entryBussinessinterface) {
		this.entryBussinessinterface = entryBussinessinterface;
	}
	
	
	@RequestMapping("home")
	public ModelAndView HomepageMethod()
	{
		ModelAndView model = new ModelAndView("loginpage");
		return model;
	}
	@RequestMapping("Register")
	public ModelAndView RegisterMethod()
	{
		ModelAndView model = new ModelAndView("registrationpage");
		return model;
	}
	
	
	@RequestMapping(value="saveuser",method=RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") User user)
	{
		//code for save user details in the database
		ModelAndView model = new ModelAndView("registersuccessfully");
		userBussinessinterface.save(user);
		return model;
	}
	
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user") User user)
	{
		ModelAndView model = new ModelAndView("loginpage");
		
		User user1 = userBussinessinterface.findByUsername(user.getUsername());
		if(user1!=null && user.getPassword().equals(user1.getPassword()))
		{
			model.setViewName("userhomepage");
			model.addObject("user", user1);
			
			session.setAttribute("user", user1);
			
			List<Entry> entries = null;
			
			try {
				entries = entryBussinessinterface.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addObject("entrieslist", entries);
		}
		return model;
	}
	
	@RequestMapping("addentry")
	public ModelAndView addentry()
	{
		ModelAndView model = new ModelAndView("addentryform");
		
		return model;
	}
	
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entry entry)
	{
		
		ModelAndView model = new ModelAndView("userhomepage");
		entryBussinessinterface.save(entry);
		
		User user1 = (User)session.getAttribute("user");
		
		List<Entry> entries = null;
	
		try {
			entries = entryBussinessinterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);
		return model;
		
	}
	
	@RequestMapping("viewentry")
	public ModelAndView viewentry(@RequestParam("id")int id)
	{
		ModelAndView model = new ModelAndView("displayentry");
		Entry entry = entryBussinessinterface.findById(id);
		model.addObject("entry", entry);
		
		return model;
	}
	
	@RequestMapping("userhome")
	public ModelAndView userhomepage()
	{
		ModelAndView model = new ModelAndView("userhomepage");
		User user1 = (User)session.getAttribute("user");
		
		List<Entry> entries = null;
		
		try {
			entries = entryBussinessinterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
	return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id") int id)
	{
		ModelAndView model = new ModelAndView("updateentry");
		Entry entry = entryBussinessinterface.findById(id);
		model.addObject("entry", entry);
		return model;
		
	}
	
	@RequestMapping("processentryupdate")
	public ModelAndView processentryupdate(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		entryBussinessinterface.update(entry);
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		
		try {
			entries=entryBussinessinterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		
		return model;
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id") int id)
	{
		ModelAndView model = new ModelAndView("userhomepage");
		
		User user1= (User)session.getAttribute("user");
		Entry entry = entryBussinessinterface.findById(id);
		
		if(user1==null)
			model.setViewName("userhomepage");
		else
			entryBussinessinterface.delete(entry);
		
		 List<Entry> entries=null;
			
			try {
				entries=entryBussinessinterface.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addObject("entrieslist", entries);
			
			return model;
	}
	
	@RequestMapping("signout")
	public ModelAndView signout()
	{
		
		ModelAndView model = new ModelAndView("loginpage");
		
		session.invalidate();
		
		
		return model;
	}
	
	
	
   
}
