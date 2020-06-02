package org.peddi.spring.core.expression.spel.langref;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Expression;

import static java.lang.System.out;

public class LiteralExpressionsDemo {
	
	public void literalExpressionsDemo() {
		
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("'HelloWorld'");
		String value = (String) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), value);
		
		expr = parser.parseExpression("6.0221415E+23");
		double doubleValue = (double) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), doubleValue);
		
		expr = parser.parseExpression("0x7FFFFFFF");
		int intValue = (int) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), intValue);
		
		expr = parser.parseExpression("true");
		boolean boolValue = (boolean) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), boolValue);
		
		expr = parser.parseExpression("null");
		Object valObj =  expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), valObj);
		
	}
	
	public void propsArraysListsMapsIndexers() {
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		LiteralExpressionsDemo app = new LiteralExpressionsDemo();
		app.literalExpressionsDemo();
	}

}
