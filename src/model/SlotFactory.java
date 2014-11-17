package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class SlotFactory {
	ExprParser parser;

	public SlotFactory() {
		parser = new ExprParser();
	}

	public Slot buildSlot(String string) {
		StringBuilder sb = new StringBuilder();
		sb.append(string);

		if (sb.charAt(0) == '#') {
			sb.deleteCharAt(0);
			return new CommentSlot(sb.toString());
		}

		try {
			Expr expr = parser.build(string);
			return new ExprSlot(expr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new XLException(e.getMessage());
		}
	}
}
