package com.FDX.Generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class FrameworkListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Starting test: "+result.getName(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		int v = result.getStatus();
		String s=Integer.toString(v);
		
		if(s=="1")
		{
		Reporter.log("Status: "+v,true);
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String time=Utility.date();
		String path="E:\\JAVA_Selenium\\FDX\\screenshots"+time;
		Reporter.log("Test failed,screenshot taken @ "+path, true);
		Utility.getScreenPrint(path+".png");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
