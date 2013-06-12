package com.example.mome;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MotivateMe extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_motivate_me);
		
		//add the buttons
        Button toDoList = (Button) findViewById(R.id.button_toomuchtodo);
        Button suggestions = (Button) findViewById(R.id.button_toolittletodo);
        Button social = (Button) findViewById(R.id.button_ineedcoachinghelp);
        Button habits = (Button) findViewById(R.id.button_ihaveneedhabits);
  
        toDoList.setOnClickListener(this);
        suggestions.setOnClickListener(this);
        social.setOnClickListener(this);
        habits.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.motivate_me, menu);
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
		case R.id.button_toomuchtodo:
			Intent myIntent0=new Intent(v.getContext(),ToDoList.class);
	        startActivity(myIntent0);
	        finish();
	        break;
	        
		case R.id.button_toolittletodo:
			Toast.makeText(getBaseContext(), "Not currently available. :)", 
				     Toast.LENGTH_SHORT).show();
	        break;
	        
		case R.id.button_ineedcoachinghelp:
			Intent myIntent2=new Intent(v.getContext(),Social.class);
	        startActivityForResult(myIntent2, 0);
	        finish();
	        break;
	            
		case R.id.button_ihaveneedhabits:
			Toast.makeText(getBaseContext(), "Not currently available. :)", 
				     Toast.LENGTH_SHORT).show();
	        break;
		}
		
	}
	
	
	
}
