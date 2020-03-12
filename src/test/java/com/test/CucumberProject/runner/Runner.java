package com.test.CucumberProject.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		
	dryRun=false,
	strict=true,
	monochrome= true,
	features = {"src/test/resources/"},
	glue= {"com.test.CucumberProject.steps"},
	plugin = {
			"html:target/site/cucumber-html",
			"json:target/site/cucumber.json",
			"pretty",
			
			
			
	},
	//tags = { "@Add and not @bkSub"}
	//tags = { "@Add or not @bkSub"}		
	tags = { "@add"}
	
	
	
)

public class Runner {
	


}
