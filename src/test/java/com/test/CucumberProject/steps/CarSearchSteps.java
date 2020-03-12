package com.test.CucumberProject.steps;

import java.util.List;

import com.test.CucumberProject.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CarSearchSteps {
	WebConnector con;
	public CarSearchSteps(WebConnector con)
	{
		this.con=con;
	}
	
	@Given("^I navigate to (.*) homepage$")
	public void navidate_to_home(String url) throws Exception {
	    con.openBrowser("Chrome");
	    con.navigate(url);
	
	}

	@When("^I move mouse to (.*) menu$")
	public void i_move_mouse_to_buySell_xpath_menu(String xpathKey) throws Exception {
	    
	  con.mouseHover(xpathKey);
	}
	@When("^I move mouse to menu$")
	public void selectMenulist(List<String> menu)
	{
		 con.mouseHover(menu.get(1));
	}

	@Then("^I click on (.*) field$")
	public void i_click_on_searchCars_xpath(String xpathKey) throws Exception {
	    
	  con.click(xpathKey);
	}

	@And("^I select (.*) in (.*) dropdown$")
	public void i_select_bmw_in_make_xpath_dropdown(String value, String xpathKey) throws Exception {
	    
	  con.selectValueFromDropdown(xpathKey, value);
	}
	

	@Then("^I get list of searched cars (.*)$")
	public void i_get_list_of_searched_cars(String modelName) throws Exception {

		Assert.assertTrue(con.getObject("car_xpath").getText().contains(modelName));
	}

	@And("^the page title should be (.*)$")
	public void the_page_title_should_be_pageTitleKey(String pageTitleKey) throws Exception {
		
		Assert.assertEquals(con.getPropertyValue(pageTitleKey).toString(), con.getTitle().toString());
		
	}	
	

}
