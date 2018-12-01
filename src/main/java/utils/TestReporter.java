package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReporter implements ITestListener {

    private static ExtentReports extentReports = Reporter.getReports();
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult iTestResult) {
        ExtentTest child = parentTest.get().createNode(iTestResult.getMethod().getMethodName());
        test.set(child);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        test.get().pass("Test passed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        test.get().fail(iTestResult.getThrowable());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        test.get().skip(iTestResult.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        ExtentTest parent = extentReports.createTest(getClass().getName());
        parentTest.set(parent);
    }

    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
