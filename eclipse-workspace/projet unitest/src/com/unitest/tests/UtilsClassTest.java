package com.unitest.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.unitest.entities.UtilsClass;

class UtilsClassTest {
	
	private int even;
	private int odd;

	@BeforeEach
	void setUp() throws Exception {
		Random r = new Random();
		int randint=r.nextInt(1000);
		this.even = randint*2;
		this.odd = even+1;
	}
	
	@AfterEach
	void tearDown() {
		this.even=0;
		this.odd=0;
	}
	
	@RepeatedTest(9)
	void testIsPair() {
		assertTrue(UtilsClass.isPair(this.even));
		assertFalse(UtilsClass.isPair(this.odd));
	}

}
