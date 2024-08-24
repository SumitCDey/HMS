package com.wellaxis.basetest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;//static
	


	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void confBeforeSuite() throws Exception
	{
		System.out.println("====connect to db, generate report====");
		dLib.getDbconnection();

		
	}



	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void confAfterSuite() throws Throwable
	{
		System.out.println("===disconnect to db, report backup====");
		dLib.closeDbconnection();
		

	}

	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBeforeclass() throws Throwable {
		System.out.println("===launch browser===");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");

		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else
			driver=new SafariDriver();

		sdriver=driver;

	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAfterclass() {
		System.out.println("==close browser===");
		driver.quit();
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBeforeMethod() throws Throwable {
		System.out.println("==login==");
		LoginPage lp=new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME =fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		driver.get(URL);
		lp.setLogin( USERNAME, PASSWORD);

	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAfterMethod() {
		System.out.println("==logout==");
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
}
