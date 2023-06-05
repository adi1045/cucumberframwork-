package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public  LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webElement
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement LogoutBtn;
	
	//action on webElement
	
	public void  enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);		
	}
	
	public void  enterPassword(String pwdAdd)
	{
		pwd.sendKeys(pwdAdd);		
	}
	
	public void  clickbtn()
	{
		LoginBtn.click();
	}

   public void clickOnLogOutBtn()
   {
		 LogoutBtn.click();
   }
}
