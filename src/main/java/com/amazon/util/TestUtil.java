package com.amazon.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.amazon.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	public static String TESTDATA_SHEET_PATH = "/Users/naveenkhunteta/Documents/workspace"
			+ "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	public static JavascriptExecutor executor;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void waitforElementVisable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitforElementClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitforAlertPresent() {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void javaScriptElementClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void javaScriptElementScroll(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void dropdownVisbileText(WebElement element, String visibleText) {
		Select sb = new Select(element);
		sb.selectByVisibleText(visibleText);
	}

	public static void dropdownValue(WebElement element, String value) {
		Select sb = new Select(element);
		sb.selectByValue(value);
	}

	public static void dropdownIndex(WebElement element, int index) {
		Select sb = new Select(element);
		sb.selectByIndex(index);
	}

	public static void sendKeyByAction(WebElement element, String key) {
		Actions action = new Actions(driver);
		action.sendKeys(element, key);

	}

	public static void sendkeyByJavaScript(WebElement element, String value) {

		executor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public static String getTitle() {
		return driver.getTitle();
	}

}
