package com.blogspot.francisoud.android.transfer;

import android.content.Context;
import android.widget.ArrayAdapter;

public class UnitAdapter extends ArrayAdapter<CharSequence> {

	public UnitAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		for (AvailableUnit unit : AvailableUnit.values()) {
			this.add(unit.getLabel());
		}
	}

	public AvailableUnit getUnit(int position) {
		return AvailableUnit.values()[position];
	}
}
