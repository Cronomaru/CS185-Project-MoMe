package com.example.mome;

import java.io.Serializable;

public class DetailInfo implements Serializable{
	  
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sequence = "";
	 private String name = "";
	 String due = "";
	 String tTComplete = "";
	 private String  Catagory = "";
	 private String  Task = "";
	 private int importance = 50;
	 private int remFreq = 50; //reminder frequency
	 
	  
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
	 public String getDue() {
		 return due;
	 }
	 public void setDue(String due) {
		 this.due = due;
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
	 public int getImportance() {
		 return importance;
	 }
	 public void setImportance(int importance) {
		 this.importance = importance;
	 }
	 public int getRemFreq() {
		 return remFreq;
	 }
	 public void setRemFreq(int remFreq) {
		 this.remFreq = remFreq;
	 }
	  
}