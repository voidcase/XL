package model;

import expr.Environment;
//FIXME kommentarer skrivs ut som 0, inte sin string.
public class CommentSlot implements Slot{
	private String comment;
	
	public CommentSlot(String s){
		comment = s;
	}
	
	public String toString(){
		return comment;
	}

	@Override
	public double value(Environment e) {
		return 0;
	}

	public String display(Environment e) {
		return comment.substring(1);
	}
}
