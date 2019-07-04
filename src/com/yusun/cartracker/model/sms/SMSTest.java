package com.yusun.cartracker.model.sms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yusun.cartracker.api.Hardware;
import com.yusun.cartracker.model.sms.abs.SMS;


public class SMSTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testServer() {
		SMS sms = SMS.fromSms("1234567", "SERVER,666666,0,202.173.231.112,8821,0#");
		assertNotNull(sms);
		String[] pm = sms.content.split(",");
		String ip = pm[1].trim();
		String port = pm[2].trim();
		assertEquals("202.173.231.112", ip);
		assertEquals("8821", port);		
	}
	@Test
	public void testTimer(){
		SMS sms = SMS.fromSms("1234567", "TIMER,666666, 2,10,30#");
		assertNotNull(sms);
		String[] pm = sms.content.split(",");
		int lbs = Integer.parseInt(pm[0].trim());	
		int gps = Integer.parseInt(pm[1].trim());
		int gpsWork = Integer.parseInt(pm[2].trim());
        assertEquals(lbs, 2);
        assertEquals(gps, 10);
        assertEquals(gpsWork, 30);
	}
	@Test
	public void testApn(){
		SMS sms = SMS.fromSms("1234567", "APN,666666, CMNET,admin,123456,0#");
		String[] pm = sms.content.split(",");
		assertEquals("CMNET", pm[0].trim());
		assertEquals("admin", pm[1].trim());
		assertEquals("123456", pm[2].trim());				
	}
}
