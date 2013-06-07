package com.example.mome;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImMotivationalPrompt extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_im_motivational_prompt);
		
		//add the buttons
        Button friendsonly = (Button) findViewById(R.id.button_friendsonly);
        Button anyone = (Button) findViewById(R.id.button_anyone);
        
  
        friendsonly.setOnClickListener(this);
        anyone.setOnClickListener(this);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.im_motivational_prompt, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    BackpressedIntent .setClass(getApplicationContext(),MainActivity.class);
	    startActivity(BackpressedIntent );
	    finish();
	}
    
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		//motivate me is pressed
		case R.id.button_friendsonly:
			Intent myIntent0=new Intent(v.getContext(),ImMotivational.class);
	        startActivity(myIntent0);
	        finish();
	        break;
	        
		case R.id.button_anyone:
			Intent myIntent1=new Intent(v.getContext(),ImMotivational.class);
	        startActivityForResult(myIntent1, 0);
	        finish();
	        break;
	        
		
		}
		
	}
	
	
	
}
