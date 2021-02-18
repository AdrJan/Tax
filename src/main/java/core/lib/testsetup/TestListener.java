package core.lib.testsetup;

import core.lib.manager.logger.TaxLogger;
import core.lib.testbase.TestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
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
