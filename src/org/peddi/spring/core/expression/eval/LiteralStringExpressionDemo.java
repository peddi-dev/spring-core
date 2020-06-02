package org.peddi.spring.core.expression.eval;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.Expression;

import static java.lang.System.out;

import java.time.LocalDate;
import java.util.Arrays;

public class LiteralStringExpressionDemo {
	
	public void literalStringExpression() {
		
		String expressionString = "'Hello World'";
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(expressionString);
		String value = (String) expression.getValue();
		out.printf("%n Expression is: %s, Value is: %s%n", expressionString, value);
		
	}
	
	
	public void methodCallExpression() {
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'HelloWorld'.concat('!')");
		String value = (String) expression.getValue();
		
		out.printf("%n Expression: %s, Value: %s%n", expression.getExpressionString(), value);
	}
	
	public void invokeJavaBeanProperty() {
		
		ExpressionParser parser = new SpelExpressionParser();
		// invokes getBytes()
		Expression expression = parser.parseExpression("'HelloWorld'.bytes");
		byte[] value = (byte[]) expression.getValue();
		out.printf("%n Expression: %s, Value: %s%n", expression.getExpressionString(), Arrays.toString(value));
		
		// invokes 'getBytes().length'
		expression = parser.parseExpression("'HelloWorld'.bytes.length");
		int value2 = (int) expression.getValue();
		out.printf("%n Expression: %s, Value: %s%n", expression.getExpressionString(), value2);
		
	}
	
	public void invokeConstructor() {
		ExpressionParser parser = new SpelExpressionParser();
		//Invokes String() constructor
		Expression expression = parser.parseExpression("new String('HelloWorld').toUpperCase()");
		String value = expression.getValue(String.class);
		out.printf("%n Expression: %s, Value: %s%n", expression.getExpressionString(), value);
	}
	
	public void evaluateExpressionStringAgainstObject() {
		Inventor tesla = new Inventor(
				"Nikola Tesla",
				 LocalDate.of(1856,7,9),
				"Serbian");
		ExpressionParser parser = new SpelExpressionParser();
		Expression expr = parser.parseExpression("name");
		String name = expr.getValue(tesla, String.class);
		out.printf("%n Expression: %s, Value: %s%n", expr.getExpressionString(), name);
		
		expr = parser.parseExpression("name == 'Nikola Tesla'");
		Boolean value = expr.getValue(tesla, Boolean.class);
		out.printf("%n Expression: %s, Value: %s%n", expr.getExpressionString(), value);
		
	}

	public static void main(String[] args) {
		
		LiteralStringExpressionDemo app = new LiteralStringExpressionDemo();
		app.literalStringExpression();
		app.methodCallExpression();
		app.invokeJavaBeanProperty();
		app.invokeConstructor();
		app.evaluateExpressionStringAgainstObject();

	}

}
