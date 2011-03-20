package com.blogspot.francisoud.android.transfer;

import android.content.Context;
import android.widget.ArrayAdapter;

public class DevicesAdapter extends ArrayAdapter<Device> {

	public DevicesAdapter(Context context) {
		super(context, R.layout.device);
	}
}
