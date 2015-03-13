package model;

import java.io.Serializable;

/**
 * @author Zu
 *
 */
public class Participant implements Serializable {
	private int id;
	private int eventId;
	private String personId;
	private int ifPaid;
	private int ticketId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public int getIfPaid() {
		return ifPaid;
	}

	public void setIfPaid(int ifPaid) {
		this.ifPaid = ifPaid;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
}
