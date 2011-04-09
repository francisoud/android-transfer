package com.blogspot.francisoud.android.transfer;

import static com.blogspot.francisoud.android.transfer.Converter.Power.Giga;
import static com.blogspot.francisoud.android.transfer.Converter.Power.Kilo;
import static com.blogspot.francisoud.android.transfer.Converter.Power.Mega;
import static com.blogspot.francisoud.android.transfer.Converter.Power.None;
import static com.blogspot.francisoud.android.transfer.Converter.Unit.Bit;
import static com.blogspot.francisoud.android.transfer.Converter.Unit.Byte;
import static com.blogspot.francisoud.android.transfer.Converter.Unit.Octet;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void testDevicesToBit() {
		assertEquals("USB1", 1.2582912E7, Converter.toBit(12, Mega, Bit), 0);
		assertEquals("USB2", 5.0331648E8, Converter.toBit(480, Mega, Bit), 0);
		assertEquals("USB3", 5.1539607552E9, Converter.toBit(4.8, Giga, Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s100)", 1.048576E8, Converter.toBit(100, Mega, Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s200)", 2.097152E8, Converter.toBit(200, Mega, Bit), 0);
		assertEquals("Firewire 1 (IEEE 1394a-s400)", 4.194304E8, Converter.toBit(400, Mega, Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s800)", 8.388608E8, Converter.toBit(800, Mega, Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s1200)", 1.2582912E9, Converter.toBit(1200, Mega, Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s1600)", 1.6777216E9, Converter.toBit(1600, Mega, Bit), 0);
		assertEquals("Firewire 2 (IEEE 1394b-s3200)", 3.3554432E9, Converter.toBit(3200, Mega, Bit), 0);
		assertEquals("ADSL", 524288, Converter.toBit(512, Kilo, Bit), 0);
		// test inverse conversion
		assertEquals("ADSL", 64, Converter.fromBit(524288, Kilo, Octet), 0);
		// end test inverse conversion
		assertEquals("ADSL", 8388608, Converter.toBit(8, Mega, Bit), 0);
		assertEquals("ADSL2", 1.2582912E7, Converter.toBit(12, Mega, Bit), 0);
		assertEquals("ADSL2+", 2.5165824E7, Converter.toBit(24, Mega, Bit), 0);
		assertEquals("Modem 56 K (kilobit/s)", 57344, Converter.toBit(56, Kilo, Bit), 0);
		assertEquals("128 K (kilobit/s)", 131072, Converter.toBit(128, Kilo, Bit), 0);
		assertEquals("512 K (kilobit/s)", 524288, Converter.toBit(512, Kilo, Bit), 0);
		assertEquals("1024 K (kilobit/s)", 1048576, Converter.toBit(1024, Kilo, Bit), 0);
		assertEquals("2048 K  (kilobit/s)", 2097152, Converter.toBit(2048, Kilo, Bit), 0);
		// wifi
		assertEquals("Wifi 802.11", 2097152, Converter.toBit(2, Mega, Bit), 0);
		assertEquals("Wifi 802.11b", 1.1534336E7, Converter.toBit(11, Mega, Bit), 0);
		assertEquals("Wifi 802.11a or 802.11g", 5.6623104E7, Converter.toBit(54, Mega, Bit), 0);
		assertEquals("Wifi 802.11n", 6.291456E8, Converter.toBit(600, Mega, Bit), 0);
		// SD Card
		assertEquals("SD Card (class 2)", 1.6777216E7, Converter.toBit(2, Mega, Octet), 0);
		assertEquals("SD Card (class 4)", 3.3554432E7, Converter.toBit(4, Mega, Octet), 0);
		assertEquals("SD Card (class 6)", 5.0331648E7, Converter.toBit(6, Mega, Octet), 0);
		assertEquals("SD Card (class 10)", 8.388608E7, Converter.toBit(10, Mega, Octet), 0);
		// ethernet
		assertEquals("Ethernet (IEEE 802.3)", 3082813.44, Converter.toBit(2.94, Mega, Bit), 0);
		assertEquals("Ethernet (10b2 & 10bT)", 1.048576E7, Converter.toBit(10, Mega, Bit), 0);
		assertEquals("Ethernet (100bT)", 1.048576E8, Converter.toBit(100, Mega, Bit), 0);
		assertEquals("Ethernet (1000bT)", 1.073741824E9, Converter.toBit(1, Giga, Bit), 0);
		assertEquals("Ethernet (10GBASE)", 1.073741824E10, Converter.toBit(10, Giga, Bit), 0);
		// mobile
		assertEquals("Mobile 1G (NMT)", 1200, Converter.toBit(1200, None, Bit), 0);
		assertEquals("Mobile 2G (CSD & D-AMPS)", 14745.6, Converter.toBit(14.4, Kilo, Bit), 0);
		assertEquals("Mobile 2G (EDGE)", 303104, Converter.toBit(296, Kilo, Bit), 0);
		assertEquals("Mobile 3G (UMTS-FDD)", 393216, Converter.toBit(384, Kilo, Bit), 0);
		assertEquals("Mobile 3G (UMTS HSPA & HSDPA)", 1.50994944E7, Converter.toBit(14.4, Mega, Bit), 0);
		assertEquals("Mobile 3G (HSPA+)", 5.8720256E7, Converter.toBit(56, Mega, Bit), 0);
		assertEquals("Mobile 3G (CDMA2000)", 1.54140672E7, Converter.toBit(14.7, Mega, Bit), 0);
		assertEquals("Mobile 4G (WiMAX)", 1.50994944E8, Converter.toBit(144, Mega, Bit), 0);
		assertEquals("Mobile 4G (LTE)", 3.7748736E8, Converter.toBit(360, Mega, Bit), 0);
		// thunderbolt
		assertEquals("Thunderbolt", 2.147483648E10, Converter.toBit(20, Giga, Bit), 0);
		// Hard Drive
		assertEquals("Hard Drive (7200 rpm)", 1.08003328E9, Converter.toBit(1030, Mega, Bit), 0);
		assertEquals("Hard Drive (SATA 150 v1.0)", 1.610612736E9, Converter.toBit(1.5, Giga, Bit), 0);
		assertEquals("Hard Drive (SATA 300 v2.0)", 3.221225472E9, Converter.toBit(3, Giga, Bit), 0);
		assertEquals("Hard Drive (SATA 600 v3.0)", 6.442450944E9, Converter.toBit(6, Giga, Bit), 0);
		assertEquals("Hard Drive (SCSI Ultra-320)", 2.68435456E9, Converter.toBit(320, Mega, Byte), 0);
		assertEquals("Hard Drive (SCSI Ultra-640)", 5.36870912E9, Converter.toBit(640, Mega, Byte), 0);
		// fibre
		assertEquals("Fibre Channel (over copper cable)", 3.3554432E9, Converter.toBit(400, Mega, Byte), 0);
		assertEquals("Fibre Channel (over optic fibre)", 1.6777216E10, Converter.toBit(2000, Mega, Byte), 0);
	}

	@Test
	public void testToBit() {
		// Bit
		assertEquals(0, Converter.toBit(0, None, Bit), 0);
		assertEquals(1, Converter.toBit(1, None, Bit), 0);
		assertEquals(0, Converter.toBit(0, Kilo, Bit), 0);
		assertEquals(1024, Converter.toBit(1, Kilo, Bit), 0);
		assertEquals(1048576, Converter.toBit(1, Mega, Bit), 0);
		assertEquals(1.073741824E9, Converter.toBit(1, Giga, Bit), 0);
		// Byte
		assertEquals(0, Converter.toBit(0, None, Byte), 0);
		assertEquals(8, Converter.toBit(1, None, Byte), 0);
		assertEquals(16, Converter.toBit(2, None, Byte), 0);
		assertEquals(24, Converter.toBit(3, None, Byte), 0);
		assertEquals(0, Converter.toBit(0, Kilo, Byte), 0);
		assertEquals(8 * 1024, Converter.toBit(1, Kilo, Byte), 0);
		assertEquals(8 * 1048576, Converter.toBit(1, Mega, Byte), 0);
		assertEquals(16 * 1048576, Converter.toBit(2, Mega, Byte), 0);
		assertEquals(24 * 1048576, Converter.toBit(3, Mega, Byte), 0);
		assertEquals(8 * 1.073741824E9, Converter.toBit(1, Giga, Byte), 0);
		// Octet
		assertEquals(0, Converter.toBit(0, None, Octet), 0);
		assertEquals(8, Converter.toBit(1, None, Octet), 0);
		assertEquals(16, Converter.toBit(2, None, Octet), 0);
		assertEquals(24, Converter.toBit(3, None, Octet), 0);
		assertEquals(0, Converter.toBit(0, Kilo, Octet), 0);
		assertEquals(8 * 1024, Converter.toBit(1, Kilo, Octet), 0);
		assertEquals(8 * 1048576, Converter.toBit(1, Mega, Octet), 0);
		assertEquals(16 * 1048576, Converter.toBit(2, Mega, Octet), 0);
		assertEquals(24 * 1048576, Converter.toBit(3, Mega, Octet), 0);
		assertEquals(8 * 1.073741824E9, Converter.toBit(1, Giga, Octet), 0);
	}

	@Test
	public void testFromBit() {
		// Bit
		assertEquals(0, Converter.fromBit(0, None, Bit), 0);
		assertEquals(1, Converter.fromBit(1, None, Bit), 0);
		assertEquals(0, Converter.fromBit(0, Kilo, Bit), 0);
		assertEquals(1, Converter.fromBit(1024, Kilo, Bit), 0);
		assertEquals(1, Converter.fromBit(1048576, Mega, Bit), 0);
		assertEquals(1, Converter.fromBit(1.073741824E9, Giga, Bit), 0);
		// Byte
		assertEquals(0, Converter.fromBit(0, None, Byte), 0);
		assertEquals(1, Converter.fromBit(8, None, Byte), 0);
		assertEquals(2, Converter.fromBit(16, None, Byte), 0);
		assertEquals(3, Converter.fromBit(24, None, Byte), 0);
		assertEquals(0, Converter.fromBit(0, Kilo, Byte), 0);
		assertEquals(1, Converter.fromBit(8 * 1024, Kilo, Byte), 0);
		assertEquals(1, Converter.fromBit(8 * 1048576, Mega, Byte), 0);
		assertEquals(2, Converter.fromBit(16 * 1048576, Mega, Byte), 0);
		assertEquals(3, Converter.fromBit(24 * 1048576, Mega, Byte), 0);
		assertEquals(1, Converter.fromBit(8 * 1.073741824E9, Giga, Byte), 0);
	}
}
