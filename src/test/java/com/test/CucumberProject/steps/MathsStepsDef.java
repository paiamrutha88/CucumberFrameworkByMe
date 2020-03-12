package com.test.CucumberProject.steps;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MathsStepsDef {

	
	
	@Before("@Prod")
	public void before(Scenario s)
	{
		System.out.println("launch before @prod");
		
	}
	@After("@Prod")
	public void after()
	{
		System.out.println("launch after @prod");
	}
	
	
	@Given("^I have number (\\d+)$")
	public void num1(int a)
	{
		System.out.println("First Number : "+a);
	}
	
	
	
	@When("^I click on add button$")
	public void add()
	{
		System.out.println("adding");
	}
	
	@And("^I get result$")
	public void result()
	{
		System.out.println("result");
	}
	
	@When("^I click on subtract button$")
	public void subtract()
	{
		System.out.println("Subtracting");
	}
	// use of List
	@And("^User selects age category$")
	public void selectAge(List<String> age)
	{
		System.out.println("Selected age : " + age.get(2));
	}
	
	//use of data table
	@And("^User selects state and country$")
	public void selectStateAndCountry(DataTable table)
	{
		List<Map<String,String>> data = table.asMaps(String.class, String.class);
		
		System.out.println("State 1 : " +data.get(0).get("State")+ " Country 1 : " +data.get(0).get("Country"));
	}
}
