package com.example.mome;
//testing github by editing this!
//test push




import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{
	
	
	private int touches = 0;
	public ArrayList<Integer> picList = new ArrayList<Integer>(); 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
   
    	// add avatars to list
    	picList.add(R.drawable.avatar_01);
    	picList.add(R.drawable.avatar_todo_suggestion);
    	picList.add(R.drawable.avatar_todo_suggestion_task);
        
        //add the buttons
        Button motivateMe = (Button) findViewById(R.id.button_completed);
        Button imMotivated = (Button) findViewById(R.id.button_signup);
  
        motivateMe.setOnClickListener(this);
        imMotivated.setOnClickListener(this);
        
        ImageView avatar = (ImageView) findViewById(R.id.avatar);
        avatar.setOnClickListener(this);
         
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
		case R.id.button_signup:
			Intent myIntent1=new Intent(v.getContext(),ImMotivationalPrompt.class);
	        startActivityForResult(myIntent1, 0);
	        finish();
	        break;
	        
		case R.id.avatar:
			// change image
			if (touches < picList.size() ){				
				((ImageView) v).setImageResource(picList.get(touches));
				touches++;
			}else{
				touches = 0;
				((ImageView) v).setImageResource(picList.get(touches));
			}
			
				
				
				
				
			break;
	            
		}
		
	}
    
}
