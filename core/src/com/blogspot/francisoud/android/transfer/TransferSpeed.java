package com.blogspot.francisoud.android.transfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class TransferSpeed extends Activity {

	public static final String TAG = "TransferSpeed";
	// private final ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter
	// .createFromResource(this, R.array.units,
	// android.R.layout.simple_spinner_item);
	private UnitAdapter unitAdapter;
	private DevicesAdapter devicesAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		unitAdapter = new UnitAdapter(this, android.R.layout.simple_spinner_item);
		devicesAdapter = new DevicesAdapter(this);

		final Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
		unitSpinner.setSelected(false);
		unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		unitSpinner.setAdapter(unitAdapter);
		// select Kio/s
		// unitSpinner.setSelection(3);
		unitSpinner.setOnItemSelectedListener(new OnUnitSelectedListener());

		final ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(devicesAdapter);
		// listView.setOnItemClickListener(new OnItemClickListener() {
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// // When clicked, show a toast with the TextView text
		// final CharSequence text = ((TextView) view).getText();
		// Toast.makeText(getApplicationContext(), text,
		// Toast.LENGTH_SHORT).show();
		// }
		// });
	}

	private final class OnUnitSelectedListener implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			final String value = ((EditText) findViewById(R.id.editSpeedText)).getText().toString();
			if (Log.isLoggable(TAG, Log.DEBUG)) {
				Log.d(TAG, "current value: " + value);
				Log.d(TAG, "position: " + position);
				Log.d(TAG, "id: " + id);
			}
			final AvailableUnit unit = unitAdapter.getUnit(position);
			final double bits = Converter.toBit(new Double(value), unit.getPower(), unit.getUnit());
			Log.d(TAG, "bits: " + bits);
			final String displayBits = FormatUtils.format(bits);
			// final String displayBits = Double.toString(bits);
			Toast.makeText(getApplicationContext(), displayBits + " Bit/s", Toast.LENGTH_SHORT).show();
			final List<Device> devices = new ArrayList<Device>(Device.getList());
			// FIXME use externalize string R.string.you;
			final String label = "==> You are here";
			final Device here = new Device(label, bits);
			devices.add(here);
			Collections.sort(devices);
			devicesAdapter.setNotifyOnChange(false);
			devicesAdapter.clear();
			for (Device device : devices) {
				device.setPower(unit.getPower());
				device.setUnit(unit.getUnit());
				devicesAdapter.add(device);
			}
			devicesAdapter.notifyDataSetChanged();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			Log.d(TAG, "onNothingSelected");
		}
	}
}