package AboutGenericMethod;

public class ForMainMethod {

	public static void main(String[] args) {
		TestCaseLayer tcl=new TestCaseLayer();
		tcl.validateUserNameSize("userName");
		tcl.validatePasswordSize("password");
		tcl.validateloginelementsSize("Login");
		tcl.valildateUserNameLocation("userName");
		tcl.valildateUserPassswordLocation("userPassword");
		tcl.valildateLoginLocation("login");
	    tcl.validateUserNamelogin("userName");
		tcl.validateUserpasswordLogin("userPassword");
		tcl.validateLogin("Login");
}
		
		
		

}
		
		
		
		
//	WebInpendent obj = new WebInpendent();
//		obj.Browerlaunch(null);
//	    //obj.Browerlaunch("chrome");
//		obj.forURLhit("http://localhost:8888/");
//		obj.valildateSize("name", "user_name", "UserNameBox", 22, 140);
//		//obj.valildateLocation("name", "user_name", "UserNameBox", 632, 230);
//
//		obj.sizeOfElement("name", "user_name", "username");
//		obj.sizeOfElement("name", "user_password", "userpassword");
//		obj.sizeOfElement("name", "Login", "Login button");
//		// WebInpendent.locationOfElement("name", "user_name", "username");
//		obj.flushed();
//	}
//}
//
////	}
////	public static void main(String[] args) {
////		}	
////	
//// 
////public static void locationOfElementt(String locatorName,String locatorValue,String elementName)  {
////	try {
////	 	WebElement element =searchElement(locatorName, locatorValue);
////	 Point elementpoint	=locationOfElement(element);
////	 System.out.println();
////	 }catch(Exception e) {
////		e.printStackTrace();
////	}
////}
