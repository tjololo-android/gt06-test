package com.yusun.cartracker.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaiterTest {
	@Test
	public void testOnEcho() {		
		assertFalse(Waiter.instance().wait(100, 3000));
		new Thread(){
			public void run(){
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Waiter.instance().onEcho(100);
			}
		}.start();
		assertTrue(Waiter.instance().wait(100, 3000));
	}
}
