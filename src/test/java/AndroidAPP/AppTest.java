package AndroidAPP;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import framework_classes.BaseClass;
import framework_classes.Productdetailspage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reusable.UserAccess;


public class AppTest extends BaseClass {
	
	//RemoteWebDriver driver ;
	public static String SearchCountry=null;
	public static String Product_value=null;

	AndroidDriver<AndroidElement> driver;
	UserAccess access = new UserAccess();

	
	/**
	 * Capablities Call via Static Method in Before Class in TestNg
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@BeforeClass
	public void Desiredcapablities() throws InterruptedException, IOException
	{
		System.out.println("before first");
		driver = Capablities();
		Thread.sleep(4000);
		System.out.println("now test");
	}

	
	/*  First Test For Ebay App
	 * 	Launch the ebay app.
	 *	Click on hamburger Menu.
	 *	Then click on Settings tab.
	 *	Navigate to Settings page and Search Country/region as Australia with Assertion 
	 **/
	
	@Test
	public void Test1() throws IOException, InterruptedException
	{  
		
		int country=datatable.getRowCount("Search_Keywords");
		SearchCountry=datatable.getCellData("Search_Keywords", "Country_Region", country);
		Productdetailspage.getObject(driver, "Click_Humberger").click();
	    Productdetailspage.getObject(driver, "Click_Setting").click();
	    Productdetailspage.getObject(driver, "Click_Country_Region").click();
	    WebElement touch=Productdetailspage.getObject(driver, "Click_AutoDetect");
	    access.SingleTouch(driver ,touch);
	    String Actual_value_Detect=Productdetailspage.getObject(driver, "Auto_Detect").getText();
	    Assert.assertEquals(Actual_value_Detect, "OFF");
	    Productdetailspage.getObject(driver, "Click_Region").click();
	    Productdetailspage.getObject(driver, "Search_Text").sendKeys(SearchCountry);
	    String Searchcity = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));";
	    access.Scrollview(driver, Searchcity);
	    String SelectExpectedCountry = Productdetailspage.getObject(driver, "Click_City").getText();
	    Productdetailspage.getObject(driver, "Click_City").click();
	    String SelectedActualCountry = Productdetailspage.getObject(driver, "Selected_Country_Region").getText();
	    Assert.assertEquals(SelectedActualCountry, SelectExpectedCountry);
	    Productdetailspage.getObject(driver, "Click_Back_Arrow").click();
	    
	 }
	
	/**
	 * Click on Product And verify Rate in Cart 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	@Test
	public void Test2() throws IOException, InterruptedException
	{
		int ProductDetails=datatable.getRowCount("Search_Keywords");
		Product_value=datatable.getCellData("Search_Keywords", "ProductValue", ProductDetails);
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		Productdetailspage.getObject(driver, "Search_Product").sendKeys(Product_value);
		Productdetailspage.getObject(driver, "Click_TopMost_DropDown").click();
		Thread.sleep(4000);
		String ExpectedDescription=Productdetailspage.getObject(driver, "Expected_Value_Product").getText();
		String ExpectedProductPrice = Productdetailspage.getObject(driver, "Expected_Price_Product").getText();
        Productdetailspage.getObject(driver, "Click_TopMost_Search_Product").click();
        Thread.sleep(4000);
		String ActualDescription=Productdetailspage.getObject(driver, "Actual_Value_Product").getText();
		System.out.println(ActualDescription);
		Assert.assertEquals(ActualDescription, ExpectedDescription);
		String ActualProductPrice = Productdetailspage.getObject(driver, "Actual_Price_Product").getText();
		System.out.println(ActualProductPrice);
		Assert.assertEquals(ActualProductPrice, ExpectedProductPrice);
		
	}
	
	
	

}
