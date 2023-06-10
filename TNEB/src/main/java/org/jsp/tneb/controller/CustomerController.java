package org.jsp.tneb.controller;

import javax.persistence.EntityManager;

import org.jsp.tneb.dao.CustomerDao;
import org.jsp.tneb.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;

	@RequestMapping(value = "/consumerregister")
	public ModelAndView userRegister(@ModelAttribute Customer user, ModelAndView view) {
		view.setViewName("print2.jsp");
		user = dao.register(user);
		view.addObject("msg", "Customer Account created with the Id: " + user.getId());
		return view;
	}

	@RequestMapping(value = "/userlogin")
	public ModelAndView userLogin(ModelAndView view, @RequestParam long consumernumber) {
		Customer user = dao.login(consumernumber);
		if (user != null) {
			view.addObject("msg", "Login Successful with the Customer Id: " + user.getId());
			view.setViewName("print3.jsp");
			return view;
		} else {
			view.addObject("msg", "***Invalid Phone Or Password***");
			view.setViewName("login.jsp");
			return view;
		}
	}

	@RequestMapping(value = "/viewbill")
	public ModelAndView viewBill(@ModelAttribute Customer user, ModelAndView view, @RequestParam int id) {
		user = dao.bill(id);
		if (user != null) {
			view.addObject("msg", "Your Bill amount is: " + user.getBill());
			view.setViewName("print4.jsp");
			return view;
		} else {
			view.addObject("msg", "***Invalid Phone Or Password***");
			view.setViewName("bill.jsp");
			return view;
		}
	}
}
