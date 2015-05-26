package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
 
	
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Bartek") String name) {
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}