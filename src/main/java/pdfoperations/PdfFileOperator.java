package pdfoperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import model.Event;
import output.ParticipantForOrganizer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author ZPACHOLC
 *
 */
public class PdfFileOperator {

	public void createFile() {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("HelloWorld.pdf"));
			document.open();
			document.add(new Paragraph("A Hello World PDF document."));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void createListOfParticipants(
			List<ParticipantForOrganizer> participants, Event event) {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.valueOf(event.getId())
							+ event.getName() + ".pdf"));
			document.open();
			document.add(new Paragraph("Event: " + event.getName() + "\tDate: "
					+ String.valueOf(event.getDateOfEvent()) + "\tPlace: "
					+ event.getPlace()));
			document.add(new Paragraph("Participants:"));
			try {
				PdfPTable table = new PdfPTable(4); // 3 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				float[] columnWidths = { 1f, 1f, 1f, 1f };
				table.setWidths(columnWidths);
				PdfPCell nameCell = new PdfPCell(new Paragraph("Name"));
				nameCell.setPaddingLeft(10);
				nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell mailCell = new PdfPCell(new Paragraph("Email"));
				mailCell.setPaddingLeft(10);
				mailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell ticketPriceCell = new PdfPCell(new Paragraph(
						"Ticket cost"));
				ticketPriceCell.setPaddingLeft(10);
				ticketPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				ticketPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell signatureCell = new PdfPCell(
						new Paragraph("Signature"));
				signatureCell.setPaddingLeft(10);
				signatureCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				signatureCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
		        table.addCell(nameCell);
		        table.addCell(mailCell);
		        table.addCell(ticketPriceCell);
		        table.addCell(signatureCell);

				for (ParticipantForOrganizer participant : participants) {
					nameCell = new PdfPCell(new Paragraph(participant.getName()
							+ " " + participant.getSurname()));

					mailCell = new PdfPCell(new Paragraph(
							participant.getEmail()));

					ticketPriceCell = new PdfPCell(new Paragraph(
							String.valueOf(participant.getTicketCost())));

					signatureCell = new PdfPCell(new Paragraph());
			        table.addCell(nameCell);
			        table.addCell(mailCell);
			        table.addCell(ticketPriceCell);
			        table.addCell(signatureCell);
				}
				document.add(table);
			} catch (NullPointerException e) {
			}

			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
