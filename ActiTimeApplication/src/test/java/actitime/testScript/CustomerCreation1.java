package actitime.testScript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;
@Listeners(actitime.genericLib.ListenerImplementation.class)   
public class CustomerCreation1 extends BaseClass {
           @Parameters({"name"})
         	@Test
	    	public void createCustomer(String name) throws EncryptedDocumentException, IOException
	    	{
	    
	    	//String customername=du.getDataFromExcelSheet("Sheet1",1,1);
        	  String customername=name;
	    	 int num=cu.getRandomNum();
	    	 customername=customername+num;
	    	 
	    	  driver.findElement(By.id("container_tasks")).click();
	    	 driver.findElement(By.xpath("//div[text()='Add New']")).click();
	    	 driver.findElement(By.className("createNewCustomer"));
	    	 //pass customer name
	    	 driver.findElement(By.className("newNameField")).sendKeys(customername);
	    	 
	    	 driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("Customer creation is on");
	    	 driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	    	
	    	 cu.textTobePresentWait(driver, By.cssSelector(".titleEditButtonContainer>.title"), customername);
	    	 String actCustomerName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
	          System.out.println(actCustomerName);
         	 
	    	 }
             }


