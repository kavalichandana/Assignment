package com.Assignment.Tests;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.Assignment.constants.BaseTestFlipkart;

public class FlipkartPage extends BaseTestFlipkart {
	@Test(priority = 1)
	public void flipkartpagetest() throws InterruptedException {
		preCondition2();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"))
				.sendKeys("iphone XR(64GB)-Yellow");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		String expectedname = "Apple iPhone XR (Yellow, 64 GB)";
		String actualname = driver.findElement(By.xpath("//div[text()='Apple iPhone XR (Yellow, 64 GB)']")).getText();
		assertEquals(expectedname, actualname);
		System.out.println("user identified the correct product");
		driver.findElement(By.xpath("//div[text()='Apple iPhone XR (Yellow, 64 GB)']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		java.util.Iterator<String> it = allwindows.iterator();
		String firstwindow = it.next();
		String phonewindow = it.next();
		driver.switchTo().window(phonewindow);
		Thread.sleep(3000);
		String flipkartprice = driver.findElement(By.className("_1vC4OE _3qQ9m1")).getText();
		System.out.println(flipkartprice);
	}
}
