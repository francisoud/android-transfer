package com.blogspot.francisoud.android.transfer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TransferSpeed extends Activity {
	private static final String[] DEVICES = new String[] { "Firewire",
			"Firewire 2", "USB", "USB 2" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Spinner unitSpinner = (Spinner) findViewById(R.id.unitSpinner);
		final ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter
				.createFromResource(this, R.array.units,
						android.R.layout.simple_spinner_item);
		unitAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		unitSpinner.setAdapter(unitAdapter);
		// select Mio/s
		unitSpinner.setSelection(4);

		final ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.device,
				DEVICES));
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}