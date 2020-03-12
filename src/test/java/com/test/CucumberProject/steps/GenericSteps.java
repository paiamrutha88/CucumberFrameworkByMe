package com.test.CucumberProject.steps;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.test.CucumberProject.reports.ExtentManager;
import com.test.CucumberProject.webdriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class GenericSteps {
	
	WebConnector con;
	
	public GenericSteps(WebConnector con)
	{
		this.con=con;
	}
	
	@Before
	public void before(Scenario s)
	{
		System.out.println("Before");
		con.initReports(s.getName());
	}
	@After
	public void after()
	{
		con.quit();
	} 
	
	@Given("^I open (.*)$")
	public void openBrowser(String bname)
	{
		//con.infoLog("Opening browser " +bname);
		con.openBrowser(bname);
		
	}
	
/*	@And("^I navigate to (.*)$")
	public void navigate(String urlKey)
	{
		con.infoLog("Navigating to : "+urlKey);
		con.navigate(urlKey);
	}*/
	
	@And("^I type (.*) in (.*) field$")
	public void type(String text, String objectKey)
	{
		//con.infoLog("Typing "+text+" in field "+objectKey);
		con.type(text,objectKey);
		
		
	}
	
	/*@And("^I click on (.*)$")
	public void click(String objectKey)
	{
		System.out.println("Clicking on : "+objectKey);
		con.click(objectKey);
	}*/
	
	
}
