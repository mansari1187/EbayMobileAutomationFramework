package Reusable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import framework_classes.BaseClass;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class UserAccess extends BaseClass {
	//AndroidDriver<AndroidElement> driver;
	//RemoteWebDriver driver;
	TouchAction  touch;
	MultiTouchAction multitouch;
	
	/**
	 *For Single Touch Method for Mobile Application
	 * @param driver
	 * @param webelement
	 * @return
	 */
	
	public WebElement SingleTouch(AndroidDriver<AndroidElement> driver, WebElement webelement)
	{
		touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(webelement))).perform();
		return webelement;
	}
	
	/**
	 * For Long Press Option in Mobile Application Method
	 * @param driver
	 * @param webelement
	 * @return
	 */
	
	public WebElement longpress(AndroidDriver<AndroidElement> driver,WebElement webelement)
	{	
		touch = new TouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(webelement)).withDuration(ofSeconds(2))).perform();
		return webelement;
	}
	/**
	 * for Drag and Drop down method
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void DragandDrop(AndroidDriver<AndroidElement> driver,WebElement src ,WebElement dest)
	{
		touch = new TouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(src))).moveTo(element(dest)).perform();
			
	}
	
	/**
	 * For Scrolling Method
	 * @param driver
	 * @param scrollPoint
	 */
	
	public void Scrollview(AndroidDriver<AndroidElement> driver ,String scrollPoint )
	{
		driver.findElementsByAndroidUIAutomator(scrollPoint);
	}
	
	
}
