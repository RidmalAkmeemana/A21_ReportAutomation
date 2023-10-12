package Validations;

import Infra.BasePage;
import Pages.AvailabilityReportPage;
import Pages.ReportPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportValidation extends BasePage {

    private WebDriver driver;

    public ReportValidation(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AvailabilityReport() throws InterruptedException {

        ReportPage reportPage = new ReportPage(driver);

        String ExpectedScreen = reportPage.getAvailabilityReportExpectedPageHeading();
        String ActualScreen = reportPage.getActualScreenName();

        if(ExpectedScreen.equals(ActualScreen))
        {
            logger.info("AVAILABILITY REPORT PAGE LOAD - SUCCESS\n");
            Thread.sleep(2000);
        }
        else
        {
            logger.error("AVAILABILITY REPORT PAGE LOAD - FAILED\n");
            Thread.sleep(2000);
        }
        Assert.assertEquals(ExpectedScreen, ActualScreen, "AVAILABILITY REPORT PAGE LOAD - FAILED | " + ActualScreen);

    }

    public void ViewAvailabilityReport() throws InterruptedException {
        AvailabilityReportPage availabilityReportPage = new AvailabilityReportPage(driver);

        String ExpectedHeading = availabilityReportPage.getExpectedReportHeading();
        String ActualHeading = availabilityReportPage.getActualReportHeading();

        if(ExpectedHeading.equals(ActualHeading))
        {
            logger.info("AVAILABILITY REPORT LOAD - SUCCESS\n");
            Thread.sleep(2000);
        }
        else
        {
            logger.error("AVAILABILITY REPORT LOAD - FAILED\n");
            Thread.sleep(2000);
        }
        Assert.assertEquals(ExpectedHeading, ActualHeading, "AVAILABILITY REPORT PAGE LOAD - FAILED | " + ActualHeading);
    }

    public void DownloadSuccess() throws InterruptedException {
        AvailabilityReportPage availabilityReportPage = new AvailabilityReportPage(driver);

        availabilityReportPage.getAvailabilityFileName();

        boolean isFileAvailable = availabilityReportPage.getAvailabilityFileName();

        if (isFileAvailable) {
            logger.info("AVAILABILITY REPORT DOWNLOAD - SUCCESS \n");
            Thread.sleep(2000);
        } else {
            logger.error("AVAILABILITY REPORT DOWNLOAD - FAILED \n");
            Thread.sleep(2000);
        }
        Assert.assertTrue(isFileAvailable, "AVAILABILITY REPORT DOWNLOAD - FAILED");
    }

}
