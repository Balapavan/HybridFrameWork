package travelCity.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG {
  
	@BeforeSuite
	public void meth1()
	{
		System.out.println("@BeforeSuite");
	}
	@AfterSuite
	public void meth2()
	{
		System.out.println("@AfterSuite");
	}
	@BeforeTest
	public void meth3()
	{
		System.out.println("@BeforeTest");
	}
	@AfterTest
	public void meth4()
	{
		System.out.println("@AfterTest");
	}
	@BeforeClass
	public void meth5()
	{
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void meth6()
	{
		System.out.println("@AfterClass");
	}
	@BeforeMethod
	public void meth7()
	{
		System.out.println("@BeforeMethod");
	}
	@AfterMethod
	public void meth8()
	{
		System.out.println("@AfterMethod");
	}
	
	@Test(groups="G1")
	public void G1()
	{
		System.out.println("ggggggggggggg11111111111");
	}
	@Test(groups="G1")
	public void G11()
	{
		System.out.println("11111111111");
		
		Set<String> s=new HashSet<String>();
		s.add("111111111111");
		
	}
	@Test(dependsOnGroups="G1")
	public void Groups()
	{
		System.out.println("1-----------");
	}
	
	
	
	
}
