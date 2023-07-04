package actitime.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener  //we have to right click on ITestListenerand go to source and override on test method

{



	public void onTestFailure(ITestResult result) {
	String tcname=result.getName();
	TakesScreenshot ts=(TakesScreenshot)BaseClass.Listenerdriver;   //here we are accessing base class listenerDriver
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("./failTc/"+tcname+".png");  //for concat
	
try
{
	

FileUtils.copyFile(src, trg);
}catch(Exception e)
{
	
}
 }
}

     
	


