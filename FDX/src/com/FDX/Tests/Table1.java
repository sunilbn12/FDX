package com.FDX.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.FDX.Generics.TestBaseFDX;

public class Table1 extends TestBaseFDX{
	
	@Test
	public void m1()
	{
		driver.get("file:///E:/Table1.html");
		AssertJUnit.assertEquals(true,true);
		
		
	}

}
