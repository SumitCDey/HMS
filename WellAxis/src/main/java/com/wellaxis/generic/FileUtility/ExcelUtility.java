package com.wellaxis.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFileCell(String sheetname, int rownum, int cellnum,String path) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String value=	wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;

	}
private void setDataIntoExcelFile(String sheetname, int rownum, int cellnum, String path) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(path);
	FileOutputStream fos= new FileOutputStream(path);
	wb.write(fos);
	wb.close();
}


	
	
}
