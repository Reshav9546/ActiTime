package actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class GeneralSetting extends BaseClass {
  
	@Test
	public void dropDownHandling()
	{
		String v="MODIFICATIONS NOT SAVED";
       driver.findElement(By.className("popup_menu_button_settings")).click();
       driver.findElement(By.xpath("//div[@class='popup_menu_content popup_menu_settings']/div//li[4]//div[1]")).click();
     WebElement topgroupinglevel =  driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
      // driver.findElement(By.xpath("//option[text()='Product Line']")).click();
       cu.getVisibleText(topgroupinglevel, "Product Line");
        WebElement wb=driver.findElement(By.id("FormModifiedTextCell"));
        String s=wb.getText();
        Assert.assertEquals(v,s);
        Reporter.log(s,true);
       // cu.getAlertDismiss(driver);

	}

}
