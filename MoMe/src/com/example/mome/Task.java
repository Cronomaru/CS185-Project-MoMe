package com.example.mome;



import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Task extends Activity implements OnClickListener {

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
		
		 Button edit = (Button) findViewById(R.id.button_edit);
	     Button complete = (Button) findViewById(R.id.button_completed);
	     Button delete = (Button) findViewById(R.id.button_delete);
	  
	     edit.setOnClickListener(this);
	     complete.setOnClickListener(this);
	     delete.setOnClickListener(this);
		
	     SeekBar importance = (SeekBar) findViewById(R.id.seekBar_importance_answer);
	     SeekBar frequency = (SeekBar) findViewById(R.id.seekBar_reminders_answer);
	     
	     importance.setProgress(((DetailInfo) child).getImportance());
	     frequency.setProgress(((DetailInfo) child).getRemFreq());
	     
	     importance.setEnabled(false);
	     frequency.setEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
		return true;
	}
	
public void onClick(View v) {
		
		switch (v.getId()) {
		
		default:
		Toast.makeText(getBaseContext(), "Currently not implemented", 
			     Toast.LENGTH_LONG).show();
		}
}
		
	public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    setResult(RESULT_CANCELED, BackpressedIntent);        
	    BackpressedIntent .setClass(getApplicationContext(),ToDoList.class);
	    startActivity(BackpressedIntent );
	    finish();
	}
    

}
