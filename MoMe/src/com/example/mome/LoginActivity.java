package com.example.mome;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		 //add the buttons
        Button login = (Button) findViewById(R.id.loginbutton);
        Button signup = (Button) findViewById(R.id.button_signup);
        
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
			EditText un   = (EditText)findViewById(R.id.username);
			EditText pw   = (EditText)findViewById(R.id.password);
			String username = un.getText().toString() ; 
			String password = pw.getText().toString() ;
			if(username.length()==0 && password.length()==0){
				Toast.makeText(getBaseContext(), "Please enter a username and password.", 
					     Toast.LENGTH_LONG).show();
			}
			else if(username.length()==0){
				Toast.makeText(getBaseContext(), "Please enter a username.", 
					     Toast.LENGTH_LONG).show();
			}
			else if(password.length()==0){
				Toast.makeText(getBaseContext(), "Please enter a password.", 
					     Toast.LENGTH_LONG).show();
			}
			else {
				Intent myIntentMain=new Intent(v.getContext(),MainActivity.class);
	        startActivity(myIntentMain);
	        finish();
			}
	        break;
	    //sign up button is pressed
		case R.id.button_signup:
			Toast.makeText(getBaseContext(), "Not currently available. :)", 
				     Toast.LENGTH_SHORT).show();
	        break;
	            
		}
		
	}// end onClick


	
	

} // end class
