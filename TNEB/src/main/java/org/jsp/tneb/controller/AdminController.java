package org.jsp.tneb.controller;

import org.jsp.tneb.dao.AdminDao;
import org.jsp.tneb.dto.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = "{u}")
public class AdminController {
	@Autowired
	private AdminDao dao;

	@RequestMapping(value = "/adminlogin")
	public ModelAndView adminLogin(@RequestParam long phone,@RequestParam String password) {
		Admin admin = dao.login(phone, password);
		ModelAndView view = new ModelAndView();
		if (admin != null) {
			view.addObject("u", admin);
			view.setViewName("admin.jsp");
			return view;
		} else {
			view.addObject("msg", "***Invalid Phone Or Password***");
			view.setViewName("login.jsp");
			return view;
		}
	}
	@RequestMapping(value = "/adminregister")
	public ModelAndView adminRegister(@ModelAttribute Admin admin, ModelAndView view) {
		view.setViewName("print.jsp");
		admin =dao.register(admin);
		view.addObject("msg", "Admin Account has Created with the Id: "+admin.getId());
		return view;
	}
}
