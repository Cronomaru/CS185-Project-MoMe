package com.example.mome;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Social extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social);
		
		//add the buttons
        Button randomperson = (Button) findViewById(R.id.button_randomperson);
        Button request = (Button) findViewById(R.id.button_request);
        
  
        randomperson.setOnClickListener(this);
        request.setOnClickListener(this);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		//motivate me is pressed
		case R.id.button_randomperson:
			Intent myIntent0=new Intent(v.getContext(),Chat.class);
	        startActivity(myIntent0);
	        finish();
	        break;
	        
		case R.id.button_request:
			Intent myIntent1=new Intent(v.getContext(),Chat.class);
	        startActivityForResult(myIntent1, 0);
	        finish();
	        break;
	        
		}
		
	}

}
