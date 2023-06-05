package StepDefinition;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import Utilities.Readconfig;
import io.cucumber.java.*;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

  //child class of base class
public class StepDef extends BaseClass {
	
	@Before("@Sanity")
    public void setup()
    {
		
	//Initialize logger	
		log = LogManager.getLogger("StepDef");
		System.out.println("steup method executed");
		
		
		readconfig=new Readconfig();		
		String browser=readconfig.getBrowser();
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
	
	  default:
		   driver=null;
		   break;
		}
    	
		
		//log.info("");
		log.info(" setup1 executed..");
    }
	
	@Before("@regression")
    public void setup2()
    {
	
		System.out.println("steup2 Regression method executed");
		
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//log.info("");
		log.info(" setup2 executed..");
    }
	@Given("User launch the chrome browser")
	public void user_launch_the_chrome_browser() {
	   
		
		loginpg=new LoginPage(driver);
		addNewCustPg=new AddNewCustomerPage(driver);
		
		log.info("User launched chrome browser");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	   
	   log.info("User opens URL");
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailAdd, String password) {
	    
		loginpg.enterEmail(emailAdd);
		loginpg.enterPassword(password);
		
		log.info("user enter emai and password");
	}

	@When("click on login")
	public void click_on_login() {
	
		loginpg.clickbtn();
		
		log.info("clicked on login");
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			log.warn("Test passed: Login feature  : page Title matched.");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("Test failed:Login feature  : page Title not matched.");
			Assert.assertTrue(false);
		}
		
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {
	   
		loginpg.clickOnLogOutBtn();
		
		log.info("user clicked on logoout link.");
	}
/*
	@Then("close browser")
	public void close_browser() {
	    
		driver.close();
		
		log.info("close browser");
		
	}   */

	///////////////New Customer////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Dashboard / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomerMenu();
	}

	@When("Click on customers Meni Item")
	public void click_on_customers_meni_item() {
		addNewCustPg.clickOnCustomersMeniItem();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Add a new customer / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("adi");
		addNewCustPg.enterLastName("dho"); 
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterDob("6/13/1998");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterCustomerRoles("");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterMangerOfVender("Vendor 2");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
	  
		String bodyTagText=driver.findElement(By.tagName("Body")).getText();
		
		if(bodyTagText.contains(expectedConfirmationMsg))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);	
		}
	}
	//Search Customer by Email
		//Search Customer by Name
	
	
/*	@After
	 public void teardown(Scenario sc)
	 {
		
		System.out.println("Tear down method executed");
		
		if(sc.isFailed()==true)
		{
			//convert web driver object to TakesScreenshot
			
			String fileWithPath="D:\\Java\\New project\\.metadata\\CucumberFramework\\Screenshot\\fail1.png";
		  
			 TakesScreenshot srcShot=((TakesScreenshot)driver);
			 
			 //call getScreenshots method to create image file			 
			 File SrcFile=srcShot.getScreenshotAs(OutputType.FILE);
		
			 //Move image file to destination			 
			 File DestFile=new File(fileWithPath);
			 
			 //cpopy file at destination
			 try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		}
		
		driver.quit();
	 }   */
	
	@AfterStep
	   public void addScreenshot(Scenario scenario)
	{

		if(scenario.isFailed())
		{
	final byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	//attach image file report(data,media type,name of the attachment)
	scenario.attach(screenshot, "image/png", scenario.getName());
		}
	 
	}
/*	
	@BeforeStep
	public void beforeStepMethodDemo()
	{
		System.out.println("this is before step.........");
	}
	@AfterStep
	public void afterStepMethodDemo()
	{
		System.out.println("this is after step.........");
	} */


}
