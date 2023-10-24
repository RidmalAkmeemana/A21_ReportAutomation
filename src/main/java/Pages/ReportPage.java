package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {


private WebDriver driver;
    @FindBy(xpath="//tbody/tr[1]/td[3]/a[1]")
    WebElement availabilityReport;

    @FindBy(xpath = "//h1[contains(text(),'Report: Availability Report')]")
    WebElement getReportPageHeading;

    public ReportPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ViewAvailabilityReport() throws InterruptedException {
        availabilityReport.click();
        Thread.sleep(2000);
    }

    public String getAvailabilityReportExpectedPageHeading()
    {
        String Title = "Report: Availability Report";
        return Title;
    }

    public String getActualScreenName()
    {
        String Title = getReportPageHeading.getText();
        return Title;
    }

}
