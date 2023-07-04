package actitime.testScript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;

public class AlertHandling extends BaseClass {

		// TODO Auto-generated method stub
	
	@Test
	public void handleAlert() throws EncryptedDocumentException, IOException {
		String v="Are you sure you want to cancel the Type of Work creation?";
        driver.findElement(By.className("popup_menu_button_settings")).click();
        driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
        driver.findElement(By.className("roundedBoxTag")).click();
        driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Sheet1", 1, 1));
        driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
        String msg=cu.getAlertText(driver);
        System.out.println(msg);
        SoftAssert sa= new SoftAssert();
        Assert.assertTrue(v.contains(msg));
        System.out.println("test case pass");
       cu.getAlertDismiss(driver);
     
     
        
        
	}

}
