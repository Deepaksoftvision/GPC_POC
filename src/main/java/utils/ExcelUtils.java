package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils 
{
	private static HSSFSheet xlsxWorkSheet;
	private static HSSFWorkbook xlsxWorkBook;
	private static HSSFCell xlsxCell;
	@SuppressWarnings("unused")
	private static HSSFRow xlsxRow;

	public static void getExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
			File file = new File(Path);
			FileInputStream fis = new FileInputStream(file);
			xlsxWorkBook = new HSSFWorkbook(fis);
			xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);
		} 
		catch (Exception e)
		{
			throw (e);
		}
	}	
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception
	{   
		String[][] tabArray = null;
		try
		{
			File file = new File(FilePath);			
			FileInputStream ExcelFile = new FileInputStream(file);
			xlsxWorkBook = new HSSFWorkbook(ExcelFile);
			xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);

			int startRow = 2;
			int startCol = 0;
			int ci,cj;
			int totalRows = ExcelUtils.xlsxRowCount();
			int totalCols = ExcelUtils.xlsxColumnCount();
			tabArray=new String[totalRows-1][totalCols];
			ci=0;
			for (int i=startRow;i<totalRows;i++) 
			{           	   
				cj=0;
				for (int j=startCol;j<totalCols;j++)
				{
					tabArray[ci][cj]=getCellData(i,j);
					cj++;
				}
				ci++;
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}
	

	public static Object[][] getTableArray(String FilePath) throws Exception
	{   
		String[][] tabArray = null;
		try
		{
			File file = new File(FilePath);
			System.out.println(file);
			FileInputStream ExcelFile = new FileInputStream(file);
			System.out.println(ExcelFile);
			xlsxWorkBook = new HSSFWorkbook(ExcelFile);
			xlsxWorkSheet = xlsxWorkBook.getSheetAt(0);

			int startRow = 2;
			int startCol = 0;
			int ci,cj;
			int totalRows = ExcelUtils.xlsxRowCount();
			int totalCols = ExcelUtils.xlsxColumnCount();
			tabArray=new String[totalRows-1][totalCols];
			ci=0;
			for (int i=startRow;i<totalRows;i++) 
			{           	   
				cj=0;
				for (int j=startCol;j<totalCols;j++)
				{
					tabArray[ci][cj]=getCellData(i,j);
					cj++;
				}
				ci++;
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
			xlsxCell = xlsxWorkSheet.getRow(RowNum).getCell(ColNum);
			String CellData = xlsxCell.getStringCellValue();
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	public static int xlsxRowCount()
	{
		int rowNum = xlsxWorkSheet.getLastRowNum()+1;
		return rowNum;
	}
	
	public static int xlsxColumnCount()
	{
		int colNum = xlsxWorkSheet.getRow(0).getLastCellNum();
		return colNum;
	}
}