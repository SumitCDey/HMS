package com.wellaxis.generic.WebDriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void openBrowser(WebDriver driver, String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
	}
	public void waitForThePageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForTheElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
public void getAndMaximize(WebDriver driver,String URL) {
	driver.manage().window().maximize();
	driver.get(URL);
}
public void mouseMoveToElementAndClick(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).click().perform();;
	
}
public void robotKey() throws AWTException {
	Robot robot=new Robot();
	
	
}





}
