package com.example.mome;
 
import java.util.ArrayList;
import java.util.LinkedHashMap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;
 
// refer to http://www.mysamplecode.com/2012/10/android-expandablelistview-example.html
// for help 

public class ToDoList extends Activity implements OnClickListener{
 
 private static final int ADD_NEW = 0;
 private LinkedHashMap<String, HeaderInfo> myCatagories = new LinkedHashMap<String, HeaderInfo>();
 private ArrayList<HeaderInfo> catList = new ArrayList<HeaderInfo>();
 
 private MyListAdapter listAdapter;
 private ExpandableListView myList;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.to_do_list);
 
 // Spinner spinner = (Spinner) findViewById(R.id.catagory);
  // Create an ArrayAdapter using the string array and a default spinner layout
  //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
 // R.array.cat_array, android.R.layout.simple_spinner_item);
  // Specify the layout to use when the list of choices appears
  //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  // Apply the adapter to the spinner
 // spinner.setAdapter(adapter);
 
  //Just add some data to start with
  loadData();
 
  //get reference to the ExpandableListView
  myList = (ExpandableListView) findViewById(R.id.myList);
  //create the adapter by passing your ArrayList data
  listAdapter = new MyListAdapter(ToDoList.this, catList);
  //attach the adapter to the list
  myList.setAdapter(listAdapter);
 
  //expand all Groups
  expandAll();
 
  //add new item to the List
  Button add = (Button) findViewById(R.id.add);
  add.setOnClickListener(this);
   
  //listener for child row click
  myList.setOnChildClickListener(myListItemClicked);
  //listener for group heading click
        myList.setOnGroupClickListener(myListGroupClicked);
         
         
 }
 
 public void onClick(View v) {
 
  switch (v.getId()) {
 
  //add entry to the List
  case R.id.add:
	  
	Intent intent1=new Intent(v.getContext(),AddTask.class);
    startActivityForResult(intent1, 0); 
    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivityForResult(intent1, ADD_NEW);
 
   //Spinner spinner = (Spinner) findViewById(R.id.catagory);
   //String catagory = spinner.getSelectedItem().toString();
  // EditText editText = (EditText) findViewById(R.id.task);
  // String task = editText.getText().toString();
  // editText.setText("");
	  
	  
	  
    
   //add a new item to the list
  // int groupPosition = addTask(catagory,task);
  // int groupPosition = addTask("Work","just testin");
   //notify the list so that changes can take effect
   //listAdapter.notifyDataSetChanged();
       
   //collapse all groups
   collapseAll();
   //expand the group where item was just added
  // myList.expandGroup(groupPosition);
   //set the current group to be selected so that it becomes visible
  // myList.setSelectedGroup(groupPosition);
    
   break;
 
   // More buttons go here (if any) ...
 
  }
 }
 
 @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// identify the result
		if (requestCode == ADD_NEW) {
			if (resultCode == RESULT_OK) { // The user picked a contact.
			Bundle bundle = data.getExtras();
			int groupPosition = addTask(bundle.getString("CATAGORY"), bundle.getString("TASK") +"  "+ bundle.getString("DUEDATE"));
			
			listAdapter.notifyDataSetChanged();
			
			 myList.expandGroup(groupPosition);
			   //set the current group to be selected so that it becomes visible
			  myList.setSelectedGroup(groupPosition);
			
			}
		}
	}
 
 
 //method to expand all groups
 private void expandAll() {
  int count = listAdapter.getGroupCount();
  for (int i = 0; i < count; i++){
   myList.expandGroup(i);
  }
 }
  
 //method to collapse all groups
 private void collapseAll() {
  int count = listAdapter.getGroupCount();
  for (int i = 0; i < count; i++){
   myList.collapseGroup(i);
  }
 }
 
 //load some initial data into out list 
 private void loadData(){
 
  addCatagory("Work");
  addCatagory("School");
  addCatagory("Home");
  addCatagory("Shopping");
  addCatagory("Exercise");
  addCatagory("Recreation");
  addCatagory("Other");
 
 }
  
 //our child listener
 private OnChildClickListener myListItemClicked =  new OnChildClickListener() {
 
  public boolean onChildClick(ExpandableListView parent, View v,
    int groupPosition, int childPosition, long id) {
    
   //get the group header
   HeaderInfo headerInfo = catList.get(groupPosition);
   //get the child info
   DetailInfo detailInfo =  headerInfo.getTaskList().get(childPosition);
   //display it or do something with it
   
 	Intent myIntent2=new Intent(v.getContext(),Task.class);
    startActivityForResult(myIntent2, 0); 
 	finish();
   
   //Toast.makeText(getBaseContext(), "Clicked on Detail " + headerInfo.getName() 
    // + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
   return false;
  }
   
 };
  
 //our group listener
 private OnGroupClickListener myListGroupClicked =  new OnGroupClickListener() {
 
  public boolean onGroupClick(ExpandableListView parent, View v,
    int groupPosition, long id) {
    
   //get the group header
   HeaderInfo headerInfo = catList.get(groupPosition);
   //display it or do something with it
   Toast.makeText(getBaseContext(), "Child on Header " + headerInfo.getName(), 
     Toast.LENGTH_LONG).show();
     
   return false;
  }
   
 };
 
 
 
 private void addCatagory(String catagory){
	//used to initiate empty categories
	//check the hash map if the group already exists
	  HeaderInfo headerInfo = myCatagories.get(catagory); 
	  //add the group if doesn't exists
	  if(headerInfo == null){
	   headerInfo = new HeaderInfo();
	   headerInfo.setName(catagory);
	   myCatagories.put(catagory, headerInfo);
	   catList.add(headerInfo);
	  }
 }
 //here we maintain our tasks in various catagorys
 private int addTask(String catagory, String task){
 
  int groupPosition = 0;
   
  //check the hash map if the group already exists
  HeaderInfo headerInfo = myCatagories.get(catagory); 
  //add the group if doesn't exists
  if(headerInfo == null){
   headerInfo = new HeaderInfo();
   headerInfo.setName(catagory);
   myCatagories.put(catagory, headerInfo);
   catList.add(headerInfo);
  }
 
  //get the children for the group
  ArrayList<DetailInfo> taskList = headerInfo.getTaskList();
  //size of the children list
  int listSize = taskList.size();
  //add to the counter
  listSize++;
 
  //create a new child and add that to the group
  DetailInfo detailInfo = new DetailInfo();
  //detailInfo.setSequence(String.valueOf(listSize));
  detailInfo.setName(task);
  taskList.add(detailInfo);
  headerInfo.setTaskList(taskList);
 
  //find the group position inside the list
  groupPosition = catList.indexOf(headerInfo);
  return groupPosition;
 }
 
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
  getMenuInflater().inflate(R.menu.main, menu);
  return true;
 }
 
 public void onBackPressed() {
	    Intent BackpressedIntent = new Intent();
	    BackpressedIntent .setClass(getApplicationContext(),MotivateMe.class);
	    startActivity(BackpressedIntent );
	    finish();
	}
 
}
