/**
 * 
 */
package pageObjects.modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import controllers.ApplicationConfiguration;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.FluentWaiting;

/**
 * 
 */
public class PeopleSoftLoginPage extends PageFactoryInitializer
{
	@FindBy(id="userid")
	private WebElement UserID;

	@FindBy(id="pwd")
	private WebElement Password;

	@FindBy(xpath="//input[@name='Submit']")
	private WebElement SignIn;

	@FindBy(id="pthnavbca_MYFAVORITES")
	private WebElement Favorities_Menu;

	@FindBy(xpath="(//a[contains(text(),'Standard Billing')])[1]")
	private WebElement submenu_StandardBilling;

	@FindBy(xpath="//div[@id='win0divSEARCHMODE']/descendant::a[contains(text(),'Add a New Value')]")
	private WebElement tabs_AddNewValue;

	@FindBy(xpath="//tr[@role='tablist']/descendant::a[2]")
	private WebElement tabs_FindAnExistingValue;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[1]")
	private WebElement addNewValue_BusinessUnit;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[2]")
	private WebElement addNewValue_Invoice;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[3]")
	private WebElement addNewValue_BillTypeIdentifier;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[4]")
	private WebElement addNewValue_BillSource;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[5]")
	private WebElement addNewValue_Customer;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[6]")
	private WebElement addNewValue_InvoiceDate;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[7]")
	private WebElement addNewValue_AccountingDate;

	@FindBy(xpath="//td/label[contains(text(),'Business Unit:')]/following::input[8]")
	private WebElement addNewValue_Button_Add;

	@FindBy(xpath="//iframe[@id='ptifrmtgtframe']")
	private WebElement frame_AddANewValue;

	@FindBy(css="#ICTAB_0 span")
	private WebElement infoPage_Tabs_HeaderInfo;

	@FindBy(css="#ICTAB_1 span")
	private WebElement infoPage_Tabs_LineInfo;

	@FindBy(css="#BI_HDR_PYMNT_TERMS_CD")
	private WebElement infoPage_Fields_PayTerms;

	@FindBy(xpath="//a[@id='BI_PB_WRK_BI_HDR_NOTES_PB']")
	private WebElement infoPage_Fields_Notes;

	@FindBy(xpath="//input[@id='BI_LINE_IDENTIFIER$0']")
	private WebElement lineInfoTab_Identifier;

	@FindBy(xpath="//input[@id='DERIVED_WORK_BI_LINE_DESCR$0']")
	private WebElement lineInfoTab_Description;

	@FindBy(xpath="//input[@id='BI_LINE_QTY$0']")
	private WebElement lineInfoTab_Quantity;

	@FindBy(xpath="//input[@id='BI_LINE_UNIT_OF_MEASURE$0']")
	private WebElement lineInfoTab_UOM;

	@FindBy(xpath="//input[@id='BI_LINE_UNIT_AMT$0']")
	private WebElement lineInfoTab_UnitPrice;

	@FindBy(xpath="//a[contains(text(),'Accounting')]")
	private WebElement lineInfoTab_Accounting;

	@FindBy(xpath="//input[@id='ACCOUNT$0']")
	private WebElement revDistribution_Account;

	@FindBy(xpath="//input[@id='OPERATING_UNIT$0']")
	private WebElement revDistribution_OperatingUnit;

	@FindBy(xpath="//input[@id='DEPTID$0']")
	private WebElement revDistribution_Department;

	@FindBy(xpath="//input[@id='PRODUCT$0']")
	private WebElement revDistribution_Product;

	@FindBy(xpath="//input[@id='AFFILIATE$0']")
	private WebElement revDistribution_Affliate;

	@FindBy(xpath="//input[@id='CHARTFIELD1$0']")
	private WebElement revDistribution_StateProv;

	@FindBy(xpath="//input[@id='CHARTFIELD2$0']")
	private WebElement revDistribution_SubAccount;

	@FindBy(xpath="//input[@id='CHARTFIELD3$0']")
	private WebElement revDistribution_Project;

	@FindBy(xpath="//textarea[@id='DERIVED_WORK_BI_HDR_NOTE_TEXT$0']")
	private WebElement headerNotes_NotesTextArea;

	@FindBy(xpath="//input[@id='#ICSave']")
	private WebElement headerNotes_Save;

	@FindBy(xpath="//span[@id='BI_HDR_INVOICE']")
	private WebElement getInvoiceNumber;



	@Step("To Enter User ID, Password and Click SignIn Button")
	public PeopleSoftLoginPage login(String username, String password)
	{
		UserID.sendKeys(username);
		Password.sendKeys(password);
		SignIn.click();
		return this;
	}


	@Step("To Click on Favorities Menu")
	public PeopleSoftLoginPage clickOnFavorities() throws Exception
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, Favorities_Menu);
		Favorities_Menu.click();
		return this;
	}

	@Step("To Click on Standard Billing")
	public PeopleSoftLoginPage clickOnStandardBilling() throws Exception
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, submenu_StandardBilling);
		submenu_StandardBilling.click();
		return this;
	}

	@Step("To Click on Add a New Value Button")
	public PeopleSoftLoginPage clickOnAddANewValueTab() throws Exception
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(driver.findElement(By.xpath("//iframe[@id='ptifrmtgtframe']")));
		FluentWaiting.waitUntillElementToBeClickable(30, 500, tabs_AddNewValue);
		tabs_AddNewValue.click();
		switchOutOfFrame();
		return this;
	}


	public PeopleSoftLoginPage enterBusinessUnit(String businessUnit) throws Exception
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(frame_AddANewValue);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_BusinessUnit);
		addNewValue_BusinessUnit.clear();
		addNewValue_BusinessUnit.sendKeys(businessUnit);
		return this;
	}


	public PeopleSoftLoginPage enterInvoice(String string1) throws Exception 
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(frame_AddANewValue);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_Invoice);
		addNewValue_Invoice.clear();
		addNewValue_Invoice.sendKeys(string1);
		return this;
	}


	public PeopleSoftLoginPage enterBillTypeIdentifier(String string) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_BillTypeIdentifier);
		addNewValue_BillTypeIdentifier.clear();
		addNewValue_BillTypeIdentifier.sendKeys(string);
		return this;
	}


	public PeopleSoftLoginPage enterBillSource(String string) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_BillSource);
		addNewValue_BillSource.clear();
		addNewValue_BillSource.sendKeys(string);
		return this;
	}


	public PeopleSoftLoginPage enterCustomer(String customer) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_Customer);
		addNewValue_Customer.clear();
		addNewValue_Customer.sendKeys(customer);
		return this;
	}


	public PeopleSoftLoginPage enterInvoiceDate(String date) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_InvoiceDate);
		addNewValue_InvoiceDate.clear();
		addNewValue_InvoiceDate.sendKeys(date);
		return this;
	}


	public PeopleSoftLoginPage enterAccountingDate(String date) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_AccountingDate);
		addNewValue_AccountingDate.clear();
		addNewValue_AccountingDate.sendKeys(date);
		return this;
	}


	public PeopleSoftLoginPage clickOnAddButton() throws Exception
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, addNewValue_Button_Add);
		addNewValue_Button_Add.click();
		switchOutOfFrame();
		return this;
	}


	public PeopleSoftLoginPage enterPayTerms(String string) throws Exception 
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(frame_AddANewValue);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, infoPage_Fields_PayTerms);
		infoPage_Fields_PayTerms.clear();
		infoPage_Fields_PayTerms.sendKeys(string);
		return this;
	}


	public PeopleSoftLoginPage clickOnLineInfoTab() throws Exception
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, infoPage_Tabs_LineInfo);
		infoPage_Tabs_LineInfo.click();
		switchOutOfFrame();
		return this;	
	}


	public PeopleSoftLoginPage enterIdentifier(String identifier) throws Exception
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(frame_AddANewValue);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, lineInfoTab_Identifier);
		lineInfoTab_Identifier.clear();
		lineInfoTab_Identifier.sendKeys(identifier);
		return this;
	}


	public PeopleSoftLoginPage enterDescription(String description) throws Exception
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, lineInfoTab_Description);
		lineInfoTab_Description.clear();
		String descriptionNew=description.replace("$", "").replace("%", "");
		lineInfoTab_Description.sendKeys(descriptionNew);
		return this;
	}


	public PeopleSoftLoginPage enterQuantity(String quantity) throws Exception
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, lineInfoTab_Quantity);
		lineInfoTab_Quantity.clear();
		lineInfoTab_Quantity.sendKeys(quantity);
		return this;
	}


	public PeopleSoftLoginPage enterUOM(String string) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, lineInfoTab_UOM);
		lineInfoTab_UOM.clear();
		lineInfoTab_UOM.sendKeys(string);
		return this;
	}


	public PeopleSoftLoginPage enterUnitPrice(String unitPrice) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, lineInfoTab_UnitPrice);
		lineInfoTab_UnitPrice.clear();
		lineInfoTab_UnitPrice.sendKeys(unitPrice);
		return this;
	}


	public PeopleSoftLoginPage clickOnAccounting() throws Exception 
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, lineInfoTab_Accounting);
		lineInfoTab_Accounting.click();
		switchOutOfFrame();
		return this;
	}


	public PeopleSoftLoginPage enterAccount(String account) throws Exception
	{
		Thread.sleep(5000);
		switchToFrameByWebElement(frame_AddANewValue);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, revDistribution_Account);
		revDistribution_Account.clear();
		revDistribution_Account.sendKeys(account);
		return this;
	}


	public PeopleSoftLoginPage enteroperatingUnit(String operatingUnit)
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, revDistribution_OperatingUnit);
		revDistribution_OperatingUnit.clear();
		revDistribution_OperatingUnit.sendKeys(operatingUnit);
		return this;
	}


	public PeopleSoftLoginPage enterDept(String department) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, revDistribution_Department);
		revDistribution_Department.clear();
		revDistribution_Department.sendKeys(department);
		return this;
	}


	public PeopleSoftLoginPage enterProduct(String product)
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, revDistribution_Product);
		revDistribution_Product.clear();
		revDistribution_Product.sendKeys(product);
		return this;
	}


	public PeopleSoftLoginPage enterSubAccount(String subAccount) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, revDistribution_SubAccount);
		revDistribution_SubAccount.clear();
		revDistribution_SubAccount.sendKeys(subAccount);
		return this;
	}


	public PeopleSoftLoginPage clickOnHeaderInfoTab()
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, infoPage_Tabs_HeaderInfo);
		infoPage_Tabs_HeaderInfo.click();
		return this;
	}


	public PeopleSoftLoginPage clickOnNotes() 
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, infoPage_Fields_Notes);
		infoPage_Fields_Notes.click();
		return this;
	}


	public PeopleSoftLoginPage enterNotes(String note) 
	{
		FluentWaiting.waitUntillElementToBeVisible(30, 500, headerNotes_NotesTextArea);
		headerNotes_NotesTextArea.clear();
		headerNotes_NotesTextArea.sendKeys(note);
		return this;
	}


	public PeopleSoftLoginPage clickOnSaveButton() throws Exception 
	{
		FluentWaiting.waitUntillElementToBeClickable(30, 500, headerNotes_Save);
		headerNotes_Save.click();
		//switchOutOfFrame();
		return this;
	}


	public PeopleSoftLoginPage getInvoiceValue() throws Exception
	{
		Thread.sleep(10000);
		FluentWaiting.waitUntillElementToBeVisible(30, 500, getInvoiceNumber);
		String InvoiceNumber = getInvoiceNumber.getText();
		System.out.println(getInvoiceNumber.getText());
		Reporter.log(getInvoiceNumber.getText());
		
		
		ApplicationConfiguration appConfig = new ApplicationConfiguration();
		String excel_FilePath = appConfig.getFilePath();
		File src = new File(excel_FilePath);
		System.out.println("Deepak");
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = null;
		HSSFWorkbook Wb = new HSSFWorkbook(fis);
		HSSFSheet sheet1 = Wb.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell= null;

		int column = 0;
		row = sheet1.getRow(0);
		
		for(int i=0;i<row.getLastCellNum()-1;i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(InvoiceNumber));
			{
				column=i++;
			}
		}

		row = sheet1.getRow(2);
		if(row==null)
			row = sheet1.createRow(2);

		cell = row.getCell(column);

		if(cell==null)

			cell =row.createCell(column);

		cell.setCellValue(InvoiceNumber);
		fos=new FileOutputStream(src);
		Wb.write(fos);
		fos.close();
		System.out.println("End");
		switchOutOfFrame();
		return this;
	}
}
