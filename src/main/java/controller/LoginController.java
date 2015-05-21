package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	String errorMsg = "Incorrect login name or password. Please try again!";
	
	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView getMainPage() {
	
		
		ModelAndView model = new ModelAndView("index");
		  
		return model; 
	}
	 
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError() {

		ModelAndView model = new ModelAndView("index");
		model.addObject("error", errorMsg);

		return model;
	}
}
