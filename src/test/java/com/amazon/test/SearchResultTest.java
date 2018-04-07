package com.amazon.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONException;
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

	SearchData getTestData() throws JSONException, Exception {
		SearchData sd = new SearchData();

		sd.setSearchCatagory(jh.readJSON().getString("searchCatagory"));
		sd.setSearchItem(jh.readJSON().getString("searchProduct"));
		sd.setResultSet(jh.readJSON().getString("resultSet"));
		return sd;

	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		jh = new JsonHandler();

	}

	@Test(priority = 1)
	public void openHomePage() throws JSONException, Exception {
		homePage.openPage(prop.getProperty("url"));
		Assert.assertEquals(jh.readJSON().getString("title"), TestUtil.getTitle());

	}

	@Test(priority = 2)
	public void searchProudct() throws JSONException, Exception {

		homePage.selectOption(getTestData()).enterSearchItem(getTestData());
		String srh = homePage.searchprg.getText();
		al.add(homePage.getTitle(getTestData()));
		Assert.assertTrue(srh.contains(jh.readJSON().getString("searched")));

	}

	@AfterClass
	public void tierDown() {
		driver.quit();
	}

}
