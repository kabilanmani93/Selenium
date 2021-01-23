package com.reports;

import com.utils.ReadPropertyFile;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utils.TestUtils;

public class LogStatus {

	private LogStatus() {
		//private to avoid initialization
	}
	public static void pass(String message)
	{
		ExtentManager.getExtTest().log(Status.PASS, message);

	}

	public static void fail(String message)
	{
		ExtentManager.getExtTest().log(Status.FAIL, message);
	}

	public static void fail(Exception message)
	{
		ExtentManager.getExtTest().log(Status.FAIL, message);
	}

	public static void fail(AssertionError a)
	{
		ExtentManager.getExtTest().log(Status.FAIL, a);
	}

	public static void info(String message)
	{
		ExtentManager.getExtTest().log(Status.INFO, message);
	}

//	public static void error(String message)
//	{
//		ExtentManager.getExtTest().log(Status.ERROR, message);
//	}
//
//	public static void fatal(String message)
//	{
//		ExtentManager.getExtTest().log(Status.FATAL, message);
//	}

	public static void skip(String message)
	{
		ExtentManager.getExtTest().log(Status.SKIP, message);
	}

//	public static void unknown(String message)
//	{
//		ExtentManager.getExtTest().log(Status.UNKNOWN, message);
//	}

	public static void warning(String message)
	{
		ExtentManager.getExtTest().log(Status.WARNING, message);
	}
	public static void pass(String string, String addScreenCapture) {

		if(ReadPropertyFile.get("PassedStepsScreenshots").equalsIgnoreCase("yes")) {
			ExtentManager.getExtTest().pass("<b><font color =red>" + "Screenshot of Failure:" + "</font></b>" ,
					MediaEntityBuilder.createScreenCaptureFromPath(addScreenCapture).build());
		}
	}

	public static void fail(String string, String addScreenCapture)
	{

		if(ReadPropertyFile.get("FailedStepsScreenshots").equalsIgnoreCase("yes")) {
			ExtentManager.getExtTest().pass("<b><font color =green>" + "Screenshot of Pass:" + "</font></b>" ,
					MediaEntityBuilder.createScreenCaptureFromPath(addScreenCapture).build());
		}



	}

	public static void skip(String string, String addScreenCapture)
	{
		if(ReadPropertyFile.get("SkippedStepsScreenshots").equalsIgnoreCase("yes")) {
			ExtentManager.getExtTest().skip("<b><font color =green>" + "Screenshot of Skipped:" + "</font></b>" ,
					MediaEntityBuilder.createScreenCaptureFromPath(addScreenCapture).build());

			//ExtentManager.getExtTest().log(Status.SKIP, string,ExtentManager.getExtTest().addBase64ScreenShot("data:image/png;base64,"+TestUtils.getBase64Image(addScreenCapture)));
		}

	}
}

//String methodName = result.getMethod().getMethodName();
//        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//        extentTest.get().fail("<details><summary><b><font color =red>" + "Exception Occured, click to see details:" +
//                "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>")+"</details> \n");
//
//
//        // Find the correct driver
//        WebDriver driver = null;
//        Object testObject = result.getInstance();
//        Class clazz = result.getTestClass().getRealClass();
//        try
//        {
//            driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
//        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//            e.printStackTrace();
//        }
//
//        //pass the above driver and take sc
//        try
//        {
//            String path = Helper.takeScreenshot(driver,methodName);
//            //extentTest.get().addScreenCaptureFromPath(path,methodName);
//            extentTest.get().fail("<b><font color =red>" + "Screenshot of Failure:" + "</font></b>" ,
//                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }