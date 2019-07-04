package com.yusun.cartracker.protocol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yusun.cartracker.helper.DataConverter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class CommandPositionChTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDecode() {
		CommandPositionCh decoder = new CommandPositionCh();
		decoder.decode(binary("78786E1768000000014144445245535326264F4D7F6E003A5E7F4E1C7701002E60E05DDE5E02002E60E057CE533A002E4E915C71897F8DEF002E79BB60E05DDE5E025B665927655980B27EA6003200357C73002E262638363133343231363332363939000000000000000023230016C1EC0D0A"));
		assertNotNull(decoder.address);
		assertNotNull(decoder.phoneNum);
		System.out.println(decoder.address);
		System.out.println(decoder.phoneNum);
		assertEquals("8613421632699", decoder.phoneNum);
	}
	
    protected ByteBuf binary(String... data) {
        return Unpooled.wrappedBuffer(DataConverter.parseHex(concatenateStrings(data)));
    }
    
    private String concatenateStrings(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

}
