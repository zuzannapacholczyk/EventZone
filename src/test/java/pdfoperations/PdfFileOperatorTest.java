package pdfoperations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Event;
import output.ParticipantForOrganizer;
import junit.framework.TestCase;

public class PdfFileOperatorTest extends TestCase {

	public void testCreatingFile() {
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.createFile();
	}

	public void testCreatingListOfParticipants() {
		@SuppressWarnings("deprecation")
		Event event = new Event("Sting concert", new Date(2015, 11, 10),
				"Nice event", "Sting management", "Wroclaw",
				"You have to be there", "C:\\picture.jpg");
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.createListOfParticipants(createListOfParticipants(), event);
	}

	private List<ParticipantForOrganizer> createListOfParticipants() {
		List<ParticipantForOrganizer> resultList = new ArrayList<ParticipantForOrganizer>();
		ParticipantForOrganizer participant = new ParticipantForOrganizer(
				"zuzanna", "zuzanna", "nowak", "zu@zu", 140);
		resultList.add(participant);
		participant = new ParticipantForOrganizer("bartek", "bartek", "nowak",
				"bartek@zu", 200);
		resultList.add(participant);
		return resultList;
	}
}
