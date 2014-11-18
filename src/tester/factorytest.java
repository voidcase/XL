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
		System.out.println("Comment: " + s1 + " Success");

		// ExprSlot
		try {
			Expr expr1 = parser.build("4*5");
			Slot s2 = factory.buildSlot(expr1.toString());
			System.out.println("Expr: " + s2 + " Success");
		} catch (IOException e0) {
			throw new XLException("Expr: " + e0.getMessage() + " Fail");
		}
		
		//CircularSlot
		try {
			Slot s3 = factory.buildSlot("CircularSlot");
			System.out.println("CircularSlot: " + s3 + " Success");
		} catch (XLException xl0){
			System.out.println("CircularSlot: " + xl0 + " Fail");
		}
		
		
		// Weird
		try {
			Expr expr2 = parser.build("hej");
			factory.buildSlot(expr2.toString());
			System.out.println("Weird: " + expr2 + " Shouldn't succeed");
		} 
			catch (IOException e2) {
			System.out.println("Weird: IO " + e2.getMessage());
//			throw new XLException(e.getMessage());
		} 
			catch (XLException xl1){
			System.out.println("Weird: XL " + xl1.getMessage() + " Success");
		}
		
	}
}
