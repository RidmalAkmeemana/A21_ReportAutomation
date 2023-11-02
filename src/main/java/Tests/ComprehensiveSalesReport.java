package Tests;

import Infra.BasePage;
import Pages.ComprehensiveSalesReportPage;
import Pages.LoginPage;
import Pages.ReportPage;
import Validations.LoginValidation;
import Validations.ReportValidation;
import org.testng.annotations.Test;

public class ComprehensiveSalesReport extends BasePage
{
    public static String username,password, URL;

    @Test(priority = 1, description = "Log In to Rez Magic")
    public void LogIntoRezMagic() throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("LOG IN");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        LoginValidation loginValidation = new LoginValidation(driver);

        //Login Credentials
        URL = "https://antarctica21.rezmagic.com/Staff/Account/Login?ReturnUrl=%2FStaff%2F";
        username = "tliyanage";
        password = "tliyanage123";

        loginPage.openLoginPage(URL);
        logger.info("REDIRECT TO: " +URL);
        Thread.sleep(2000);

        //Enter User Details

        loginPage.fillUsername(username);
        logger.info("ENTER USERNAME: "+username);
        Thread.sleep(2000);

        loginPage.fillPassword(password);
        logger.info("ENTER PASSWORD: "+password);
        Thread.sleep(2000);

        logger.info("CLICK ON LOG IN BUTTON \n");
        loginPage.clickOnLogIn();
        Thread.sleep(2000);

        //Validate Login Page

        loginValidation.LoginSuccess();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("LOG IN SUCCESS");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Load Comprehensive Sales Report Screen")
    public void LoadComprehensiveSalesReport() throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("LOAD REPORTS SCREEN");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        ReportPage reportPage = new ReportPage(driver);
        ReportValidation reportValidation = new ReportValidation(driver);

        logger.info("CLICK ON REPORTS BUTTON \n");
        reportPage.ViewReports();
        Thread.sleep(2000);

        //Validate Report Page

        reportValidation.ReportPage();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("REPORT SCREEN LOADED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("LOAD COMPREHENSIVE SALES REPORT");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        logger.info("CLICK ON VIEW COMPREHENSIVE SALES REPORT BUTTON \n");
        reportPage.ViewComprehensiveSalesReport();
        Thread.sleep(2000);

        //Validate Comprehensive Sales Report

        reportValidation.ViewComprehensiveSalesReportPage();
        Thread.sleep(2000);

        ComprehensiveSalesReportPage comprehensiveSalesReportPage = new ComprehensiveSalesReportPage(driver);

        comprehensiveSalesReportPage.switchFrame();
        Thread.sleep(2000);

        comprehensiveSalesReportPage.selectSeason();
        logger.info("SELECT ALL SEASONS");
        Thread.sleep(2000);

        comprehensiveSalesReportPage.selectVenue();
        logger.info("SELECT ALL VENUES");
        Thread.sleep(2000);

        comprehensiveSalesReportPage.selectTour();
        logger.info("SELECT ALL TOURS");
        Thread.sleep(2000);

        comprehensiveSalesReportPage.includeCancel();
        logger.info("SELECT INCLUDE CANCELLED: TRUE");
        Thread.sleep(2000);

        comprehensiveSalesReportPage.ViewReport();
        logger.info("CLICK ON VIEW REPORT BUTTON \n");
        Thread.sleep(20000);


        //Validate Report

        reportValidation.ViewComprehensiveSalesReport();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("COMPREHENSIVE SALES REPORT LOADED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

    }

    @Test(priority = 3, description = "Download Comprehensive Report")
    public void DownloadComprehensiveReport() throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("DOWNLOAD COMPREHENSIVE REPORT");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        ComprehensiveSalesReportPage comprehensiveSalesReportPage = new ComprehensiveSalesReportPage(driver);
        ReportValidation reportValidation = new ReportValidation(driver);

        comprehensiveSalesReportPage.selectDownloadFormat();
        logger.info("CLICK ON SAVE REPORT BUTTON");
        Thread.sleep(2000);

        comprehensiveSalesReportPage.downloadCSV();
        logger.info("CLICK ON DOWNLOAD CSV REPORT BUTTON \n");
        Thread.sleep(10000);

        // Validate Availability Report

        reportValidation.DownloadSuccess();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("COMPREHENSIVE REPORT DOWNLOADED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

    }
}
