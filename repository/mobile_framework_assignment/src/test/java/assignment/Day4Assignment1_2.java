package assignment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Day4Assignment1_2 {

	By acceptBtn = By.id("android:id/button1");
	By settings = By.xpath("//*[@text='Settings']");
	By btnSideMenu = By.xpath("//android.widget.ImageButton[@content-desc='Open drawer']");
	By helpAndFeedback = By.xpath("//*[@text ='Help & feedback']");
	By helpText = By.xpath("//android.view.ViewGroup/android.widget.TextView");
	By theme = By.xpath("//*[@text='Theme']");
	By darkTheme = By.xpath("//*[@text='Dark']");


	public AndroidDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException, MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/applications/"+"com.llamalab.automate_199_apps.evozi.com.apk");
		cap.setCapability("autoGrantPermissions", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		Thread.sleep(3000);

	}

	@Test
	public void verifyHelpTest() throws MalformedURLException, InterruptedException
	{
		driver.findElement(acceptBtn).click();
		driver.findElement(btnSideMenu).click();
		driver.findElement(helpAndFeedback).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(helpText).isDisplayed(), "Help text is not present");
		driver.quit();
	}

	@Test
	public void verifyTheme() throws MalformedURLException, InterruptedException
	{
		driver.findElement(acceptBtn).click();
		driver.findElement(btnSideMenu).click();
		driver.findElement(settings).click();
		Thread.sleep(2000);
		driver.findElement(theme).click();
		Thread.sleep(2000);
		driver.findElement(darkTheme).click();
		driver.quit();

	}





}
