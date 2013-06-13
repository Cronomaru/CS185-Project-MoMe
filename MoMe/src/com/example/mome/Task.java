package com.example.mome;



import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Task extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		
		Serializable child = getIntent().getSerializableExtra("child");
		
		TextView nameView = (TextView) findViewById(R.id.textView_name_answer);
		nameView.setText(((DetailInfo) child).getTask());
		
		TextView catView = (TextView) findViewById(R.id.textView_category_answer);
		catView.setText(((DetailInfo) child).getCat());
		
		TextView dueView = (TextView) findViewById(R.id.textView_due_answer);
		if(((DetailInfo) child).getDue()=="")
			dueView.setText("N/A");
		else
			dueView.setText(((DetailInfo) child).getDue());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
		return true;
	}
	
	public void notImplemented(){
		Toast.makeText(getBaseContext(), "Currently not implemented", 
			     Toast.LENGTH_LONG).show();
	}
	
	public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    setResult(RESULT_CANCELED, BackpressedIntent);        
	    BackpressedIntent .setClass(getApplicationContext(),ToDoList.class);
	    startActivity(BackpressedIntent );
	    finish();
	}
    

}
