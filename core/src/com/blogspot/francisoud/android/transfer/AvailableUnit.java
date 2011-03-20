package com.blogspot.francisoud.android.transfer;

import com.blogspot.francisoud.android.transfer.Converter.Power;
import com.blogspot.francisoud.android.transfer.Converter.Unit;

public enum AvailableUnit {
	bps("bps (Bit)", Power.None, Unit.Bit), Bit_s("Bit/s (Bit)", Power.None,
			Unit.Bit), B_s("B/s (Byte)", Power.None, Unit.Byte), Byte_s(
			"Byte/s (Byte)", Power.None, Unit.Byte), Octet_s("Octet/s (Octet)",
			Power.None, Unit.Octet), kbps("kbps (Kilobit)", Power.Kilo,
			Unit.Bit), Kibit_s("Kibit/s (Kilobit)", Power.Kilo, Unit.Bit), KB_s(
			"KB/s (Kilobyte)", Power.Kilo, Unit.Byte), KiB_s(
			"KiB/s (Kilobyte)", Power.Kilo, Unit.Byte), Ko_s(
			"Ko/s  (Kilo-octets)", Power.Kilo, Unit.Octet), mbps(
			"mbps (Megabit)", Power.Mega, Unit.Bit), Mibit_s(
			"Mibit/s (Megabit)", Power.Mega, Unit.Bit), MB_s("MB/s (Megabyte)",
			Power.Mega, Unit.Byte), MiB_s("MiB/s (Megabyte)", Power.Mega,
			Unit.Byte), Mio_s("Mio/s (Mega-octets)", Power.Mega, Unit.Octet), gbps(
			"gbps (Gigabit)", Power.Giga, Unit.Bit), Gibit_s(
			"Gibit/s (Gigabit)", Power.Giga, Unit.Bit), GB_s("GB/s (Gigabyte)",
			Power.Giga, Unit.Byte), GiB_s("GiB/s (Gigabyte)", Power.Giga,
			Unit.Byte), Gio_s("Gio/s (Giga-octets)", Power.Giga, Unit.Octet);

	private final String label;
	private final Power power;
	private final Unit unit;

	AvailableUnit(String label, Power power, Unit unit) {
		this.label = label;
		this.power = power;
		this.unit = unit;
	}

	public String getLabel() {
		return label;
	}

	public Power getPower() {
		return power;
	}

	public Unit getUnit() {
		return unit;
	}
}
