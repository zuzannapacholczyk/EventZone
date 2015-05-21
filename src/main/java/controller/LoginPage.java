package controller;

import java.security.Principal;
import java.util.List;

import model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/main")
@SessionAttributes
public class LoginPage {

	
	 

	@Autowired
	private ParticipantManager participantManager;

	@Autowired
	private EventManager eventManager;

	@RequestMapping(value = "listForParticipant", method = RequestMethod.GET)
	public String listEventsForParticipant() {
		ModelMap model = new ModelMap();
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userP: "+username);
		List<EventInfoForParticipant> listEventsForParticipant = 
				participantManager.getEventsForParticipant(username);
		
		model.addAttribute("listEventsForParticipant", listEventsForParticipant);
		return "main_page";
	}

	@RequestMapping(value = "listForOrganizer/", method = RequestMethod.GET)
	public String listEventsForOrganizer(final ModelMap model,
			final Principal principal) {
		String username = principal.getName();
		List<Event> listEventsForOrganizer = this.eventManager
				.getAllEventsByOrganizer(username);
		model.addAttribute("listEventsForOrganizer", listEventsForOrganizer);
		return "main_page";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("user: "+username);
		
		return "redirect:/main/listForParticipant";

	}

	
}
