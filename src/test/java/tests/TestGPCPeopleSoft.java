package tests;

import org.testng.annotations.Test;

import controllers.ApplicationConfiguration;
import controllers.ExcelDataProvider;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Description;

public class TestGPCPeopleSoft extends PageFactoryInitializer {
	ApplicationConfiguration appConfig = new ApplicationConfiguration();

	@Description("To Test the Login Functionlaity Of the GPC People Soft Page")
	@Test(priority = 0)
	public void TC_POC_001() 
	{
		loginPage().login(appConfig.getUserName(), appConfig.getPassword());
	}

	@Description("To Add New Value")
	@Test(dataProvider="standardBillingMay18",dataProviderClass=ExcelDataProvider.class)
	public void TC_POC_002(String BusinessUnit, String Date, String Customer, String Identifier,
			String Description, String Quantity,String UnitPrice, String Extended, String Account, 
			String OperatingUnit,String Department, String Product, String Affiliate, String	State_Prov, 
			String SubAccount, String Project, String Code, String note,String Invoice, 
			String SPI_Comments) throws Exception
	{
		loginPage()
		.clickOnFavorities()
		.clickOnStandardBilling()
		.clickOnAddANewValueTab()
		//.enterBusinessUnit(BusinessUnit)
		.enterInvoice("NEXT")
		.enterBillTypeIdentifier("INV")
		.enterBillSource("APG")
		.enterCustomer(Customer)
		.enterInvoiceDate(Date)
		.enterAccountingDate(Date)
		.clickOnAddButton()
		.enterPayTerms("20PRX")
		.clickOnLineInfoTab()
		.enterIdentifier(Identifier)
		.enterDescription(Description)
		.enterQuantity(Quantity)
		.enterUOM("EA")
		.enterUnitPrice(UnitPrice)
		.clickOnAccounting()
		.enterAccount(Account)
		.enteroperatingUnit(OperatingUnit)
		.enterDept(Department)
		.enterProduct(Product)
		.enterSubAccount(SubAccount)
		.clickOnHeaderInfoTab()
		.clickOnNotes()
		.enterNotes(note)
		.clickOnSaveButton()
		.getInvoiceValue();
		Thread.sleep(10000);
	}


	/*
	 * @Test(dataProvider="standardBillingMay18",
	 * dataProviderClass=ExcelDataProvider.class) public void dummyTest(String
	 * BU, String Date, String Customer, String Identifier, String Description,
	 * String Quantity,String Price, String Extended, String Account, String
	 * Unit,String Department, String Product, String Affiliate, String
	 * State_Prov, String SubAccount, String Project, String Code, String
	 * note,String Invoice, String SPI_Comments) { System.out.println(BU + Date
	 * + Customer + Identifier + Description); }
	 */
}
