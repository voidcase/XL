package tester;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;
import model.Slot;
import model.SlotFactory;
import model.XLException;

public class factorytest {

	public static void main(String[] args) {
		SlotFactory factory = new SlotFactory();
		ExprParser parser = new ExprParser();

		// CommentSlot
		Slot s1 = factory.buildSlot("#Hej");
		System.out.println(s1);

		// ExprSlot
		try {
			Expr expr1 = parser.build("4*5");
			Slot s2 = factory.buildSlot(expr1.toString());
			System.out.println(s2);
		} catch (IOException e0) {
			throw new XLException(e0.getMessage());
		}
		
		//CircularSlot
		
		try {
			Slot s3 = factory.buildSlot("CircularSlot");
			System.out.println("success " + s3);
		} catch (XLException xl0){
			System.out.println("fail " + xl0);
		}
		
		

		// Weird
		try {
			Expr expr2 = parser.build("hej");
			factory.buildSlot(expr2.toString());
			System.out.println(expr2);
		} 
			catch (IOException e2) {
			System.out.println("IO " + e2.getMessage());
//			throw new XLException(e.getMessage());
		} 
		catch (XLException xl1){
			System.out.println("XL " + xl1.getMessage());
		}
		
	}
}
