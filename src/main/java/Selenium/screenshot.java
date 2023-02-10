package Selenium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		TakesScreenshot takescr = (TakesScreenshot) driver;
		DateFormat dt = new SimpleDateFormat("dd--MM--yyyy--HH--mm--ss");
		String time = dt.format(new Date());
		System.out.println(time);
		File from = takescr.getScreenshotAs(OutputType.FILE);
		File to = new File("sneha//screen" + time + ".png");
		Files.copy(from, to);

	}

}
