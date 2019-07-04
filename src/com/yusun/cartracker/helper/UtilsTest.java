package com.yusun.cartracker.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsValidVrl() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckIP() {		
		assertTrue(Utils.isValidVrl("192.168.1.181"));
		assertFalse(Utils.isValidVrl("192.168.181"));
		
		assertTrue(Utils.isValidVrl("www.baidu.com"));
		assertTrue(Utils.isValidVrl("http://www.baidu.com"));
		assertTrue(Utils.isValidVrl("https://www.baidu.com"));
		assertFalse(Utils.isValidVrl("baidu"));
	}
	
	@Test
	public void testJoin() {
		String[] s = {"1", "2", "3"};
		assertEquals("1,2,3", Utils.join(s, ","));
	}

}
