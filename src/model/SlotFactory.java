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

		StringBuilder sb = new StringBuilder();
		sb.append(string);
		
		try {

			if (sb.charAt(0) == '#') {
				return new CommentSlot(sb.toString());
			}

			try {
				Expr expr = parser.build(string);
				return new ExprSlot(expr);

			} catch (XLException e) {
				System.out.println("factory: xl");
				throw new XLException(" '" + string + "'"
						+ " is not an expression");
			} catch (IOException e) {
				System.out.println("factory: io");
				throw new XLException(" '" + string + "'"
						+ " is not an expression");
			}
		} catch (Exception e2) {
			System.out.println("factory: empty");
			throw new XLException("");
		}
	}
}
