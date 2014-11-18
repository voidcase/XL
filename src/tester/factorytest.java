package tester;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;
import model.Slot;
import model.SlotFactory;
import model.XLException;

public class factorytest {
	
	public static void main(String[] args){
		SlotFactory factory = new SlotFactory();
		ExprParser parser = new ExprParser();
		
		//CommentSlot
		Slot s1 = factory.buildSlot("#Hej");
		System.out.println(s1);
		
		//ExprSlot
		try {
			Expr e1 = parser.build("4*5");
			factory.buildSlot(e1.toString());
			System.out.println(e1);
		} catch (IOException e){
			throw new XLException(e.getMessage());
		}
		
		//Weird
		
		
		
	}

}
