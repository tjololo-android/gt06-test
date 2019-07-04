package com.yusun.cartracker.model.sms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yusun.cartracker.model.FenceCircle;
import com.yusun.cartracker.model.FenceRectangle;
import com.yusun.cartracker.model.sms.abs.SMS;

public class FENCEtest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFence() {
		String s1 = "FENCE,666666,ON,1,N23,W114,N24,E114#";
		String s2 = "FENCE,666666,ON,1,N23,W114,N24,E114,OUT#";
		String s3 = "FENCE,666666,ON,1,N23,W114,N24,E114,IN#";
		String s4 = "FENCE,666666,ON,0,N23,W114,10#";
		String s7 = "FENCE,666666,ON,0,0,0,10#";
	
		SMS msg = SMS.fromSms("777777", s1);
		FENCE f = new FENCE();
		FenceRectangle fr = (FenceRectangle) f.getFence(msg);
		assertNotNull(fr);
		assertEquals(23.0, fr.getLeftTopLan(), 0.1);
		assertEquals(-114, fr.getLeftTopLon(), 0.1);
		assertEquals(24, fr.getRightBottomLan(), 0.1);
		assertEquals(114, fr.getRightBottomLon(), 0.1);
		assertNull(fr.getType());
		assertEquals("ON", fr.getState());
		
		msg = SMS.fromSms("777777", s2);
		f = new FENCE();
		fr = (FenceRectangle) f.getFence(msg);
		assertNotNull(fr);
		assertEquals(23, fr.getLeftTopLan(), 0.1);
		assertEquals(-114, fr.getLeftTopLon(), 0.1);
		assertEquals(24, fr.getRightBottomLan(), 0.1);
		assertEquals(114, fr.getRightBottomLon(), 0.1);
		assertEquals("OUT", fr.getType());
		assertEquals("ON", fr.getState());
		
		msg = SMS.fromSms("777777", s3);
		f = new FENCE();
		fr = (FenceRectangle) f.getFence(msg);
		assertNotNull(fr);
		assertEquals(23, fr.getLeftTopLan(), 0.1);
		assertEquals(-114, fr.getLeftTopLon(), 0.1);
		assertEquals(24, fr.getRightBottomLan(), 0.1);
		assertEquals(114, fr.getRightBottomLon(), 0.1);
		assertEquals("IN", fr.getType());
		assertEquals("ON", fr.getState());		
		
		msg = SMS.fromSms("777777", s4);
		f = new FENCE();
		FenceCircle fc = (FenceCircle) f.getFence(msg);
		assertNotNull(fc);
		assertEquals(23, fc.getLat(), 0.1);
		assertEquals(-114, fc.getLon(), 0.1);
		assertEquals(1000, fc.getRadius());	
		assertNull(fc.getType());
		assertEquals("ON", fc.getState());	
		
		msg = SMS.fromSms("777777", s7);
		f = new FENCE();
		fc = (FenceCircle) f.getFence(msg);
		assertNotNull(fc);
		assertEquals(0, fc.getLat(), 0.1);
		assertEquals(0, fc.getLon(), 0.1);
		assertEquals(1000, fc.getRadius());	
		assertNull(fc.getType());
		assertEquals("ON", fc.getState());
	}

}
