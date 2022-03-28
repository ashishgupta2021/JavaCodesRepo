package com.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.model.Employee;


public class PdfView extends AbstractPdfView	{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Employee> employees = (List<Employee>) model.get("employees");
		
		Table table = new Table(3);
		table.addCell("First Name");
		table.addCell("Last Name");
		table.addCell("salary");
		
		for(Employee employee : employees) {
			table.addCell(employee.getFirstName());
			table.addCell(employee.getLastName());
			table.addCell(String.valueOf(employee.getSalary()));
		}
		
		document.add(table);
	}

	

}
