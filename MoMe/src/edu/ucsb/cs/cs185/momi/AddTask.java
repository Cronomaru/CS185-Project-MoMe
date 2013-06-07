package edu.ucsb.cs.cs185.momi;

import edu.ucsb.cs.cs185.momi.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddTask extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_task, menu);
		return true;
	}

}
