package Infra;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Listeners(ExtentReportListener.class)
public class BasePage
{
    protected WebDriver driver;

    public static Logger logger = LogManager.getLogger(BasePage.class);

    //Backup File Location
    final String relativeDownloadLocation = "D:\\IdeaProjects\\A21_ReportAutomation\\Downloads";

    //File Location for Back-End Service
    final String absoluteDownloadLocation = "D:\\IdeaProjects\\backend-service\\src\\main\\resources\\report";

    public ChromeOptions getOptions()
    {
        ChromeOptions options = new ChromeOptions();
        Map<String, String> prefs = new HashMap<>();
        prefs.put("download.default_directory", absoluteDownloadLocation);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");

        return options;
    }

    @BeforeClass
    public void openBrowser() throws InterruptedException {

        logger.info("=======================================================");
        logger.info("START SIMULATOR");
        logger.info("=======================================================\n");
        Thread.sleep(2000);

        driver = new ChromeDriver(getOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeTest
    public void ClearFolders() throws IOException {
        File dictionary = new File(absoluteDownloadLocation);
        FileUtils.cleanDirectory(dictionary);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException, IOException {

        logger.info("=======================================================");
        logger.info("END SIMULATOR");
        logger.info("=======================================================\n");
        Thread.sleep(2000);

        driver.quit();

        // Copy downloaded files to the second directory
        File backupDirectory = new File(relativeDownloadLocation);
        FileUtils.copyDirectory(new File(absoluteDownloadLocation), backupDirectory);
    }
}
