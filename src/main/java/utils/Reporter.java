package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

class Reporter {

    private static ExtentReports reports;
    private static final String REPORT_FILE = "src/test/java/report/report.html";

    static ExtentReports getReports() {
        if (reports == null) {
            createInstance();
        }
        return reports;
    }



    private static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORT_FILE);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(REPORT_FILE);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        return reports;
    }



}
