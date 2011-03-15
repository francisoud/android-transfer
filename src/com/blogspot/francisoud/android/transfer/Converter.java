package com.blogspot.francisoud.android.transfer;

public class Converter {

	enum Unit {
		Bit, Byte, Octet
	};

	enum Power {
		None(0), Kilo(1), Mega(2), Giga(3);

		private int multiple;

		Power(int multiple) {
			this.multiple = multiple;
		}

		public int getMultiple() {
			return multiple;
		}
	};

	public static double byte2bit(double bytes) {
		return bytes * 8;
	}

	public static double toBit(double value, Power power, Unit unit) {
		final double bits;
		final int multiple = power.getMultiple() ^ 1024;
		switch (unit) {
		case Byte:
		case Octet:
			if (multiple == 0) {
				bits = byte2bit(value);
			} else {
				bits = byte2bit(value / multiple);
			}
			break;
		case Bit:
		default:
			if (multiple == 0) {
				bits = value;
			} else {
				bits = value / multiple;
			}
			break;
		}
		return bits;
	}

	public static double fromBit(double bits, Power power, Unit unit) {
		return 0.0;
	}
}
