package Selenium;

import java.util.NoSuchElementException;

public class PracticeExc {


	public static void main(String[] args) {
		//thros();
		cach();
	}
		
	public static void thros()throws ArithmeticException, NoSuchElementException {
		System.out.println(10/0);
		
		System.out.println(10/2);
	}
	
	
	public static void cach(){
		
		
		
		try{
			System.out.println(10/0);
			//System.out.println("hi");
			
		}catch(ArithmeticException e) {
			System.out.println(10/2);
			e.printStackTrace();
			System.out.println(e);
		}
		
		finally {
			System.out.println("finally");
		}
		
		try{
			
		}
		finally {
			//database.close;
		}
		
		//System.out.println(10/2);
	}
	
	public static void thro() {
		System.out.println(10/2);
		throw new ArithmeticException();
		
		//System.out.println(10/2);
	}
	

}