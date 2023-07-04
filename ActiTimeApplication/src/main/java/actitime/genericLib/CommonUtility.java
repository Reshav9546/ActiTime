package actitime.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {

	public int getRandomNum()
	{
		Random r=new Random();
		int num=r.nextInt(1000);
		return num;
	}
 public void getAlertAccept(WebDriver driver)
 {
	
	 Alert alt=driver.switchTo().alert();
	 alt.accept();
 }
 public String getAlertText(WebDriver driver)
 {
		
	 Alert alt=driver.switchTo().alert();
	 String a=alt.getText();
	 return a;
	
 }
 public void getAlertDismiss(WebDriver driver)
 {
	 Alert alt=driver.switchTo().alert();
	 alt.dismiss();
 }
 
 public void textTobePresentWait(WebDriver driver,By locator,String text)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));

 }
 public void getVisibleText(WebElement dropDown,String topgroupinglevel)
 {
	 Select s=new Select(dropDown);
	 s.selectByVisibleText(topgroupinglevel);
			
 }
 public void getselectByindex(WebElement dropdown,int index)
 {
	 Select s=new Select(dropdown);
			 s.selectByIndex(index);
 }
 public void getselectByValue(WebElement dropdown,String value)
 {
	 Select s= new Select(dropdown);
	 s.selectByValue(value);
 }
 public void doubleClick(WebDriver driver,WebElement wb)
 {
	 Actions act=new Actions(driver);
	 act.doubleClick(wb);
 }
 public void moveToElement(WebDriver driver,WebElement wb)
 {
	 Actions act=new Actions(driver);
	 act.moveToElement(wb);
	 
 }

	
}

 
	

	


