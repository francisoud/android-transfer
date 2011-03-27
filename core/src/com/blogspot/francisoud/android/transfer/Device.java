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
		DEVICES.add(new Device("Modem 56 K (kilobit/s)", 57344));
		DEVICES.add(new Device("128 K (kilobit/s)", 131072));
		DEVICES.add(new Device("ADSL 512 K (kilobit/s)", 524288));
		DEVICES.add(new Device("1024 K (kilobit/s)", 1048576));
		DEVICES.add(new Device("2048 K  (kilobit/s)", 2097152));
		DEVICES.add(new Device("USB 1", 1.2582912E7));
		DEVICES.add(new Device("Wifi 802.11b", 1.1534336E7));
		DEVICES.add(new Device("SD Card (class 2)", 1.6777216E7));
		DEVICES.add(new Device("SD Card (class 4)", 3.3554432E7));
		DEVICES.add(new Device("SD Card (class 6)", 5.0331648E7));
		DEVICES.add(new Device("Wifi 802.11a or 802.11g", 5.6623104E7));
		DEVICES.add(new Device("SD Card (class 10)", 8.388608E7));
		DEVICES.add(new Device("Firewire 1 (1394a-s100)", 1.048576E8));
		DEVICES.add(new Device("Firewire 1 (1394a-s200)", 2.097152E8));
		DEVICES.add(new Device("Firewire 1 (1394a-s400)", 4.194304E8));
		DEVICES.add(new Device("USB 2", 5.0331648E8));
		DEVICES.add(new Device("Wifi 802.11n", 6.291456E8));
		DEVICES.add(new Device("Firewire 2 (1394b-s800)", 8.388608E8));
		DEVICES.add(new Device("Firewire 2 (1394b-s1200)", 1.2582912E9));
		DEVICES.add(new Device("Firewire 2 (1394b-s1600)", 1.6777216E9));
		DEVICES.add(new Device("Firewire 2 (1394b-s3200)", 3.3554432E9));
		DEVICES.add(new Device("USB 3", 5.1539607552E9));
	}

	private final String label;

	private Power power;

	private Unit unit;

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
		final String value = FormatUtils.format(Converter.fromBit(bitsPerSeconde, power, unit));
		return label + " - " + value + " " + power.toString() + unit.toString() + "/s";
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
}
