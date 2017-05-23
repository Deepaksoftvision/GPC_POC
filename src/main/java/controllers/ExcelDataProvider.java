package controllers;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ExcelDataProvider extends InitMethod
{
	static ApplicationConfiguration appConfig = new ApplicationConfiguration();
	public static String excel_filepath = appConfig.getFilePath();
	
	@DataProvider(name="multiSheetExcelRead")
	public static Object[][] multiSheetExcelRead(Method method) throws Exception
	{
		File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
		String SheetName = method.getName();
		System.out.println(SheetName);
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
		return testObjArray;
	}

	@DataProvider(name="excelSheetNameAsMethodName")
	public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
	{
		File file = new File("./src/test/resources/Excel Files/"+method.getName()+".xlsx");
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
		return testObjArray;
	}


	@DataProvider(name="standardBillingMay18")
	public static Object[][] standardBillingMay18(Method method) throws Exception
	{
		File file = new File(excel_filepath);
		System.out.println(file);
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
		return testObjArray;
	}
}
