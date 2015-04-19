package output;


import java.util.Date;

import model.Event;

public class EventInfoForParticipant {

	private float cost;
	private Event event;

	public EventInfoForParticipant(float cost, String name, Date dateOfEvent, String subtitle,
			String organizer, String place, String description, String picture) {
		this.cost = cost;
		this.event = new Event(name, dateOfEvent, subtitle, organizer, place, description,
				picture);
	}

	public EventInfoForParticipant(float cost, Event event) {
		this.cost = cost;
		this.event = event;
		this.event.setName(event.getName());
		this.event.setDescription(event.getDescription());
		this.event.setSubtitle(event.getSubtitle());
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
