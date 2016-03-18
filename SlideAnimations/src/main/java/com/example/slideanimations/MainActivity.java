package com.example.slideanimations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button slide = null;
	private Button datepicker = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		slide = (Button) findViewById(R.id.rtol);
		slide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(getApplicationContext(),
						SecondActivity.class);
				startActivity(intent);

				overridePendingTransition(R.anim.slideinleft, R.anim.fadeout);
			}
		});

		datepicker = (Button) findViewById(R.id.datepicker);
		datepicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				DatePickerFragment fragment = new DatePickerFragment();
				fragment.show(getFragmentManager(), "date picker");
				//overridePendingTransition(R.anim.slideinleft, R.anim.fadeout);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
