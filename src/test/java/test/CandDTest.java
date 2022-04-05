package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CategoryandDatePage;
//import page.CategoryandDatePage;
import util.BrowserFactory;

public class CandDTest {
	WebDriver driver;
	CategoryandDatePage categoryanddatepage;
	
	@BeforeClass
	public void startBrowser() {
		driver = BrowserFactory.init();
	}
	
	@Test(priority = 1)
	public void validateCategory() throws InterruptedException {
	 
		
		CategoryandDatePage categoryanddatePage = PageFactory.initElements(driver,CategoryandDatePage.class );
	    categoryanddatePage.insertCategoryName("panda");
		categoryanddatePage.clickaddcategoryButton();
		Assert.assertNotEquals("panda426" , categoryanddatePage.newEntry());
		System.out.println("New Category is dispalyed as: " + categoryanddatePage.newEntry());
 
	 
	}
	@Test(priority = 2)
	public void  userisnotabletoaddaduplicatedcategory() throws InterruptedException {
	 
		
		CategoryandDatePage categoryanddatePage = PageFactory.initElements(driver,CategoryandDatePage.class );
		categoryanddatePage.duplicateCategoryName("panda426");
		categoryanddatePage.clickaddcategoryButton();
		Assert.assertEquals("Nevermind",categoryanddatePage.alreadyExists());
		System.out.println(categoryanddatePage.alreadyExists() +" ,Category Already Exists!");
		categoryanddatePage.neverMindButton();
		 
	}
	@Test(priority = 3)
	public void userValidatethemonthdropdownhasallthemonths() throws InterruptedException {
	 
		CategoryandDatePage categoryanddatePage = PageFactory.initElements(driver,CategoryandDatePage.class );
		categoryanddatePage.verifyMonths();
		Assert.assertTrue(categoryanddatePage.verifyMonths());
		System.out.println("All months present in Dropdown");
 
	 
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		BrowserFactory.tearDown();
	}
}
