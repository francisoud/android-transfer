package com.blogspot.francisoud.android.transfer;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.blogspot.francisoud.android.transfer.Converter.Power;
import com.blogspot.francisoud.android.transfer.Converter.Unit;

public class Device implements Comparable<Device> {

	private static final List<Device> DEVICES;

	static {
		Log.d(TransferSpeed.TAG, "Init device list");
		DEVICES = new ArrayList<Device>();
		DEVICES.add(new Device("Mobile 1G (NMT)", 1200));
		DEVICES.add(new Device("Mobile 2G (CSD & D-AMPS)", 14745.6));
		DEVICES.add(new Device("Modem 56 K (kilobit/s)", 57344));
		DEVICES.add(new Device("128 K (kilobit/s)", 131072));
		DEVICES.add(new Device("Mobile 2G (EDGE)", 303104));
		DEVICES.add(new Device("Mobile 3G (UMTS-FDD)", 393216));
		DEVICES.add(new Device("ADSL 512 K (kilobit/s)", 524288));
		DEVICES.add(new Device("Wifi 802.11", 2097152));
		DEVICES.add(new Device("ADSL", 8388608));
		DEVICES.add(new Device("1024 K (kilobit/s)", 1048576));
		DEVICES.add(new Device("2048 K  (kilobit/s)", 2097152));
		DEVICES.add(new Device("Ethernet (IEEE 802.3)", 3082813.44));
		DEVICES.add(new Device("Ethernet (10b2 & 10bT)", 1.048576E7));
		DEVICES.add(new Device("ADSL2", 1.2582912E7));
		DEVICES.add(new Device("USB 1", 1.2582912E7));
		DEVICES.add(new Device("Wifi 802.11b", 1.1534336E7));
		DEVICES.add(new Device("Mobile 3G (UMTS HSPA & HSDPA)", 1.50994944E7));
		DEVICES.add(new Device("Mobile 3G (CDMA2000)", 1.54140672E7));
		DEVICES.add(new Device("SD Card (class 2)", 1.6777216E7));
		DEVICES.add(new Device("ADSL2+", 2.5165824E7));
		DEVICES.add(new Device("SD Card (class 4)", 3.3554432E7));
		DEVICES.add(new Device("SD Card (class 6)", 5.0331648E7));
		DEVICES.add(new Device("Wifi 802.11a or 802.11g", 5.6623104E7));
		DEVICES.add(new Device("Mobile 3G (HSPA+)", 5.8720256E7));
		DEVICES.add(new Device("SD Card (class 10)", 8.388608E7));
		DEVICES.add(new Device("Ethernet (100bT)", 1.048576E8));
		DEVICES.add(new Device("Firewire 1 (1394a-s100)", 1.048576E8));
		DEVICES.add(new Device("Mobile 4G (WiMAX)", 1.50994944E8));
		DEVICES.add(new Device("Firewire 1 (1394a-s200)", 2.097152E8));
		DEVICES.add(new Device("Mobile 4G (LTE)", 3.7748736E8));
		DEVICES.add(new Device("Firewire 1 (1394a-s400)", 4.194304E8));
		DEVICES.add(new Device("USB 2", 5.0331648E8));
		DEVICES.add(new Device("Wifi 802.11n", 6.291456E8));
		DEVICES.add(new Device("Firewire 2 (1394b-s800)", 8.388608E8));
		DEVICES.add(new Device("Ethernet (1000bT)", 1.073741824E9));
		DEVICES.add(new Device("Hard Drive (7200 rpm)", 1.08003328E9));
		DEVICES.add(new Device("Firewire 2 (1394b-s1200)", 1.2582912E9));
		DEVICES.add(new Device("Hard Drive (SATA 150 v1.0)", 1.610612736E9));
		DEVICES.add(new Device("Firewire 2 (1394b-s1600)", 1.6777216E9));
		DEVICES.add(new Device("Hard Drive (SCSI Ultra-320)", 2.68435456E9));
		DEVICES.add(new Device("Hard Drive (SATA 300 v2.0)", 3.221225472E9));
		DEVICES.add(new Device("Firewire 2 (1394b-s3200)", 3.3554432E9));
		DEVICES.add(new Device("Fibre Channel (over copper cable)", 3.3554432E9));
		DEVICES.add(new Device("USB 3", 5.1539607552E9));
		DEVICES.add(new Device("Hard Drive (SCSI Ultra-640)", 5.36870912E9));
		DEVICES.add(new Device("Hard Drive (SATA 600 v3.0)", 6.442450944E9));
		DEVICES.add(new Device("Ethernet (10GBASE)", 1.073741824E10));
		DEVICES.add(new Device("Fibre Channel (over optic fibre)", 1.6777216E10));
		DEVICES.add(new Device("Thunderbolt", 2.147483648E10));
	}

	private final String label;

	private Power power;

	private Unit unit;

	private boolean isHere = false;

	private final double bitsPerSeconde;

	public Device(final String label, final double bitsPerSeconde) {
		this.label = label;
		this.bitsPerSeconde = bitsPerSeconde;
	}

	public double getBitsPerSeconde() {
		return bitsPerSeconde;
	}

	public static List<Device> getList() {
		return DEVICES;
	}

	@Override
	public int compareTo(final Device another) {
		return Double.compare(this.bitsPerSeconde, another.bitsPerSeconde);
	}

	@Override
	public String toString() {
		return label;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String help() {
		final String value = FormatUtils.format(Converter.fromBit(bitsPerSeconde, power, unit));
		final StringBuilder sb = new StringBuilder(30);
		if (isHere) {
			sb.append("You - ");
		} else {
			sb.append(label);
			sb.append(" - Theorical: ");
		}
		sb.append(value);
		sb.append(" ");
		sb.append(power.toString());
		sb.append(unit.toString());
		sb.append("/s");
		return sb.toString();
	}

	public boolean isHere() {
		return isHere;
	}

	public void setHere(boolean isHere) {
		this.isHere = isHere;
	}
}
