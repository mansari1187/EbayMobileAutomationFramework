package framework_classes;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static AndroidDriver<AndroidElement> driver;
	static DesiredCapabilities cap;
	public static Xls_Reader datatable=null;
	
	/**
	 * Load Test Data at Run Time 
	 * @throws IOException
	 */
	
	@BeforeSuite
	public void testdata() throws IOException
	{
		
		System.out.println("Test data Printed: ");
		
		// Loading Test Data
		datatable=new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\resources\\Keywords.xlsx");
		
	}
	
	/**
	 * Static Method for Desired Capablities 
	 * @return
	 * @throws IOException
	 */
	
	public static AndroidDriver<AndroidElement> Capablities() throws IOException
	{
		File f = new File("src");
		File fs = new File(f,"eBay.apk");
		
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		OR.load(fp);
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, OR.getProperty("REALDEVICE.NAME"));
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
		driver = new AndroidDriver<AndroidElement>(new URL(OR.getProperty("APPIUM.SERVER.URL")), cap);
		return driver;
	}
	
	

}
