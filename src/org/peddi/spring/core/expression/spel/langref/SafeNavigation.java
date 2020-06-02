package org.peddi.spring.core.expression.spel.langref;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Expression;
import static java.lang.System.out;

public class SafeNavigation {
	
	public void safeNavigationOperator() {
		out.println("*****safeNavigationOperator()");
		Inventor tesla = Util.getInventors().get(0);
		ExpressionParser parser = SpELCommon.getParser();
		
		Expression expr = parser.parseExpression("PlaceOfBirth?.City");
		String city = expr.getValue(tesla, String.class);
		
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), city);
		
		tesla.setPlaceOfBirth(null);
		expr = parser.parseExpression("PlaceOfBirth?.City");
		city = expr.getValue(tesla, String.class);
		// returns null without throwing NPE
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), city);
		
		
	}
	
	public static void main(String[] args) {
		SafeNavigation app = new SafeNavigation();
		app.safeNavigationOperator();
	}

}
