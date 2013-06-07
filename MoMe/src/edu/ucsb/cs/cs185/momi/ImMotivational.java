package edu.ucsb.cs.cs185.momi;

import com.example.mome.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImMotivational extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_im_motivational);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.im_motivational, menu);
		return true;
	}

}
