package AboutGenericMethod;

public class TestCaseLayer {

	public  void validateUserNameSize(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userNameSize");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.valildateSize("name", "user_name", "user Name", 45, 120);
		obj.flushed();
	}
	public  void validatePasswordSize(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("passwordSize");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.valildateSize("name", "user_password", "user password", 40, 120);
		obj.flushed();
	}
	public  void validateloginelementsSize(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("LoginSize");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.valildateSize("name", "Login", "Login", 35, 100);
		obj.flushed();
	}
public void valildateUserNameLocation(String testCaseName) {
	WebUtil obj=new WebUtil();
	obj.generateRepot("userNameLocation");
	obj.initlog(testCaseName);
	obj.Browerlaunch("Chrome");
	obj.forURLhit("http://localhost:8888/");
	obj.valildateLocation("name", "user_name", "user name", 45, 57);
	obj.flushed();
	
}
	
	public void valildateUserPassswordLocation(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userPasswordLocation");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.valildateLocation("name", "user_password", "user password", 45, 57);
		obj.flushed();
		
	}
	public void valildateLoginLocation(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userNLocation");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.valildateLocation("name", "login", "login", 458, 579);
		obj.flushed();
		
	}
	public void validateUserNamelogin(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userNameLogin");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.clickbutton("driver", "Login", "Login");
		obj.flushed();
	}
	
	public void validateUserpasswordLogin(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userPasswordLocation");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
	     obj.clickbutton("driver", "Login", "Login");
		obj.flushed();
	}	
	public void validateLogin(String testCaseName) {
		WebUtil obj=new WebUtil();
		obj.generateRepot("userlogin");
		obj.initlog(testCaseName);
		obj.Browerlaunch("Chrome");
		obj.forURLhit("http://localhost:8888/");
		obj.clickbutton("driver","Login", "Login");
		obj.flushed();
		
	}
}