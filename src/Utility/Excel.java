package Utility;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Dao.ImplOrder;
import Model.Order;
import Model.Record;

public class Excel {
	private String filePath;
	private String[] fields_1;
	private String[] fields_2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Excel(String filePath) {
		super();
		this.filePath = filePath;
	}

	public void setFields(String[] fields_1, String[] fields_2) {
		this.fields_1 = fields_1;
		this.fields_2 = fields_2;
	}
	
	public void showFields() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFCellStyle center = workbook.createCellStyle(); 
		center.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFSheet sheet=workbook.createSheet("orders");
		
		XSSFRow row = sheet.createRow(0);
		int i=0;
		for(i=0;i<fields_1.length;i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(center);
			cell.setCellValue(fields_1[i]);
		}
		
		for(int j=0;j<fields_2.length;j++) {
			XSSFCell cell = row.createCell(j+i);
			cell.setCellStyle(center);
			cell.setCellValue(fields_2[j]);
		}
		
		workbook.write(outputStream);
		outputStream.close();
	}
	
	public void save(List<Order> orders) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
		XSSFCellStyle center = workbook.createCellStyle(); 
		center.setAlignment(HorizontalAlignment.CENTER);
		XSSFCellStyle right = workbook.createCellStyle(); 
		right.setAlignment(HorizontalAlignment.RIGHT);
		XSSFCellStyle highlight = workbook.createCellStyle(); 
		highlight.setFillForegroundColor(IndexedColors.AQUA.YELLOW.getIndex());;
		highlight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		//System.out.println("sheet.getColumnWidth(1): "+sheet.getColumnWidth(1));
		sheet.setColumnWidth(0, 3072);
		sheet.setColumnWidth(1, 3072);
		sheet.setColumnWidth(3, 3072);
		sheet.setColumnWidth(5, 3072);
		int rowNUm = sheet.getLastRowNum() + 1;
		int sum = 0;
		XSSFRow row = sheet.createRow(rowNUm++);
		
		for(Order o:orders) {
			XSSFCell cell = row.createCell(0);
			cell.setCellStyle(center);
			cell.setCellValue(o.getDate().toString());
			cell = row.createCell(1);
			cell.setCellStyle(right);
			cell.setCellValue(o.getOrderNumber());
			cell = row.createCell(2);
			cell.setCellStyle(center);
			//System.out.println("收銀員："+o.getCashier());
			cell.setCellValue(o.getCashier());
			cell = row.createCell(3);
			//cell.setCellStyle(center);
			cell.setCellValue(o.isMember());
			cell = row.createCell(4);
			cell.setCellStyle(right);
			cell.setCellValue(o.getTotal());
			sum += o.getTotal();
			List<Record> records = o.getRecords();
			for(Record r:records) {
				//row = sheet.createRow(rowNUm++);
				for(int c=0;c<7;c++) {
					System.out.println("save c="+c);
					cell = row.createCell(5+c);
					switch(c) {
						case 0:
							//System.out.println("save name="+r.getName());
							cell.setCellStyle(center);
							cell.setCellValue(r.getName());
							break;
						case 1:
							//System.out.println("save capacity="+r.getCapacity());
							cell.setCellStyle(center);
							cell.setCellValue(r.getCapacity());
							break;
						case 2:	
							//System.out.println("save price="+r.getPrice());
							cell.setCellStyle(right);
							cell.setCellValue(r.getPrice());
							break;	
						case 3:	
							//System.out.println("save sugar="+r.getSugar());
							cell.setCellStyle(center);
							cell.setCellValue(r.getSugar());
							break;
						case 4:	
							//System.out.println("save ice="+r.getIce());
							cell.setCellStyle(center);
							cell.setCellValue(r.getIce());
							break;	
						case 5:	
							cell.setCellStyle(right);
							cell.setCellValue(r.getQuantity());
							break;	
						case 6:	
							cell.setCellValue(r.getSubtotal());
							break;	
						default:	
					}
				}
				row = sheet.createRow(rowNUm++);
			}
			cell = row.createCell(3);
			cell.setCellStyle(center);
			cell.setCellStyle(highlight);
			cell.setCellValue("銷售金額:");
			cell = row.createCell(4);
			cell.setCellStyle(right);
			cell.setCellStyle(highlight);
			cell.setCellValue(sum);
		}
		
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		outputStream.close();
	}
}
