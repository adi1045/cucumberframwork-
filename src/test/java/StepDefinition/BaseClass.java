package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import Utilities.Readconfig;

import org.apache.logging.log4j.*;


public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginpg;
	public AddNewCustomerPage addNewCustPg;
	//public SearchCustomerPage searchCustPg;
	public static Logger log;
	public  Readconfig readconfig;
	
	
	//Generated unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
