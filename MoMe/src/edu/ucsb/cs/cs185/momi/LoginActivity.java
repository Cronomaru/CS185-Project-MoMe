package edu.ucsb.cs.cs185.momi;

import edu.ucsb.cs.cs185.momi.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		 //add the buttons
        Button motivateMe = (Button) findViewById(R.id.loginbutton);
        Button imMotivated = (Button) findViewById(R.id.signupbutton);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	

}
