package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportUtil extends ReportUtil{
    String fileName = reportLocation + "extentreport.html";

    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("DCT:Test Automation");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Health Checks");
        extent.attachReporter(htmlReporter);

    }
    public void ExtentReportScreenshot() throws IOException {
        File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
    }
    public void FlushReport(){
        extent.flush();
    }


}
