package controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import output.EventInfoForParticipant;
import service.ParticipantManager;

@Controller
@SessionAttributes
public class LoginPage {

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ModelAndView getMainPage() {
	 *
	 * ModelAndView model = new ModelAndView("index");
	 *
	 * return model; }
	 */

	@Autowired
	private ParticipantManager participantManager;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEvents(final ModelMap model, final String username) {
		List<EventInfoForParticipant> listEvents = this.participantManager.getEventsForParticipant(username);
		model.addAttribute("listEvents", listEvents);
		return "main_page";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model, final Principal principal) {

		String name = principal.getName();
		model.addAttribute("username", name);
		return "redirect:/list";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError() {

		ModelAndView model = new ModelAndView("index");
		model.addObject("error", "Incorrect login name or password. Please try again!");

		return model;
	}
}
