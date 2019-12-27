package com.rest.java.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.rest.java.dto.DoctorDto;
import com.rest.java.dto.PatientDto;

public class PatientPdfDocumentView {

	public static ByteArrayInputStream patientPdfReport(PatientDto patient, DoctorDto doctor) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// Add Text to PDF file ->
		try {
			PdfWriter writer=PdfWriter.getInstance(document, out);
			document.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 18, BaseColor.DARK_GRAY);
			Paragraph para = new Paragraph(  " Hospital Management System", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			Chunk linebreak = new Chunk(new LineSeparator());
			document.add(linebreak);
			Paragraph para1=new Paragraph("Discharge Summary",new Font(Font.FontFamily.TIMES_ROMAN,14, Font.BOLDITALIC));
			para1.setAlignment(Element.ALIGN_CENTER);
			document.add(para1);
									
			// Create Paragraph
			Paragraph paragraph = new Paragraph("Patient Details",
					new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD));
			//paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(linebreak);					 
			paragraph.add(new Paragraph("Patient id: " + patient.getPid()));
			
			
			
			paragraph.add(new Paragraph("Name: "+ patient.getName()+"                                         "+
								  		"Age : "+patient.getAge()+" Years                                    "+
										"Gender:  "+patient.getGender()));
			paragraph.add(new Paragraph("Blood Group: " + patient.getBloodGroup()+"                                  "+
				                     	"Disease: " + patient.getDiseases()));
			paragraph.add(new Paragraph("Address: "+patient.getAddress()));
			paragraph.add(new Paragraph("Admit Date:  " + patient.getAdmitDate()+"                                                                 "+
										"Discharge Date: "+patient.getDischargeDate()));
			
			document.add(paragraph);
			Paragraph paragraph1=new Paragraph("Doctor Details",
					new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD));
			paragraph1.add(linebreak);
			paragraph1.add(new Paragraph("Doctor's Name: Dr."+doctor.getName()+" ("+doctor.getDeparment().toUpperCase()+")"));
			document.add(paragraph1);
			document.add(linebreak);
			document.add(new Paragraph(new Date().toString()));
			
			  Barcode128 barcode128 = new Barcode128(); 
			  barcode128.setCode(patient.getName());
			  barcode128.setCodeType(Barcode.CODE128); Image code128Image =
			  barcode128.createImageWithBarcode(writer.getDirectContent(), null, null);
			  document.add(code128Image);
			 
			/*
			 * BarcodeQRCode barcodeQRCode = new BarcodeQRCode("Rasool:) Happy New Year",
			 * 1000, 1000, null); Image codeQrImage = barcodeQRCode.getImage();
			 * codeQrImage.scaleAbsolute(100, 100); document.add(codeQrImage);
			 */
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return new ByteArrayInputStream(out.toByteArray());

	}

}
