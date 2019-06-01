package ca.process.extension;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import ca.process.data.createAndRunData;

public class ListenerCustom implements ITestListener{
	
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			GetScreenshot.capture(result.getName());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
