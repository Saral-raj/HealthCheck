package testRunner;

import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentReportUtil;

import java.io.IOException;

import static utilities.ReportUtil.features;

public class NGTestListener implements ITestListener {
ExtentReportUtil extentReportUtil = new ExtentReportUtil();
    @Override
        public void onTestStart(ITestResult iTestResult) {
            System.out.println("On test start");
        }
        @Override
        public void onTestSuccess(ITestResult iTestResult) {

            System.out.println("On test Success");
        }
        @Override
        public void onTestFailure(ITestResult iTestResult) {
            System.out.println("On test failure");

            try{
                extentReportUtil.ExtentReportScreenshot();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            System.out.println("On test skipped");
        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
            System.out.println("On test percentage");
        }
        @Override
        public void onStart(ITestContext iTestContext) {
            System.out.println("On start");

            extentReportUtil.ExtentReport();

            //ToDo: Feature - Hard coding the feature name
             features = extentReportUtil.extent.createTest(Feature.class, "TestNewsPage.feature");

        }
        @Override
        public void onFinish(ITestContext iTestContext) {
            System.out.println("On finish");
            extentReportUtil.FlushReport();
        }
    }


