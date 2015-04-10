package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes
public class LandingPage {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMainPage() {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

}
