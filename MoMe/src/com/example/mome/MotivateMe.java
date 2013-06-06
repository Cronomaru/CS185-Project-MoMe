package com.example.mome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MotivateMe extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_motivate_me);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.motivate_me, menu);
		return true;
	}

}
