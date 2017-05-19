/**
 * 
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BrowserFactory;
import pageObjects.modules.PeopleSoftLoginPage;

/**
 * @author ${Gladson Antony}
 * @date Sep 17, 2016
 * 
 */
public class PageFactoryInitializer extends BrowserFactory
{
	
	public PeopleSoftLoginPage loginPage()
	{
		return PageFactory.initElements(driver, PeopleSoftLoginPage.class);
	}
	

}
