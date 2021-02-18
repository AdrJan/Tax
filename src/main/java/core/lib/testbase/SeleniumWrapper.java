package core.lib.testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumWrapper {

    private final WebDriver driver;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement el(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> ell(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String textElx(WebElement webElement) {
        return webElement.getAttribute("innerText");
    }
}
