package edu.ucsb.cs.cs185.momi;

import edu.ucsb.cs.cs185.momi.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		 //add the buttons
        Button login = (Button) findViewById(R.id.loginbutton);
        Button signup = (Button) findViewById(R.id.signupbutton);
        
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//login button is pressed
		case R.id.loginbutton:
			Intent myIntentMain=new Intent(v.getContext(),MainActivity.class);
	        startActivity(myIntentMain);
	        finish();
	        break;
	    //sign up button is pressed
		case R.id.signupbutton:
			//Intent myIntent1=new Intent(v.getContext(),ImMotivationalPrompt.class);
	        //startActivityForResult(myIntent1, 0);
	        //finish();
			//NEED TO DO Stuff here ;)
	        break;
	            
		}
		
	}// end onClick


	
	

} // end class
