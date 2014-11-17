package model;

import expr.Environment;

public class CommentSlot implements Slot{
	String comment;
	
	public CommentSlot(String s){
		comment = s;
	}
	
	public String toString(){
		return comment;
	}

	@Override
	public double value(Environment e) {
		// TODO Auto-generated method stub
		return 0;
	}
}
