package com.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.constants.Constants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.utils.ReadPropertyFile;

public class ExtentReport {

	public static ExtentReports extent;
//	public static ExtentTest logger=null;
	public static String extentreportpath="";
	

	//To avoid external initialization
	private ExtentReport() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		if(ReadPropertyFile.get("OverrideResults").equalsIgnoreCase("yes")) 
		{
			if(ReadPropertyFile.get("ResultPath").equals("")) 
			{
				extentreportpath=Constants.PROJECTPATH+"\\ExtentReports\\Test Report.html";
				
			}
			else {
				extentreportpath=ReadPropertyFile.get("ResultPath")+"\\ExtentReports\\Test Report.html";
			}
		}
		else 
		{
			if(ReadPropertyFile.get("ResultPath").equals("")) 
			{
				extentreportpath=Constants.PROJECTPATH+"\\ExtentReports\\Test Report_"+currentDate+".html";
			}
			
			else
			{
				extentreportpath=ReadPropertyFile.get("ResultPath")+"\\ExtentReports\\Test Report_"+currentDate+".html";
				
			}

		}

		ExtentSparkReporter reporter = new ExtentSparkReporter(extentreportpath);
		reporter.config().setReportName("eShipper Web Automation");
		reporter.config().setDocumentTitle("eShipper Test Results");


		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Kabilan Mani");


		//extent.loadConfig(new File(Constants.EXTENTCONFIGPATH));
	}

	public static void initialize()
	{
		ExtentReport report=new ExtentReport();
	}

}
