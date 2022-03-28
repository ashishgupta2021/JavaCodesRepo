package com.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.model.Employee;

public class ExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		String fileName =  "employee" +strDate+".xls";
		
		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		
		List<Employee> employees = (List<Employee>) model.get("employees");
		
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Spring MVC AbstractXlsView");
		
        // create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("First Name");
		header.createCell(1).setCellValue("Last Name");
		header.createCell(2).setCellValue("Salary");
		
		int rowCount = 1;
		for(Employee employee : employees)	{
			Row employeeRow = sheet.createRow(rowCount++);
			employeeRow.createCell(0).setCellValue(employee.getFirstName());
			employeeRow.createCell(1).setCellValue(employee.getLastName());
			employeeRow.createCell(2).setCellValue(employee.getSalary());
		}

		
		
	}

}
