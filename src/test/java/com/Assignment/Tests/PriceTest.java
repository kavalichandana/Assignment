package com.Assignment.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.Assignment.constants.BaseTest;

public class PriceTest extends BaseTest {
	@Test
	public void Pricecomparision() {

		assertEquals(Flipkartprice, amazonprice);
		System.out.println("Bother the websites show same cost for mobiles");
		if (amazonprice > Flipkartprice) {
			System.out.println("Flipkart price is cheaper then amazon price");
		} else {
			System.out.println("Amazon price is cheaper then Flikartprice");
		}

	}
}