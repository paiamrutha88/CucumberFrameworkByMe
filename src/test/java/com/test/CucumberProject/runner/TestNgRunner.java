package com.test.CucumberProject.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions (
		
		dryRun=false,
		strict=true,
		monochrome= true,
		features = {"src/test/resources/"},
		glue= {"com.test.CucumberProject.steps"},
		plugin = {
				"html:target/site/cucumber-html",
				"json:target/site/cucumber.json",
				"pretty"
		},
		//tags = { "@Add and not @bkSub"}
		//tags = { "@Add or not @bkSub"}		
		tags = { "@add"}
		
		
		
	)

public class TestNgRunner extends AbstractTestNGCucumberTests {

	
	
}
