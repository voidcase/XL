package model;

public class CommentSlot extends Slot{
	String comment;
	
	public CommentSlot(String s){
		comment = s;
	}
	
	public String toString(){
		return comment;
	}
}
