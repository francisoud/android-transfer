package com.blogspot.francisoud.android.transfer;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class Device implements Comparable<Device> {

	private static final List<Device> DEVICES;

	static {
		Log.d(TransferSpeed.TAG, "Init device list");
		DEVICES = new ArrayList<Device>();
		DEVICES.add(new Device("Firewire", 0));
		DEVICES.add(new Device("Firewire 2", 0));
		DEVICES.add(new Device("USB", 0));
		DEVICES.add(new Device("USB 2", 0));
		DEVICES.add(new Device("USB 3", 0));
	}

	private final String label;

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
}
