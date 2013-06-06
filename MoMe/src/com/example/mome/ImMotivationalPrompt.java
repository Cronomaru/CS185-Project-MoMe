package com.example.mome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImMotivationalPrompt extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_im_motivational_prompt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.im_motivational_prompt, menu);
		return true;
	}

}
