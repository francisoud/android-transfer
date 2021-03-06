package com.blogspot.francisoud.android.transfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class TransferSpeed extends Activity {

	public static final String TAG = "TransferSpeed";
	private UnitAdapter unitAdapter;
	private ArrayAdapter<Device> devicesAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		unitAdapter = new UnitAdapter(this, android.R.layout.simple_spinner_item);
		devicesAdapter = new ArrayAdapter<Device>(this, R.layout.device) {
			public View getView(int position, View convertView, android.view.ViewGroup parent) {
				final View deviceView = super.getView(position, convertView, parent);
				Device device = getItem(position);
				if (device.isHere()) {
					deviceView.setBackgroundResource(R.color.here);
				} else {
					deviceView.setBackgroundResource(R.color.black);
				}
				return deviceView;
			}
		};

		// unit selection
		final Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
		unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		unitSpinner.setAdapter(unitAdapter);

		// ok button
		final Button okButton = (Button) findViewById(R.id.okButton);
		okButton.setOnClickListener(new OkButtonListener());

		// devices list
		final ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(devicesAdapter);
	}

	private final class OkButtonListener implements OnClickListener {
		@Override
		public void onClick(View view) {
			devicesAdapter.clear();
			Log.d(TAG, "hide keyboard");
			final InputMethodManager keyboard = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
			keyboard.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			final Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
			final String value = ((EditText) findViewById(R.id.editSpeedText)).getText().toString();
			if (Log.isLoggable(TAG, Log.DEBUG)) {
				Log.d(TAG, "current value: " + value);
			}
			final int position = unitSpinner.getSelectedItemPosition();
			final AvailableUnit unit = unitAdapter.getUnit(position);
			final double bits = Converter.toBit(new Double(value), unit.getPower(), unit.getUnit());
			Log.d(TAG, "bits: " + bits);
			final List<Device> devices = new ArrayList<Device>(Device.getList());
			// FIXME use externalize string R.string.you;
			final String label = "==> You are here";
			final Device here = new Device(label, bits);
			here.setHere(true);
			devices.add(here);
			Collections.sort(devices);
			devicesAdapter.setNotifyOnChange(false);

			for (Device device : devices) {
				device.setPower(unit.getPower());
				device.setUnit(unit.getUnit());
				devicesAdapter.add(device);
			}
			final ListView listView = (ListView) findViewById(R.id.listView);
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
					Toast.makeText(getApplicationContext(), devices.get(position).help(), Toast.LENGTH_SHORT).show();
				}
			});
			devicesAdapter.notifyDataSetChanged();
		}
	}
}