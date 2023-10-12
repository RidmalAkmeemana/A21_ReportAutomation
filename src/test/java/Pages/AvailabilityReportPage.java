package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class AvailabilityReportPage {

    final String AvailabilityReportFileName = "Availability Report.csv";

    // This is the path where you are downloading the file
    final String downloadLocation = "../A21_ReportAutomation/Downloads";
    private WebDriver driver;

    @FindBy(id="rptViewer_ctl04_ctl03_ddDropDownButton")
    WebElement season;

    @FindBy(id= "rptViewer_ctl04_ctl03_divDropDown_ctl00")
    WebElement selectAllSeason;

    @FindBy(id="rptViewer_ctl04_ctl05_ddDropDownButton")
    WebElement vessel;

    @FindBy(id= "rptViewer_ctl04_ctl05_divDropDown_ctl00")
    WebElement selectAllVessel;

    @FindBy(id= "rptViewer_ctl04_ctl07_ddDropDownButton")
    WebElement tour;

    @FindBy(id= "rptViewer_ctl04_ctl07_divDropDown_ctl00")
    WebElement selectAllTour;

    @FindBy(name = "rptViewer$ctl04$ctl00")
    WebElement viewButton;

    @FindBy(xpath = "//div[contains(text(),'Availability Report')]")
    WebElement reportHeading;

    @FindBy(id = "rptViewer_ctl05_ctl04_ctl00_ButtonImgDown")
    WebElement selectFormat;

    @FindBy(linkText = "CSV (comma delimited)")
    WebElement downloadCSV;


    public AvailabilityReportPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchFrame() throws InterruptedException {
        driver.switchTo().frame(0);
        Thread.sleep(2000);
    }

    public void selectSeason() throws InterruptedException {
        season.click();
        Thread.sleep(2000);

        selectAllSeason.click();
        Thread.sleep(2000);

        season.click();
        Thread.sleep(2000);
    }

    public void selectVessel() throws InterruptedException {
        vessel.click();
        Thread.sleep(2000);

        selectAllVessel.click();
        Thread.sleep(2000);

        vessel.click();
        Thread.sleep(2000);
    }

    public void selectTour() throws InterruptedException {
        tour.click();
        Thread.sleep(2000);

        selectAllTour.click();
        Thread.sleep(2000);

        tour.click();
        Thread.sleep(2000);
    }

    public void ViewReport() throws InterruptedException {
        viewButton.click();
        Thread.sleep(2000);
    }

    public String getExpectedReportHeading()
    {
        String Title = "Availability Report";
        return Title;
    }

    public String getActualReportHeading()
    {
        String Title = reportHeading.getText();
        return Title;
    }

    public void selectDownloadFormat() throws InterruptedException {
        selectFormat.click();
        Thread.sleep(2000);
    }

    public void downloadCSV() throws InterruptedException {
        downloadCSV.click();
        Thread.sleep(2000);
    }

    public boolean getAvailabilityFileName() {
        File folder = new File(downloadLocation);
        File[] listOfFiles = folder.listFiles();

        boolean isFileAvailable = false;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();

                if (fileName.matches(AvailabilityReportFileName)) {
                    isFileAvailable = true;
                }
            }
        }
        return isFileAvailable;
    }

}
