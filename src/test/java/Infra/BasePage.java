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
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Listeners(ExtentReportListener.class)
public class BasePage
{
    protected WebDriver driver;

    public static Logger logger = LogManager.getLogger(BasePage.class);

    final String relativeDownloadPath = "/Downloads";
    // Get the project directory
    final String projectDir = System.getProperty("user.dir");
    // Construct the absolute download directory path
    final String downloadLocation = Paths.get(projectDir, relativeDownloadPath).toString();

    public ChromeOptions getOptions()
    {
        ChromeOptions options = new ChromeOptions();

        Map<String, String> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadLocation);
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
    public void ClearFolder() throws IOException {
        File dictionary = new File(downloadLocation);
        FileUtils.cleanDirectory(dictionary);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        logger.info("=======================================================");
        logger.info("END SIMULATOR");
        logger.info("=======================================================\n");
        Thread.sleep(2000);

        driver.quit();
    }
}
