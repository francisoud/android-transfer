package com.blogspot.francisoud.android.transfer;

public class Converter {

	public enum Unit {
		Bit, Byte, Octet
	};

	public enum Power {
		None(0), Kilo(1), Mega(2), Giga(3);

		private int multiple;

		Power(int multiple) {
			this.multiple = multiple;
		}

		public int getMultiple() {
			return multiple;
		}
	};

	/**
	 * Trasnform any value to bit.
	 */
	public static double toBit(double value, Power power, Unit unit) {
		double bits;
		switch (unit) {
		case Byte:
		case Octet:
			bits = byte2bit(value);
			break;
		case Bit:
		default:
			bits = value;
			break;
		}
		return bits * Math.pow(1024, power.getMultiple());
	}

	/**
	 * Transform the bit value to Kilo Byte depending on power/unit param.
	 */
	public static double fromBit(double bits, Power power, Unit unit) {
		double result;
		switch (unit) {
		case Byte:
		case Octet:
			result = bit2byte(bits);
			break;
		case Bit:
		default:
			result = bits;
			break;
		}
		return result / Math.pow(1024, power.getMultiple());
	}

	private static double byte2bit(double bytes) {
		return bytes * 8;
	}

	private static double bit2byte(double bits) {
		return bits / 8;
	}
}
