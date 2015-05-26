package controller;

import model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import exceptions.CreateEventException;
import service.EventManager;


@Controller
@RequestMapping("/main")
public class EventController {
	
	@Autowired
	private EventManager eventManager;
	
	@RequestMapping("event/{id}")
	public ModelAndView getSingleEventPage(@PathVariable String id){
		ModelAndView model = new ModelAndView("event/singleEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		Event event = eventManager.getEventById(id);
		
		model.addObject("eventName", event.getName());
		model.addObject("username", username);
		return model; 
	}
	
	@RequestMapping("event/create")
	public ModelAndView getSingleEventPage(){
		ModelAndView model = new ModelAndView("event/createEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addObject("username", username);
		model.addObject("eventForm", new Event());
		return model; 
	}
	
	@RequestMapping(value = "createEvent", method = RequestMethod.POST)
	public ModelAndView createEvent(@ModelAttribute("eventForm") final Event event, final BindingResult result, final RedirectAttributes redir) {

		ModelAndView model = null;
		Event newEvent = event;
		try {
			eventManager.saveEvent(newEvent);
		} catch (CreateEventException e) {
			model = new ModelAndView("redirect:/main/event/create?fail=true");
			redir.addFlashAttribute("createEventFailureMsg", e.getMessage());
			System.out.println("Ex msg: " + e.getMessage());
			return model;
		}
		model = new ModelAndView("redirect:/listForOrganizer/");
		redir.addFlashAttribute("successMsg", "Your event has been created!");
		return model;

	}
}
