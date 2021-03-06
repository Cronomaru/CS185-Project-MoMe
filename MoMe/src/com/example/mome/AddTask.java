package com.example.mome;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddTask extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
		TextView name = (TextView) findViewById(R.id.editText_nameoftask);
		name.requestFocus();
		
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker_duedate);		      
    	datePicker.setEnabled(false);
    	TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker_time);		      
    	datePicker.setEnabled(false);
    	timePicker.setEnabled(false);
    	
    	CheckBox dueDate = (CheckBox) findViewById( R.id.checkBox_duedate);
		dueDate.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		    {
		    	DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker_duedate);
		    	datePicker.setEnabled(isChecked);

		    }
		});
		
		CheckBox dueTime = (CheckBox) findViewById( R.id.checkBox_time);
		dueTime.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		    {
		    	TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker_time);
		    	timePicker.setEnabled(isChecked);

		    }
		});
		
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_task, menu);
		return true;
	}

	
	
	
	public void sendData(View v){
		
		 SeekBar importance = (SeekBar) findViewById(R.id.seekBar_importance_answer);
	     SeekBar frequency = (SeekBar) findViewById(R.id.seekBar_reminders_answer);
	     
	     int taskImp = importance.getProgress();
	     int freq = frequency.getProgress();
		
		DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker_duedate);
		int day = datePicker.getDayOfMonth();
		int month = datePicker.getMonth() + 1;
		int year = datePicker.getYear();
		
		TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker_time);
		int hour = timePicker.getCurrentHour();
		int mins = timePicker.getCurrentMinute();
		
		EditText Category   = (EditText)findViewById(R.id.autoCompleteTextView_category);
		EditText Task   = (EditText)findViewById(R.id.editText_nameoftask);
	
		String category = Category.getText().toString() ; 
		String task = Task.getText().toString() ;
		
		String duedate = "";
		CheckBox checkBoxDueDate = (CheckBox) findViewById(R.id.checkBox_duedate);
        if (checkBoxDueDate.isChecked()) {
            duedate = month + "/" + day + "/" + year;
        }
        
        String duetime = "";
		CheckBox checkBoxDueTime = (CheckBox) findViewById(R.id.checkBox_time);
        if (checkBoxDueTime.isChecked() && checkBoxDueDate.isChecked()) {   
            duetime = hour + ":" + mins;
        }
        
        checkBoxDueDate.setChecked(false);
        checkBoxDueTime.setChecked(false);
        
        if(category.length()==0 && task.length()==0){
        	Toast.makeText(getBaseContext(), "Please enter a Task name and Category.", 
				     Toast.LENGTH_LONG).show();
        }
        else if(task.length()==0){
        	Toast.makeText(getBaseContext(), "Please enter a Task name.", 
				     Toast.LENGTH_LONG).show();
        }
        else if(category.length()==0){
        	Toast.makeText(getBaseContext(), "Please enter a Category.", 
				     Toast.LENGTH_LONG).show();
        }
        else{
		Intent data = new Intent(this, ToDoList.class);
	
		data.putExtra("CATAGORY",category);
		data.putExtra("TASK",task );
		data.putExtra("DUEDATE",duedate);
		data.putExtra("DUETIME",duetime);
		data.putExtra("IMPORTANCE",taskImp);
		data.putExtra("FREQUENCY",freq);
		setResult(RESULT_OK, data);
		super.finish();
        }
	}
	
	
	
	public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    BackpressedIntent .setClass(getApplicationContext(),ToDoList.class);
	    startActivity(BackpressedIntent );
	    finish();
	    
		
	}
}		
