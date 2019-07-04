package com.yusun.cartracker.protocol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yusun.cartracker.helper.DataConverter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class CommandPositionEnTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDecode() {
		CommandPositionEn decoder = new CommandPositionEn();
		String text = "797900BB9700B500000001414444524553532626004A004D00300031"
				+"002D00380039003700330031003A0053004F005300200061006C0061007200"
				+"6D002E0068007400740070003A002F002F006D006100700073002E0067006F"
				+"006F0067006C0065002E0063006F006D002F006D006100700073003F007100"
				+"3D004E00320032002E00350037003300350036002C0045003100310033002E"
				+"00390032003100370031262638363133343231363332363939000000000000"
				+"0000232300168EA50D0A";
		decoder.decode(binary(text));
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
