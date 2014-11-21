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
		try {
			if (string.charAt(0) == '#') {
				return new CommentSlot(string.toString());
			}
		} catch (Exception e2) {
			throw new XLException("");
		} try {
			Expr expr = parser.build(string);
			return new ExprSlot(expr);

		} catch (XLException e) {
			throw new XLException(" '" + string + "'"
					+ " is not an expression");
		} catch (IOException e) {
			throw new XLException(" '" + string + "'"
					+ " is not an expression");
		}
	} 
}

