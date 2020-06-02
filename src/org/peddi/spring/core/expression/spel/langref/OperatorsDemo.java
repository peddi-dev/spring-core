package org.peddi.spring.core.expression.spel.langref;


import static java.lang.System.out;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
public class OperatorsDemo {
	
	public void relationalOperators() {
		out.println("*******relationalOperators()");
		
		ExpressionParser parser  = SpELCommon.getParser();
		Expression expr = parser.parseExpression("2 == 2");
		Boolean equal = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), equal);
		
		expr = parser.parseExpression("2 < -5.0");
		Boolean lessthan = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), lessthan);
		
		expr = parser.parseExpression("'block' > 'black' ");
		Boolean greaterthan = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), greaterthan);
		
		// null is treated as nothing, but not as zero. null is always lessthan anything
		expr = parser.parseExpression(" 'X' > null ");
		Boolean nullGT = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), nullGT);
		
		// false
		expr = parser.parseExpression(" 0 < null ");
		Boolean nullLT = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), nullLT);
		
		
		// false
		expr = parser.parseExpression(" 'xyz' instanceof T(Integer) ");
		Boolean result1 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result1);
		
		// false
		expr = parser.parseExpression(" '116' instanceof T(Integer) ");
		Boolean result2 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result2);
		
		// true
		expr = parser.parseExpression(" 116 instanceof T(Integer) ");
		Boolean result3 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result3);
		
		// false , 1 is autoboxed to Integer , hence instanceof T(int) is false
		expr = parser.parseExpression(" 1 instanceof T(int) ");
		Boolean result31 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result31);
		
		// true
		expr = parser.parseExpression(" 1 instanceof T(Integer) ");
		Boolean result32 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result32);
		
	
		//expr = parser.parseExpression(" '5.00' matches regularExpression ");
	
		//expr = parser.parseExpression(" '5.00' matches '^-?\\d+(\\.\\d{2})?$' ");
		String regEx =  "^-?\\d+(\\.\\d{2})?$";
		EvaluationContext rwContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
		rwContext.setVariable("RegExVar", regEx);
		expr = parser.parseExpression(" '5.00' matches #RegExVar ");
		Boolean result4 = expr.getValue(rwContext, Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result4);
		
		expr = parser.parseExpression(" '5.0067' matches '^-?\\d+(\\.\\d{2})?$' ");
		Boolean result5 = expr.getValue( Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result5);
		
		expr = parser.parseExpression(" 10 le 10 ");
		Boolean result6 = expr.getValue( Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), result6);
		
		expr = parser.parseExpression(" 91 mod 3 ");
		int mod = (int) expr.getValue( );
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), mod);
		
				
	}
	
	public void logicalOperators() {
		out.println("*******relationalOperators()");
		
		ExpressionParser parser  = SpELCommon.getParser();
		Expression expr = parser.parseExpression(" true and false");
		Boolean r1 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r1);
		
		
		expr = parser.parseExpression(" true && false");
		Boolean r2 = expr.getValue(Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r2);
		
		
		expr = parser.parseExpression("isMember('Nikola Tesla') and isMember('Mihajlo Pupin')");
		Boolean r3 = expr.getValue(Util.getSociety(), Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r3);
		
		expr = parser.parseExpression("isMember('Nikola Tesla') and isMember('Albert Einstein')");
		Boolean r4 = expr.getValue(Util.getSociety(), Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r4);
		
		expr = parser.parseExpression("isMember('Nikola Tesla') and not isMember('Albert Einstein')");
		Boolean r5 = expr.getValue(Util.getSociety(), Boolean.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r5);
	}
	
	public void mathematicalOperators() {
		out.println("*******mathematicalOperators()");
		
		ExpressionParser parser  = SpELCommon.getParser();
		Expression expr = parser.parseExpression(" 1 + 1");
		int r1 = (int) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r1);
		
		expr = parser.parseExpression(" 'test' + ' ' + 'String'");
		String r2 =  expr.getValue(String.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r2);
		
		expr = parser.parseExpression(" 1 - -3");
		int r3 = (int) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r3);
		
		
		expr = parser.parseExpression(" 1000.00 - 1e4");
		double r4 = (double) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r4);
		
		expr = parser.parseExpression(" 2.0 * 3e0 * 4.0");
		double r5 = (double) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r5);
		
		expr = parser.parseExpression(" 8.0 / 4e0 / 2.0");
		double r6 = (double) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r6);
		
		expr = parser.parseExpression(" 8/ 5 % 2");
		int r7 = (int) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r7);
	}
	
	public void assignmentOperators() {
		out.println("*******assignmentOperators()");
		ExpressionParser parser  = SpELCommon.getParser();
		Expression expr = parser.parseExpression("Name");
		Inventor inventor = new Inventor();
		expr.setValue(inventor, "Aleksandar Seovic");
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), inventor.getName());
		
		parser  = SpELCommon.getParser();
		expr = parser.parseExpression(" Name = 'Albert Einstein' ");
		String result = expr.getValue(inventor, String.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(),result);
		
	}
	
	public static void main(String[] args) {
		OperatorsDemo app = new OperatorsDemo();
		app.relationalOperators();
		//app.logicalOperators();
		//app.mathematicalOperators();
		//app.assignmentOperators();
	}

}
