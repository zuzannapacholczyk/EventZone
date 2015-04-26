package controller;

import java.security.Principal;
import java.util.List;

import model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import output.EventInfoForParticipant;
import service.EventManager;
import service.ParticipantManager;

@Controller
@SessionAttributes
public class LoginPage {

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ModelAndView
	 * getMainPage() {
	 * 
	 * ModelAndView model = new ModelAndView("index");
	 * 
	 * return model; }
	 */

	@Autowired
	private ParticipantManager participantManager;

	@Autowired
	private EventManager eventManager;

	@RequestMapping(value = "/listForParticipant", method = RequestMethod.GET)
	public String listEventsForParticipant(final ModelMap model,
			final String username) {
		List<EventInfoForParticipant> listEventsForParticipant = this.participantManager
				.getEventsForParticipant(username);
		model.addAttribute("listEventsForParticipant", listEventsForParticipant);
		return "main_page";
	}

	@RequestMapping(value = "/listForOrganizer", method = RequestMethod.GET)
	public String listEventsForOrganizer(final ModelMap model,
			final Principal principal) {
		String username = principal.getName();
		List<Event> listEventsForOrganizer = this.eventManager
				.getAllEventsByOrganizer(username);
		model.addAttribute("listEventsForOrganizer", listEventsForOrganizer);
		return "main_page";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model, final Principal principal) {

		String name = principal.getName();
		model.addAttribute("username", name);
		return "redirect:/listForParticipant";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public ModelAndView loginError() {

		ModelAndView model = new ModelAndView("index");
		model.addObject("error",
				"Incorrect login name or password. Please try again!");

		return model;
	}
}
