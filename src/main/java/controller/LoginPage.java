package controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes
public class LoginPage {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMainPage() {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model, final Principal principal) {

		String name = principal.getName();
		model.addAttribute("username", name);
		return "main_page";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError() {

		ModelAndView model = new ModelAndView("index");
		model.addObject("error", "Incorrect login name or password. Please try again!");

		return model;
	}
}
