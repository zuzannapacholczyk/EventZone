package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.UserManager;
import exceptions.CreateAccountException;

@Controller
@RequestMapping("/register")
@SessionAttributes
public class RegisterController {

	String msg = null;

	@Autowired
	private UserManager userManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRegisterPage(@RequestParam(required = false) final boolean fail) {

		ModelAndView model = new ModelAndView("registration");
		model.addObject("userForm", new User());
		return model;
	}

	@RequestMapping(value = "registerUser/", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userForm") final User user, final BindingResult result,
			final RedirectAttributes redir) {

		ModelAndView model = null;

		// mamy pewność ze service działa czyli andotacja @Autowired
		// dopasowała bean
		// z pliku dispatcher-servlet.xml do pola userManager powyżej
		// w celach debugowania mozna to tutaj zostawic :P
		userManager.testService();
		User newUser = user;
		System.out.println("user info: " + newUser.toString());

		try {
			userManager.saveUser(newUser);
		} catch (CreateAccountException e) {
			// msg = e.getMessage();
			model = new ModelAndView("redirect:/register?fail=true");
			redir.addFlashAttribute("registerFailureMsg", e.getMessage());
			System.out.println("Ex msg: " + e.getMessage());
			return model;
		}

		model = new ModelAndView("redirect:/");
		redir.addFlashAttribute("successMsg", "Your account has been created!");
		return model;

	}
}
