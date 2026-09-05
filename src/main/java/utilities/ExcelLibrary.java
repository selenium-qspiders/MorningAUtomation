package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary
{
	public static String getStringCellValue(String sheet, int row, int cell) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(p.getProperty("excelpath"));
		p.load(fis);
		Workbook wb=new XSSFWorkbook(fis);
		String cellvalue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return cellvalue;
	}
}