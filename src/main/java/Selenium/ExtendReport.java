package Selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {

	public static void main(String[] args) {
		
		
	 File reportName=new File("Extentreport.html");
	 ExtentSparkReporter extobj=new ExtentSparkReporter(reportName);
	 ExtentReports report=new ExtentReports();
	 report.attachReporter(extobj);	 
	 report.setSystemInfo("os name", System.getProperty("os.name"));
	 report.setSystemInfo("user name",("sneha"));
	 report.setSystemInfo("user password",("123"));
	 ExtentTest tc001=report.createTest("Tc001");
	 
	 WebDriver driver=new ChromeDriver();
	 tc001.log(Status.INFO,"Browser launched sucessfully");
	 
     TakesScreenshot screenst=(TakesScreenshot)driver;
     driver.get("http://localhost:8888");
     tc001.log(Status.INFO, "url navigation succesfully");
     driver.findElement(By.name("user_name")).sendKeys("admin");
     tc001.log(Status.PASS, "username entered sucessfully");
     driver.findElement(By.name("user_password")).sendKeys("admin",Keys.ENTER);
     tc001.log(Status.INFO, "succesfully entered password in password box and hit on enter key");
     report.flush();

    
     
     
    
   
		
	}
}