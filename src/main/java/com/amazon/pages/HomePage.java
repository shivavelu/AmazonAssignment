package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.access.SearchData;
import com.amazon.base.TestBase;
import com.amazon.customexception.CustomExceptions;
import com.amazon.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(id = "searchDropdownBox")
	@CacheLookup
	public WebElement drpSearch;

	@FindBy(id = "twotabsearchtextbox")
	@CacheLookup
	public WebElement txtSearch;

	@FindBy(xpath = ".//*[@id='s-result-count']")
	@CacheLookup
	public WebElement searchprg;

	ArrayList<String> al = new ArrayList<String>();

	String result = "//li[@id='result_index']";

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage openPage(String url) {
		driver.get(url);

		return new HomePage();
	}

	public HomePage selectOption(SearchData sd) {
		try {
			TestUtil.dropdownVisbileText(drpSearch, sd.getSearchCatagory());
		} catch (Exception e) {
			throw new CustomExceptions("No such Option availble");
		}

		return new HomePage();
	}

	public HomePage enterSearchItem(SearchData sd) {
		txtSearch.click();
		txtSearch.clear();
		txtSearch.sendKeys(sd.getSearchItem());
		txtSearch.sendKeys(Keys.ENTER);
		return new HomePage();
	}

	public void firstElement() {
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@id='s-results-list-atf']/li[@id='result_0']//div/a/span"));
		for (WebElement w : list) {
			al.add(w.getText());
		}
		System.out.println(list.size());
		System.out.println(al);

	}

	public String getTitle(SearchData sd) {

		return driver.findElement(By.xpath(result.replace("index", sd.getResultSet()))).getText();
	}

}
