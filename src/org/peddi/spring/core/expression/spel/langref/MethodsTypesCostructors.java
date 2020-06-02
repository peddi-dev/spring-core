package org.peddi.spring.core.expression.spel.langref;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;

import static java.lang.System.out;

public class MethodsTypesCostructors {
	
	public void methods() {
		
		ExpressionParser parser = SpELCommon.getParser();
		
		Expression expr = parser.parseExpression("'Spring Expression Language'.substring(7,17)");
		String value = expr.getValue(String.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), value);
		
		expr = parser.parseExpression("isMember('Nikola Tesla')");
		Boolean isMember = expr.getValue(Util.getSociety(), Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), isMember);
	}
	
	public void types() {
		
		ExpressionParser parser = SpELCommon.getParser();
		
		Expression expr = parser.parseExpression("T(String)");
		Class<?> strClass = expr.getValue(Class.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), strClass);
		
		expr = parser.parseExpression("T(Number)");
		Class<?> numClass = expr.getValue(Class.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), numClass);
		
		expr = parser.parseExpression("T(SecurityManager)");
		Class<?> secMgr = expr.getValue(Class.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), secMgr);
		
		
		// Annotation interface does not exist in the java.lang package, hence fully 
		// package qualified name is required
		expr = parser.parseExpression("T(java.lang.annotation.Annotation)");
		Class<?> annClass = expr.getValue(Class.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), annClass);
		
		expr = parser.parseExpression("T(org.peddi.spring.core.expression.spel.langref.MethodsTypesCostructors)");
		Class<?> clsObj1 = expr.getValue(Class.class);
		out.printf("%n%s ==> %n 	%s%n", expr.getExpressionString(), clsObj1);
		
		expr = parser.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR");
		Boolean boolResult = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), boolResult);
		
		
	}
	
	public void constructors() {
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = 
				parser.parseExpression("new org.peddi.spring.core.expression.spel.langref.samples.Inventor('Albert Einstein','German')");
		Inventor inventor = expr.getValue(Inventor.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), inventor.getName());
		
		
		expr = parser.
				parseExpression("Members.add(new org.peddi.spring.core.expression.spel.langref.samples.Inventor('Albert Einstein','German'))");
		
		Boolean isAdd = expr.getValue(Util.getSociety(), Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), isAdd);
		
	}

	public static void main(String[] args) {
		MethodsTypesCostructors app = new MethodsTypesCostructors();
		app.methods();
		//app.types();
		//app.constructors();

	}

}
