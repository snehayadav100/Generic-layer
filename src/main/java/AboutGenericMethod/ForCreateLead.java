package AboutGenericMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForCreateLead {

	public static void main(String[] args) {
		 System.setProperty("WebDriver.chrome.driver", "C:\\Users\\pc\\eclipse-Selenium_workspace\\Selenium\\chromedriver.exe");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();	
		 driver.get("http://localhost:8888//");
		
		 driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@name=\"Login\"]")).click();
	     driver.findElement(By.linkText("Marketing")).click();
        String innert= driver.findElement(By.xpath("//a[text()=\"Leads\"]")).getText();
	}
}