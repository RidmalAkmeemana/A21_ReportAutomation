package Test;

import Infra.BasePage;
import Pages.AvailabilityReportPage;
import Pages.LoginPage;
import Pages.ReportPage;
import Validations.LoginValidation;
import Validations.ReportValidation;
import org.testng.annotations.Test;

public class AvailabilityReport extends BasePage
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

    @Test(priority = 2, description = "Load Availability Report")
    public void LoadAvailabilityReport() throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("LOAD AVAILABILITY REPORT");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        ReportPage reportPage = new ReportPage(driver);
        ReportValidation reportValidation = new ReportValidation(driver);

        logger.info("CLICK ON VIEW BUTTON IN AVAILABILITY REPORT \n");
        reportPage.ViewAvailabilityReport();
        Thread.sleep(2000);

        //Validate Availability Report Page

        reportValidation.AvailabilityReport();
        Thread.sleep(2000);

        AvailabilityReportPage availabilityReportPage = new AvailabilityReportPage(driver);

        availabilityReportPage.switchFrame();
        Thread.sleep(2000);

        availabilityReportPage.selectSeason();
        logger.info("SELECT ALL SEASONS");
        Thread.sleep(2000);

        availabilityReportPage.selectVessel();
        logger.info("SELECT ALL VESSELS");
        Thread.sleep(2000);

        availabilityReportPage.selectTour();
        logger.info("SELECT ALL TOURS");
        Thread.sleep(2000);

        availabilityReportPage.ViewReport();
        logger.info("CLICK ON VIEW REPORT BUTTON \n");
        Thread.sleep(2000);


        //Validate Availability Report

        reportValidation.ViewAvailabilityReport();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("AVAILABILITY REPORT LOADED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

    }

    @Test(priority = 3, description = "Download Availability Report")
    public void DownloadAvailabilityReport() throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("DOWNLOAD AVAILABILITY REPORT");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        AvailabilityReportPage availabilityReportPage = new AvailabilityReportPage(driver);
        ReportValidation reportValidation = new ReportValidation(driver);

        availabilityReportPage.selectDownloadFormat();
        logger.info("CLICK ON SAVE REPORT BUTTON");
        Thread.sleep(2000);

        availabilityReportPage.downloadCSV();
        logger.info("CLICK ON DOWNLOAD CSV REPORT BUTTON \n");
        Thread.sleep(2000);

        // Validate Availability Report
        reportValidation.DownloadSuccess();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("AVAILABILITY REPORT DOWNLOADED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

    }
}
