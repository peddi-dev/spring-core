package org.peddi.spring.core.expression.spel.langref;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;


public class ExpressionTemplates {
	
	public void expressionTemplate() {
		
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("Random number is #{T(java.lang.Math).random()}", new TemplateParserContext());
		String r = expr.getValue(String.class);
		java.lang.System.out.printf("%n%s ==> %s%n", expr.getExpressionString(), r);
	}
	
	
	public static void main(String[] args) {
		ExpressionTemplates app = new ExpressionTemplates();
		app.expressionTemplate();
		
	}

}
