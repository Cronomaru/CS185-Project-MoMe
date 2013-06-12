package com.example.mome;

import java.io.Serializable;

public class DetailInfo implements Serializable{
	  
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sequence = "";
	 private String name = "";
	 String dueDate = "";
	 String dueTime = "";
	 String tTComplete = "";
	 private String  Catagory = "";
	 private String  Task = "";
	 
	  
	 public String getSequence() {
	  return sequence;
	 }
	 public void setSequence(String sequence) {
	  this.sequence = sequence;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public String getCat() {
		 return Catagory;
	 }
	 public void setCat(String cat) {
		 this.Catagory = cat;
	 }
	 public String getTask() {
		 return Task;
	 }
	 public void setTask(String task) {
		 this.Task = task;
	 }
	  
}