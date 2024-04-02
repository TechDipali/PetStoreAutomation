package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import groovyjarjarpicocli.CommandLine.IFactory;




public class XLUtility
{
	public FileInputStream fi;
	public FileOutputStream fO;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;


	public XLUtility(String path) 
	{
		this.path=path;
	}

	public int getRowCount(String SheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet = workbook.getSheet(SheetName);
		int  rowCount=sheet.getLastRowNum();

		workbook.close();
		fi.close();

		return rowCount;

	}
	
	public int getCellCount(String SheetName, Integer RowNum) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		workbook.getSheet(SheetName);
		row=sheet.getRow(RowNum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();

		return cellCount;

	}
	
	public String getCellData(String SheetName, Integer RowNum, int column) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		workbook.getSheet(SheetName);
		row=sheet.getRow(RowNum);
		cell=row.getCell(column);
		
		DataFormatter  formater=new DataFormatter();
		String data;
		
		
		try
		{
			data=formater.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		
		workbook.close();
		fi.close();

		return data;

	}
	
	public void setCellData(String SheetName, Integer RowNum, int column, String data) throws IOException 
	{
		File xFile=new File(path);
		
		if(xFile.exists()) 
		{
			workbook=new XSSFWorkbook();
			fO=new FileOutputStream(path);
			workbook.write(fO);
		}
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(SheetName)==-1) 
		workbook.createSheet(SheetName);
		sheet=workbook.getSheet(SheetName);
		
		if(sheet.getRow(RowNum)==null)
			sheet.createRow(RowNum);
		 	row=sheet.getRow(RowNum);
			
		 	cell=row.createCell(column);
		 	cell.setCellValue(data);
		 	fO=new FileOutputStream(path);
		 	workbook.write(fO);
		 	workbook.close();
		 	fi.close();
		 	fO.close();
		 	
	}
	
	
	
	
}











