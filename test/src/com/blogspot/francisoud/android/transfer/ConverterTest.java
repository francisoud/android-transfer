package com.blogspot.francisoud.android.transfer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blogspot.francisoud.android.transfer.Converter.Power;
import com.blogspot.francisoud.android.transfer.Converter.Unit;

public class ConverterTest {

	@Test
	public void testByte2bit() {
		fail("Not yet implemented");
	}

	@Test
	public void testToBit() {
		// Bit
		assertEquals(0.0, Converter.toBit(0, Power.None, Unit.Bit), 0);
		assertEquals(1.0, Converter.toBit(1, Power.None, Unit.Bit), 0);
		assertEquals(0.0, Converter.toBit(0, Power.Kilo, Unit.Bit), 0);
		assertEquals(1.0, Converter.toBit(1, Power.Kilo, Unit.Bit), 0);
		// Byte
		assertEquals(0.0, Converter.toBit(0, Power.None, Unit.Byte), 0);
		assertEquals(8.0, Converter.toBit(1, Power.None, Unit.Byte), 0);
		assertEquals(0.0, Converter.toBit(0, Power.Kilo, Unit.Byte), 0);
		assertEquals(8.0*1024, Converter.toBit(1, Power.Kilo, Unit.Byte), 0);
	}

	@Test
	public void testFromBit() {
		fail("Not yet implemented");
	}

}
