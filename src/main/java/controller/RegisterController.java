package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UserManager;
import exceptions.CreateAccountException;

@Controller
@RequestMapping("/register/")
public class RegisterController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {

		ModelAndView model = new ModelAndView("RegisterViews/register");

		return model;
	}

	@RequestMapping(value = "registerUser/", method = RequestMethod.POST)
	public ModelAndView registerUser() {

		ModelAndView model = new ModelAndView("RegisterViews/registerOutcome");

		// mamy pewność ze service działa czyli andotacja @Autowired dopasowała bean
		// z pliku dispatcher-servlet.xml do pola userManager powyżej
		// w celach debugowania mozna to tutaj zostawic :P
		userManager.testService();
		User newUser = new User();
		// System.out.println(" user info: " + newUser.toString());

		try {
			userManager.saveUser(newUser);
		} catch (CreateAccountException e) {
			model.addObject("whyFailureMsg", e.getMessage());
			model.addObject("success", false);
			return model;
		}

		model.addObject("successMsg", "Your account has been created!");
		model.addObject("success", true);
		return model;

	}
}
