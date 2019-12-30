package com.Assignment.Tests;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Assignment.constants.BaseTest;

public class AmazonPage extends BaseTest {
	@Test(priority = 0)
	public void AmazonPagetest() throws InterruptedException {
		preCondition1();
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone XR(64GB)-Yellow");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		String expectedname = "Apple iPhone XR (64GB) - Yellow";
		String actualname = driver.findElement(By.xpath("//span[text()='Apple iPhone XR (64GB) - Yellow']")).getText();
		assertEquals(expectedname, actualname);
		System.out.println("user identified the correct product");
		driver.findElement(By.xpath("//span[text()='Apple iPhone XR (64GB) - Yellow']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		java.util.Iterator<String> it = allwindows.iterator();
		String firstwindow = it.next();
		String phonewindow = it.next();
		driver.switchTo().window(phonewindow);
		Thread.sleep(3000);
		String amazonprice = driver
				.findElement(By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']"))
				.getText();
		System.out.println(amazonprice);
	}
}
