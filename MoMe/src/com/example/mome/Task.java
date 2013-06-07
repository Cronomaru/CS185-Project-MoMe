package com.example.mome;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Task extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
		return true;
	}
	
	public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    BackpressedIntent .setClass(getApplicationContext(),ToDoList.class);
	    startActivity(BackpressedIntent );
	    finish();
	}
    

}
