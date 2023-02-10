package AboutGenericMethod;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethodStatic {
	private static WebDriver driver = null;

	public static void Browerlaunch(String browername) {
		
		try {
			if (browername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browername.equalsIgnoreCase("firefox")) {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			} else if (browername.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("Brower name is wrong please check it");
			}
		} catch (Exception a) {
			a.printStackTrace();
		}

	}

	public static void forURLhit(String url) {
		try {
			driver.get(url);
			test.log(Status.INFO, url+" open successfully ");
		} catch (Exception e) {
			test.log(Status.INFO, url+" open successfully ");
			driver.navigate().to(url);
		} catch (Throwable e) {
			test.log(Status.FAIL, url+" not open successfully ");
			e.printStackTrace();
		}
	}

	public static void sizeOfElement(String locatorName, String locatorValue, String elementName) {
		try {
			WebElement element = searchElement(locatorName, locatorValue);
			Dimension elemntDimension = elementSize(element);
			{
				System.out.println("height of " + elementName + "  -" + elemntDimension.height);
				System.out.println("Width of " + elementName + "  -" + elemntDimension.width);
			}
		} catch (Exception e) {

		}

	}

	public static void valildateLocation(String locatortype, String locatorvalue, String elememntName,
			int required_x_cordinate, int required_Y_cordinate) {
		// TODO Auto-generated method stub
		try {
			Point objPoint = searchElement(locatortype, locatorvalue).getLocation();
			int actual_X_cordinate = objPoint.x;
			int actual_Y_cordinate = objPoint.y;
			if (required_x_cordinate == actual_X_cordinate) {
				test.log(Status.PASS, elememntName + "x-cordinate verified!");
			} else {
				test.log(Status.FAIL, elememntName + "x-cordinate mismatched with expected value!");
			}
			if (required_Y_cordinate == actual_Y_cordinate) {
				test.log(Status.PASS, elememntName + "y-cordinate verified!");
			} else {
				test.log(Status.FAIL, elememntName + "y-cordinate mismatched with expected value!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "while validating location of " + elememntName
					+ " exception occured thus,followed by handeling it");

		}
	}

	public static void valildateSize(String locatortype, String locatorvalue, String elememntName, int required_height,
			int required_width) {
		try {
			Dimension objDimension = searchElement(locatortype, locatorvalue).getSize();
			int actual_height = objDimension.getHeight();
			int actual_width = objDimension.getWidth();
			if (required_height == actual_height) {
				test.log(Status.PASS, elememntName + " height verified!");
			} else {
				test.log(Status.FAIL, elememntName + " height mismatched with expected value!");
			}
			if (required_width == actual_width) {
				test.log(Status.PASS, elememntName + " width verified!");
			} else {
				test.log(Status.FAIL, elememntName + " width mismatched with expected value!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL,
					"while validating size of " + elememntName + " exception occured thus,followed by handeling it");
		}
	}

	public static void isEnabled(String locatortype, String locatorvalue, String elememntName) {
		try {

			boolean e = searchElement(locatortype, locatorvalue).isEnabled();

			if (e == true) {
				test.log(Status.PASS, elememntName + "  is clickable ");

			} else {
				test.log(Status.FAIL, elememntName + "  is not clickable ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void isDisplayed(String locatortype, String locatorvalue, String elementName) {
		try {
			boolean id = searchElement(locatortype, locatorvalue).isDisplayed();

			if (id == true) {
				test.log(Status.PASS, elementName + "is visisble");

			} else {
				test.log(Status.FAIL, elementName + "is not visible");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void validatePageTitle(String expectedTitle) {

		if (gettitle().equals(expectedTitle))
			test.log(Status.PASS, " Title verified with expected title " + expectedTitle);
		else {
			test.log(Status.FAIL, " Title mismatched with expected title " + expectedTitle);

		}

	}

	public static String gettitle() {
		String title = null;
		try {
			return driver.getTitle();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;

	}

	public static void gettext(String locatorvalue, String locatortype, String elementName) {
		try {

			String gtt = searchElement(locatortype, locatorvalue).getText();

			test.log(Status.INFO, "text of " + elementName + " taken successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "text of " + elementName + "  not taken successfully.");
		}
	}

	public static void getAttribute(String locatorvalue, String locatortype, String elementName) {
		try {
			String geta = searchElement(locatortype, locatorvalue).getAttribute(locatortype);

			test.log(Status.INFO, "Attribute value  of " + elementName + " taken successfully.");
		}

		catch (Exception e) {
			test.log(Status.FAIL, "Attribute value  of " + elementName + " taken successfully.");

			e.printStackTrace();
		}
	}

	public static void waitforimplicity(WebDriver driver, int timeout) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement searchElement(String locatorname, String locatorValue) {
		WebElement obj = null;
		try {
			if (locatorname.equalsIgnoreCase("xpath")) {
				return obj = driver.findElement(By.xpath(locatorValue));
			} else if (locatorname.equalsIgnoreCase("id")) {
				return obj = driver.findElement(By.id(locatorValue));
			} else if (locatorname.equalsIgnoreCase("css")) {
				return obj = driver.findElement(By.cssSelector(locatorValue));
			} else if (locatorname.equalsIgnoreCase("name")) {
				return obj = driver.findElement(By.name(locatorValue));

			} else if (locatorname.equalsIgnoreCase("tag name")) {
				return obj = driver.findElement(By.tagName(locatorValue));

			} else if (locatorname.equalsIgnoreCase("class")) {
				driver.findElement(By.className(locatorValue));
			} else {
				System.out.println("xpath is wrong please check it ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return obj;
		}
		return obj;
	}

	public static void sendvalue(WebElement we, String inputvalue) {
		try {
			we.clear();
			we.sendKeys("inputvalue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickbutton(String string, String locatorname, String locatorValue) {
		searchElement(locatorname, locatorValue).click();
	}

	public static void forframe(int frameninndex) {
		try {
			driver.switchTo().frame(frameninndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void forframe(String NameOrId) {
		try {
			driver.switchTo().frame(NameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  Dimension elementSize(WebElement element) {
		Dimension measurement = element.getSize();
		System.out.println(measurement);
		return measurement;

	}

	public static void forframe(WebElement weframeobj) {
		try {
			driver.switchTo().frame(weframeobj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void genericM(WebDriver driver, ExtentTest et) {
		WebElement wb = driver.findElement(By.xpath("xpath"));
		try {
			if (wb.isDisplayed() == true) {
				et.log(Status.INFO, "Element is visible");
				if (wb.isEnabled() == true) {
					et.log(Status.INFO, "Element is clickable");
				} else {
					et.log(Status.FAIL, "Element is not visible");
				}
			} else {
				et.log(Status.FAIL, "Element is not clickable");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  void flushed() {
	
		try {
			report.flush();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("report flushed !!");
		}
	}

	private static ExtentReports report;
	private static ExtentTest test;

	public static void generateRepot(String reportName) {
		try {
			String time=fordate();
			ExtentSparkReporter esr = new ExtentSparkReporter("report\\" + reportName+time + ".html");
			report = new ExtentReports();
			report.attachReporter(esr);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public static void initlog(String tcName) {
		try {
			test = report.createTest(tcName);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	public static  void forScreenshot() {
		try {
			String date=fordate();
			
			TakesScreenshot tsc = (TakesScreenshot) driver;
			File to = tsc.getScreenshotAs(OutputType.FILE);
			File from = new File("sneha//screenshot"+date+".png");
			Files.copy(to, from);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String  fordate() {
		String time=null;
		try {
			DateFormat dt = new SimpleDateFormat("MM--DD--YY--HH--MM--SS");
			 time = dt.format(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static void mouseover(WebElement actiobj, String elementName) {
		try {
			Actions linkofmarketing = new Actions(driver);
			linkofmarketing.moveToElement(actiobj).build().perform();
			test.log(Status.INFO, " move to the element  " + elementName + " successfully.");
		} catch (Exception e) {
			test.log(Status.INFO, " not move to the element  " + elementName + " successfully.");

			e.printStackTrace();
		}
	}

	public static void ForWindowHandle(String windowTitle) {
		try {
			Set<String> handleValus = driver.getWindowHandles();
			System.out.println(handleValus.size());
			System.out.println(handleValus);
			for (String hValue : handleValus) {
				String actualTitle = driver.switchTo().window(hValue).getTitle();

				if (actualTitle.contains(windowTitle)) {
					test.log(Status.INFO, "title of currret window is -- " + windowTitle);
					break;
				}

			}

		} catch (Exception e) {
			test.log(Status.INFO, "title of currret window isnot taken successfully.");

			e.printStackTrace();
		}
	}
		
	

}

