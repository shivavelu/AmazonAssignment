package com.amazon.test;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.access.SearchData;
import com.amazon.base.TestBase;
import com.amazon.customexception.CustomExceptions;
import com.amazon.pages.HomePage;
import com.amazon.util.JsonHandler;
import com.amazon.util.TestUtil;

public class SearchResultTest extends TestBase {
	HomePage homePage;
	JsonHandler jh;

	ArrayList<String> al = new ArrayList<String>();

	public SearchResultTest() {
		super();
	}

	SearchData getTestData() throws Exception {
		SearchData sd = new SearchData();

		try {
			sd.setSearchCatagory((String)jh.readJSON().get("searchCatagory"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sd.setSearchItem((String)jh.readJSON().get("searchProduct"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sd.setResultSet((String)jh.readJSON().get("resultSet"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sd;

	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		jh = new JsonHandler();

	}

	@Test(priority = 1)
	public void openHomePage() throws Exception {
		homePage.openPage(prop.getProperty("url"));
		Assert.assertEquals((String)jh.readJSON().get("title"), TestUtil.getTitle());

	}

	@Test(priority = 2)
	public void searchProudct() throws Exception {

		homePage.selectOption(getTestData()).enterSearchItem(getTestData());
		String srh = homePage.searchprg.getText();
		al.add(homePage.getTitle(getTestData()));
		Assert.assertTrue(srh.contains((String)jh.readJSON().get("searched")));

	}

	@AfterClass
	public void tierDown() {
		driver.quit();
	}

}
