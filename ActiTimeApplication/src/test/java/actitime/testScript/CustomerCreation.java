package actitime.testScript;

import java.io.IOException;
import java.time.Duration;

//import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;

public class CustomerCreation {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		DataUtility du=new DataUtility();
      String customername=du.getDataFromExcelSheet("Sheet1",0,1);
      CommonUtility cu=new CommonUtility();
    	
    	 
    	 
    		ChromeOptions opt=new ChromeOptions();
    		opt.addArguments("--remote-allow-origins=*");
    		WebDriver driver=new ChromeDriver(opt);
    		
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 driver.get(du.getDataFromProperties("url"));
    	 driver.findElement(By.id("username")).sendKeys(du.getDataFromProperties("username"));
    	 driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperties("password"));
    	 driver.findElement(By.id("loginButton")).click();
    	 driver.findElement(By.id("container_tasks")).click();
    	 driver.findElement(By.xpath("//div[text()='Add New']")).click();
    	 driver.findElement(By.className("createNewCustomer")).click();
    	 //pass customer name
    	 driver.findElement(By.className("newNameField")).sendKeys(customername);
    	 
    	 driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("Customer creation is on");
    	 driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
    	 
    	 		
    	
    	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".titleEditButtonContainer>.title"),customername));
    	 String actualCustomerName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
    	 System.out.println(actualCustomerName);
    	 
    	 
    	 
    	  
    	 
	}
	  
}
