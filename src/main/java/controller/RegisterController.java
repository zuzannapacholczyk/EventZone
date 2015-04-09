package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import exceptions.CreateAccountException;
import service.UserManager;

@Controller
@RequestMapping("/register/")
@SessionAttributes
public class RegisterController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRegisterPage() {

		ModelAndView model = new ModelAndView("RegisterViews/register");
		model.addObject("userForm", new User());
		return model;
	}

	@RequestMapping(value = "registerUser/", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@ModelAttribute("userForm") final User user,
			final BindingResult result) {

		ModelAndView model = new ModelAndView("RegisterViews/registerOutcome");

		// mamy pewność ze service działa czyli andotacja @Autowired
		// dopasowała bean
		// z pliku dispatcher-servlet.xml do pola userManager powyżej
		// w celach debugowania mozna to tutaj zostawic :P
		userManager.testService();
		User newUser = user;
		System.out.println(" user info: " + newUser.toString());

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
