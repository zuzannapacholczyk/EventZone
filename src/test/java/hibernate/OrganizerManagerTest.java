package hibernate;

import java.util.ArrayList;
import java.util.List;

import model.Event;

import org.springframework.util.Assert;

import service.EventManager;
import junit.framework.TestCase;

public class OrganizerManagerTest extends TestCase{
	public void testGettingAllEvents() {
		EventManager eventManager = new EventManager();
		List<Event> result = new ArrayList<Event>();
		result = eventManager.getAllEventsByOrganizer("zuzanna");
		Assert.notEmpty(result);
	}
}
