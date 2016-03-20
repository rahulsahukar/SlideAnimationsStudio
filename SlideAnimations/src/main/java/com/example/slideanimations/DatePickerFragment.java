package com.example.slideanimations;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		DatePickerDialog dialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Dialog_MinWidth,this, year, month, day);
		dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation_fade;
		//dialog.getWindow().setGravity(Gravity.BOTTOM);
		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		//dialog.getWindow().setBackgroundDrawableResource(R.drawable.shadow);


		// Create a new instance of DatePickerDialog and return it
		return dialog;
	}

	@Override public void onStart() {
		super.onStart();

		Window window = getDialog().getWindow();
		WindowManager.LayoutParams windowParams = window.getAttributes();
		windowParams.dimAmount = 0.0f;
		windowParams.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		window.setAttributes(windowParams);
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		Log.w("DatePicker","Date = " + year);
	}
}