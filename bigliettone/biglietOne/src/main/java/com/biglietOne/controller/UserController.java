package com.biglietOne.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biglietOne.models.User;
import com.biglietOne.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String home(HttpSession session) {
		if(session.getAttribute("username") != null) {
			session.invalidate();
		}
		return "index.html";
	
	}
	
	@RequestMapping(path = "/loginPage", method = RequestMethod.GET)
    public String logoutUtente(HttpSession session) {
        
        return "loginPage.html";
    }
	
	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public String loginDipendenti(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		User c = uService.checkUser(username, password);
		if(c != null) {
			session.setAttribute("email", c.getEmail());
			return "areaUtente.html";
		} else {
			session.setAttribute("errore", "Username o password errata");
			return "loginPage.html";
		}	
	}
	
	

}
