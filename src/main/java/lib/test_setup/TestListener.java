package lib.test_setup;

import io.qameta.allure.Attachment;
import lib.manager.logger.TaxLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestSetup implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        driver = driver();
        if (driver != null) {
            TaxLogger.info("Test failed. Taking screenshot.");
            takeScreenshot();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
