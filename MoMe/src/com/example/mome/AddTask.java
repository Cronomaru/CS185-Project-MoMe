package com.example.mome;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

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
	
	
	public void sendData(View v){
		
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker_duedate);
		int day = datePicker.getDayOfMonth();
		int month = datePicker.getMonth() + 1;
		int year = datePicker.getYear();
		
		EditText Catagory   = (EditText)findViewById(R.id.autoCompleteTextView_category);
		EditText Task   = (EditText)findViewById(R.id.editText_nameoftask);
	
		String catagory = Catagory.getText().toString() ; 
		String task = Task.getText().toString() ;
		String duedate = month + "/" + day + "/" + year;
	
		Intent data = new Intent(this, ToDoList.class);
	
		data.putExtra("CATAGORY",catagory);
		data.putExtra("TASK",task );
		data.putExtra("DUEDATE",duedate);
		setResult(RESULT_OK, data);
		super.finish();
	}	
	
}
