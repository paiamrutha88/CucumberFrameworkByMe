package com.test.CucumberProject.steps;

import java.util.List;
import java.util.Map;

import com.test.CucumberProject.excelReader.ExcelReader;
import com.test.CucumberProject.excelReader.ExcelReader1;
import com.test.CucumberProject.webdriver.WebConnector;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExcelReadingSteps {
	WebConnector con;
	
	public ExcelReadingSteps(WebConnector con)
	{
		this.con=con;
	}

	 @Given("^scenario data$")
	    public void scenarioData() throws Throwable {
	        System.out.println("Scenario Have Some Data");
	    }

	    @When("^executed from Runner Class$")
	    public void executedFromRunnerClass() throws Throwable {
	        System.out.println("Executed From Runner Class");
	    }

	    @Then("^UserName and Password shows on console form given (\\d+)\\.$")
	    public void usernameAndPasswordShowsOnConsoleFormGiven(int rowNumber) throws Throwable {
	        ExcelReader externalData = new ExcelReader();
	        externalData.get("u1", "password");
	       
	    }
}
