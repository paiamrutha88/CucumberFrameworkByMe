package com.test.CucumberProject.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.CucumberProject.reports.ExtentManager;
import static org.assertj.core.api.Assertions.*;

public class WebConnector {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports rep;
	public ExtentTest testScenario;

	public WebConnector() {
		if (prop == null) {

			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//project.properties");
				prop.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void initReports(String scenarioName) {
		rep = ExtentManager.getInstance(System.getProperty("user.dir") + prop.getProperty("reportPath"));
		testScenario = rep.createTest(scenarioName);
		testScenario.log(Status.INFO, "Starting test : " +scenarioName);
	}

	public void openBrowser(String bname) {
		if (bname.equalsIgnoreCase("Mozilla"))
			driver = new FirefoxDriver();
		else if (bname.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (bname.equalsIgnoreCase("IE"))
			driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		testScenario.log(Status.INFO, "Browser Opened successfully " +bname);
		
	}

	public void navigate(String urlKey) {
		driver.get(prop.getProperty(urlKey));

	}

	public void click(String objectKey) {
		getObject(objectKey).click();

	}

	public void type(String objectKey, String text) {
		getObject(objectKey).sendKeys(text);

	}

	public void mouseHover(String objectKey) {
		WebElement e = getObject(objectKey);
		new Actions(driver).moveToElement(e).build().perform();
	}

	public void selectValueFromDropdown(String objectKey, String value) throws InterruptedException {
		WebElement e = getObject(objectKey);
		explicitlyWait(e);
		
		new Select(e).selectByVisibleText(value);
	}

	public void validateLogin(String expectedResult) {
		
		String actualResult = "";

		if (isElementPresent("portFolioId_xpath"))
			actualResult = "success";
		else
			actualResult = "failure";

		infoLog("actualResult : " + actualResult);
		infoLog("ExpectedResult : " + expectedResult);
		if (!actualResult.equals(expectedResult))
			System.out.println("Login failed");

	}

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String getPropertyValue(String propKey)
	{
		return prop.getProperty(propKey);
	}

	public boolean isElementPresent(String objectKey) {
		List<WebElement> list = null;

		if (objectKey.endsWith("_xpath")) {
			list = driver.findElements(By.xpath(prop.getProperty(objectKey)));
		} else if (objectKey.endsWith("_name")) {
			list = driver.findElements(By.name(prop.getProperty(objectKey)));
		} else if (objectKey.endsWith("_id")) {
			list = driver.findElements(By.id(prop.getProperty(objectKey)));
		} else if (objectKey.endsWith("_css")) {
			list = driver.findElements(By.cssSelector(prop.getProperty(objectKey)));
		}

		if (list.size() == 0)
			return false;
		else
			return true;
	}

	public WebElement getObject(String objectKey) {
		WebElement e = null;
		try {
			if (objectKey.endsWith("_xpath")) {
				e = driver.findElement(By.xpath(prop.getProperty(objectKey)));
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
			}

			else if (objectKey.endsWith("_id")) {
				e = driver.findElement(By.id(prop.getProperty(objectKey)));
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(prop.getProperty(objectKey))));
			}

			else if (objectKey.endsWith("_name")) {
				e = driver.findElement(By.name(prop.getProperty(objectKey)));
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(prop.getProperty(objectKey))));
			}
		} catch (Exception ex) {
			reportFailure("Unable to find WebElement");
		}
		return e;
	}

	public void login(String username, String password) {
		type("username_xpath", username);
		click("continueUname_xpath");
		type("password_xpath", password);
		click("continuePass_xpath");
		acceptAlertIfPresent();
	}

	public void acceptAlertIfPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void explicitlyWait(WebElement objectKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(objectKey));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void takeScreenShot() {
		Date d = new Date();
		String fileName = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".png";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(ExtentManager.screenShotFolderPath + fileName));

			testScenario.log(Status.FAIL, "Screenshot -->"
					+ testScenario.addScreenCaptureFromPath(ExtentManager.screenShotFolderPath + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ***********************logging functions*************************

	public void infoLog(String msg) {
		testScenario.log(Status.INFO, msg);
	}

	public void reportFailure(String errorMsg) {
		// fail in extent report
		testScenario.log(Status.FAIL, errorMsg);
		// take screen shot
		// put in reports
		takeScreenShot();

		// fail in cucumber
		assertThat(false);
	}

	public void quit() {
		// TODO Auto-generated method stub

		if (rep != null)
			rep.flush();

	} 

}
