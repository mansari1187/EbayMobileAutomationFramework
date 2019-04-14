package framework_classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Productdetailspage {
	
	/**
	 * Wrapper Class for Driver.findElemnt 
	 * 
	 * @param driver
	 * @param objecttypeandvalue
	 * @return
	 * @throws IOException
	 */
	public  static WebElement getObject(RemoteWebDriver driver,String objecttypeandvalue) throws IOException
	{
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Ebayapp.properties");
		OR.load(fp);
		
		String objecttypeandvalues = OR.getProperty(objecttypeandvalue);
		
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0]; 
		System.out.println("obj type: " + objecttype);
		String objectvalue = splits[1];
		System.out.println("obj val: " + objectvalue);
			
		if (objecttype.equalsIgnoreCase("id"))
		{
			return driver.findElement(By.id(objectvalue));
		}
		else if (objecttype.equalsIgnoreCase("xpath"))
    	{
    		return driver.findElement(By.xpath(objectvalue));	
    			
    	}	
    	else if (objecttype.equalsIgnoreCase("name"))
        {
    		return driver.findElement(By.name(objectvalue));
    	}
    	/*else if (objecttype.equalsIgnoreCase("class"))
    	{
    		return driver.findElementBy;
    	}*/
    	else if (objecttype.equalsIgnoreCase("class"))
    	{
    		return driver.findElementByClassName(objectvalue);
    	}
    	else if (objecttype.equalsIgnoreCase("linktext"))
    	{
    		return driver.findElement(By.linkText(objectvalue));
    	}
	    else if (objecttype.equalsIgnoreCase("css"))
	    {
	    	return driver.findElement(By.cssSelector(objectvalue));
	    }
	   
		return null;
		}

		
		
	}


