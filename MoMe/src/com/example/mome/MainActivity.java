package com.example.mome;
//testing github by editing this!
//test push


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //add the buttons
        Button motivateMe = (Button) findViewById(R.id.button_completed);
        Button imMotivated = (Button) findViewById(R.id.button1);
  
        motivateMe.setOnClickListener(this);
        imMotivated.setOnClickListener(this);
         
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		//motivate me is pressed
		case R.id.button_completed:
			Intent myIntent0=new Intent(v.getContext(),MotivateMe.class);
	        startActivity(myIntent0);
	        finish();
	        break;
	        
		case R.id.button1:
			Intent myIntent1=new Intent(v.getContext(),ImMotivationalPrompt.class);
	        startActivityForResult(myIntent1, 0);
	        finish();
	        break;
	            
		}
		
	}
    
}
