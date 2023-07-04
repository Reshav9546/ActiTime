package actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	public WebDriver driver;
	
	
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();

	public static WebDriver Listenerdriver;    //for screenshot purpose we have created another WebDriver variable(Listenerdriver)
		
	  @BeforeClass
		public void launchbrowser()
		{
			ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(opt);
			 Listenerdriver=driver;               //here we storing the vulue of chrome driver to Listenerdriver
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
	 // @Parameters({"url","username","password"})
	  @BeforeMethod(alwaysRun=true)
		public void login() throws IOException
		{
		  driver.get(du.getDataFromProperties("url"));
	    	 driver.findElement(By.id("username")).sendKeys(du.getDataFromProperties("username"));
	    	 driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperties("password"));
	    	 driver.findElement(By.id("loginButton")).click();

		}
	  @AfterMethod
	  public void logout() {
		  driver.findElement(By.id("logoutLink")).click();
		  
	  }
	  @AfterClass
	  public void closeBrowser()
	  {
	      driver.close();
      }

	}


