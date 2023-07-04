package actitime.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Rishav\\Downloads\\selenium\\Book.PROPERTIES");
		Properties pojb=new Properties();
		pojb.load(fis);
		String value=pojb.getProperty(key);
		return value;
		
		
	}
	public String getDataFromExcelSheet(String Sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Rishav\\Downloads\\selenium\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
	     Sheet ss=book.getSheet(Sheetname);
	     DataFormatter format=new DataFormatter();
	     String value=format.formatCellValue(ss.getRow(rownum).getCell(cellnum));
	     return value;
	     
	
	}
	
	}

