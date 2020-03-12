package com.test.CucumberProject.steps;

import java.util.Map;

import com.test.CucumberProject.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AppSteps {
	WebConnector con;
	public AppSteps(WebConnector con)
	{
		this.con=con;
	}
	
	@Then("^Login should be (.*)$")
	public void validateLogin(String expected)
	{
		con.validateLogin(expected);
	}
	//use of Map
	@And("^I login inside application$")
	public void login(Map <String,String>data)
	{
		System.out.println(data.get("username"));
		System.out.println(data.get("password"));
		
		con.login(data.get("username"),data.get("password"));
	}
}
