package vtiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This methode help us to read the data from the excel file 
 * @author hp
 *
 */
public class ExcelUtility {
	public String GetExcelValue(String sheetname, int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(AutoconstantUtility.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
	}
	/**
	 * This methode will read multiple data into the dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataIntoDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(AutoconstantUtility.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sn = wb.getSheet(sheetName);
		int Lastrowno = sn.getLastRowNum();
		int Lastcellno = sn.getRow(0).getLastCellNum();
		Object[][] data =new Object[Lastrowno][Lastcellno];
		for(int i=0;i<Lastrowno;i++)
		{
			for(int j=0;j<Lastcellno;j++)
			{
				data[i][j]=sn.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}

}

 