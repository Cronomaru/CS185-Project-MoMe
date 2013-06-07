package edu.ucsb.cs.cs185.momi;

import java.util.ArrayList;

public class HeaderInfo {
  
 private String name;
 private ArrayList<DetailInfo> taskList = new ArrayList<DetailInfo>();;
  
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public ArrayList<DetailInfo> getTaskList() {
  return taskList;
 }
 public void setTaskList(ArrayList<DetailInfo> taskList) {
  this.taskList = taskList;
 }
}