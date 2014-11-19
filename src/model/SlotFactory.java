package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class SlotFactory {
	private ExprParser parser;

	public SlotFactory() {
		parser = new ExprParser();
	}

	public Slot buildSlot(String string) {
		System.out.println("factory : rätt 1");
		
		StringBuilder sb = new StringBuilder();
		sb.append(string);

		if (sb.charAt(0) == '#') {
			
			System.out.println("factory : fel");
			
			return new CommentSlot(sb.toString());
		}
		
		try {
			System.out.println("factory : rätt 2");
			Expr expr = parser.build(string);
			return new ExprSlot(expr);
		} catch (IOException e) {
			System.out.println("factory : " + e.getMessage());
			throw new XLException(string  + " is not a expression");
		}
	}
}
