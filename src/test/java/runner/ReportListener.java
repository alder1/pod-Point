package runner;

import base.FrameworkInitialize;
import utilities.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ReportListener extends FrameworkInitialize implements ITestListener {

    public synchronized void onTestStart(ITestResult iTestResult) {
        System.out.println("On Test Start");
    }
    public synchronized void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On Test Success");
    }
    public synchronized void onTestFailure(ITestResult iTestResult) {
        System.out.println("On Test Failure");
        ExtentReport.getScenario().createNode("Failed "+ iTestResult.getInstanceName()).fail(iTestResult.getThrowable());
    }
    public synchronized void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On Test Skipped");
    }
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test Percentage");
    }
    public synchronized void onStart(ITestContext iTestContext) {
        System.out.println("On Test Start");
    }
    public synchronized void onFinish(ITestContext iTestContext) {
        System.out.println("On Test Finish");
        ExtentReport.flushReport();
    }
}