package com.blogspot.francisoud.android.transfer;

import java.text.DecimalFormat;

public class FormatUtils {
	private static final DecimalFormat formatter = new DecimalFormat();
	static {
		formatter.setDecimalSeparatorAlwaysShown(false);
		formatter.setMaximumFractionDigits(2);
	}

	public static String format(double value) {
		return formatter.format(value);
	}
}
