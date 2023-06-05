package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)   //testNG
@CucumberOptions(
		
		features =".//Features/LoginFeature.feature",
		
		//features ={".//Features/LoginFeature.feature",".//Features/Customers.feature"}, //two feature file run
		//features =".//Feature",  //all features folder run
		
		glue="StepDefinition", //step defination path
		dryRun= true,          //step implement hoi he kya nahi ye check krta he
		monochrome =true,       //monochrome: If set to true, it formats the console output in a readable format.
    
		tags="@sanity",  // scenarios under @sanity tag will be executed
	    //tags="@regression",
		
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
	//	plugin = {"pretty","html:target/cucumber-reports/reports1.html","json:target/cucumber-reports/reports_json.json","junit:target/cucumber-reports/reports1_xml.xml"}		 //plugins to be used for generating test reports. In this case, the "pretty" plugin is used. 
		  //report in three format
		
	   //plugin={"pretty","json:target/cucumber-reports/reports_json.json"}	
		//plugin={"pretty","junit:target/cucumber-reports/reports1_xml.xml"}
		)
public class Run extends AbstractTestNGCucumberTests{        //testNG

	//this class will be empty
}
