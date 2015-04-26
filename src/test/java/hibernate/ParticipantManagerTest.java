package hibernate;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.util.Assert;

import output.EventInfoForParticipant;
import output.ParticipantForOrganizer;
import service.ParticipantManager;

public class ParticipantManagerTest extends TestCase {

	public void testGettingInfoAboutEvents () {
		ParticipantManager participantManager = new ParticipantManager();
		List<EventInfoForParticipant> result = new ArrayList<EventInfoForParticipant>();
		result = participantManager.getEventsForParticipant("zuzanna");
		Assert.notEmpty(result);
	}
	
	public void testGettingInforAboutParticipants() {
		ParticipantManager participantManager = new ParticipantManager();
		List<ParticipantForOrganizer> result = new ArrayList<ParticipantForOrganizer>();
		result = participantManager.getAllParticipantsByEventId(1);
		Assert.notEmpty(result);
	}
}
