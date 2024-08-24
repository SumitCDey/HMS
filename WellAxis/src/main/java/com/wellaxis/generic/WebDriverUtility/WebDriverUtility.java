package com.wellaxis.generic.WebDriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	public void takeScreentShot(WebDriver driver,String destPath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE); 
		File dest=new File(destPath);
		FileHandler.copy(src, dest);

	}
	  public void sendTextJavaScript(WebDriver driver, WebElement element, String textInput) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, textInput);
	    }
	

	  public void clickElementJavaScript(WebDriver driver, By locator) {
	        WebElement element = driver.findElement(locator);
	        element.click();

	    }

	   public void clickElementByJS(WebDriver driver, WebElement element) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].click();", element);
	    }
	   
	   public JavascriptExecutor javaScript(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js;
		}
	   
	   public void scrollToLocation(WebDriver driver,int y) {

			javaScript(driver).executeScript("window.scrollBy(0," + y + ")");
		}
	   
	   public void scrollUntilElementToBeVisible(WebDriver driver, WebElement element) {
			javaScript(driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}

	   
	  public void dropDown(WebElement element,int index) {
		  Select sel=new Select(element);
		  sel.selectByIndex(index);
	  } 
	  public void dropDown(WebElement element,String value) {
		  Select sel=new Select(element);
		  sel.selectByValue(value);
	  } 
	  public void dropDown(String Visibletext,WebElement element) {
		  Select sel=new Select(element);
		  sel.selectByVisibleText(Visibletext);
	  } 
	   
	  
}



