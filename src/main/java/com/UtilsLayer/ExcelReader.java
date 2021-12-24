package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
public FileInputStream fis;
public XSSFWorkbook workbook;

	
	public ExcelReader(String filePath) {
		File f =new File(filePath);
		try {
		 fis =new FileInputStream(f);
		 workbook =new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getData(int sheetIndex, int row, int col) {
		XSSFSheet sheet =workbook.getSheetAt(sheetIndex);
		String data =sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public int countTotalRows(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum();
	}
	
	public int countTotalColumn(int sheetIndex) {
		XSSFSheet sheet1 =workbook.getSheetAt(sheetIndex);
		int cells=sheet1.getRow(0).getLastCellNum();
		return cells;
	}
	
	
	
	
	
	
}
