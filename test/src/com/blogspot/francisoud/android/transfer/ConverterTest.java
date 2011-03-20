package com.blogspot.francisoud.android.transfer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blogspot.francisoud.android.transfer.Converter.Power;
import com.blogspot.francisoud.android.transfer.Converter.Unit;

public class ConverterTest {

	@Test
	public void testDevicesToBit() {
		assertEquals("USB1", 1.2582912E7, Converter.toBit(12, Power.Mega, Unit.Bit), 0);
		assertEquals("USB2", 5.0331648E8, Converter.toBit(480, Power.Mega, Unit.Bit), 0);
		assertEquals("USB3", 5.1539607552E9, Converter.toBit(4.8, Power.Giga, Unit.Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s100)", 0, Converter.toBit(100, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s200)", 0, Converter.toBit(200, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s400)", 0, Converter.toBit(400, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s800)", 0, Converter.toBit(800, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s1200)", 0, Converter.toBit(1200, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s1600)", 0, Converter.toBit(1600, Power.Mega, Unit.Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s3200)", 0, Converter.toBit(3200, Power.Mega, Unit.Bit), 0);
	}
	
	@Test
	public void testToBit() {
		// Bit
		assertEquals(0, Converter.toBit(0, Power.None, Unit.Bit), 0);
		assertEquals(1, Converter.toBit(1, Power.None, Unit.Bit), 0);
		assertEquals(0, Converter.toBit(0, Power.Kilo, Unit.Bit), 0);
		assertEquals(1024, Converter.toBit(1, Power.Kilo, Unit.Bit), 0);
		assertEquals(1048576, Converter.toBit(1, Power.Mega, Unit.Bit), 0);
		assertEquals(1.073741824E9, Converter.toBit(1, Power.Giga, Unit.Bit), 0);
		// Byte
		assertEquals(0, Converter.toBit(0, Power.None, Unit.Byte), 0);
		assertEquals(8, Converter.toBit(1, Power.None, Unit.Byte), 0);
		assertEquals(16, Converter.toBit(2, Power.None, Unit.Byte), 0);
		assertEquals(24, Converter.toBit(3, Power.None, Unit.Byte), 0);
		assertEquals(0, Converter.toBit(0, Power.Kilo, Unit.Byte), 0);
		assertEquals(8*1024, Converter.toBit(1, Power.Kilo, Unit.Byte), 0);
		assertEquals(8*1048576, Converter.toBit(1, Power.Mega, Unit.Byte), 0);
		assertEquals(16*1048576, Converter.toBit(2, Power.Mega, Unit.Byte), 0);
		assertEquals(24*1048576, Converter.toBit(3, Power.Mega, Unit.Byte), 0);
		assertEquals(8*1.073741824E9, Converter.toBit(1, Power.Giga, Unit.Byte), 0);
		// Octet
		assertEquals(0, Converter.toBit(0, Power.None, Unit.Octet), 0);
		assertEquals(8, Converter.toBit(1, Power.None, Unit.Octet), 0);
		assertEquals(16, Converter.toBit(2, Power.None, Unit.Octet), 0);
		assertEquals(24, Converter.toBit(3, Power.None, Unit.Octet), 0);
		assertEquals(0, Converter.toBit(0, Power.Kilo, Unit.Octet), 0);
		assertEquals(8*1024, Converter.toBit(1, Power.Kilo, Unit.Octet), 0);
		assertEquals(8*1048576, Converter.toBit(1, Power.Mega, Unit.Octet), 0);
		assertEquals(16*1048576, Converter.toBit(2, Power.Mega, Unit.Octet), 0);
		assertEquals(24*1048576, Converter.toBit(3, Power.Mega, Unit.Octet), 0);
		assertEquals(8*1.073741824E9, Converter.toBit(1, Power.Giga, Unit.Octet), 0);
	}

	@Test
	public void testFromBit() {
		// Bit
		assertEquals(0, Converter.fromBit(0, Power.None, Unit.Bit), 0);
		assertEquals(1, Converter.fromBit(1, Power.None, Unit.Bit), 0);
		assertEquals(0, Converter.fromBit(0, Power.Kilo, Unit.Bit), 0);
		assertEquals(1, Converter.fromBit(1024, Power.Kilo, Unit.Bit), 0);
		assertEquals(1, Converter.fromBit(1048576, Power.Mega, Unit.Bit), 0);
		assertEquals(1, Converter.fromBit(1.073741824E9, Power.Giga, Unit.Bit), 0);
		// Byte
		assertEquals(0, Converter.fromBit(0, Power.None, Unit.Byte), 0);
		assertEquals(1, Converter.fromBit(8, Power.None, Unit.Byte), 0);
		assertEquals(2, Converter.fromBit(16, Power.None, Unit.Byte), 0);
		assertEquals(3, Converter.fromBit(24, Power.None, Unit.Byte), 0);
		assertEquals(0, Converter.fromBit(0, Power.Kilo, Unit.Byte), 0);
		assertEquals(1, Converter.fromBit(8*1024, Power.Kilo, Unit.Byte), 0);
		assertEquals(1, Converter.fromBit(8*1048576, Power.Mega, Unit.Byte), 0);
		assertEquals(2, Converter.fromBit(16*1048576, Power.Mega, Unit.Byte), 0);
		assertEquals(3, Converter.fromBit(24*1048576, Power.Mega, Unit.Byte), 0);
		assertEquals(1, Converter.fromBit(8*1.073741824E9, Power.Giga, Unit.Byte), 0);
	}
}
