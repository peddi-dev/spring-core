package org.peddi.spring.core.expression.spel.langref;

import static java.lang.System.out;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Society;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TernaryElvisOperatorDemo {
	
	public void ternaryOperator() {
		//If-then-else
		out.println("******ternaryOperator()");
		
		Society soc = Util.getSociety();
	
		ExpressionParser parser = SpELCommon.getParser();
		EvaluationContext ctx = new StandardEvaluationContext(soc);
		
		ctx.setVariable("queryName", "Nikola Tesla");
		
		
		String expression = "isMember(#queryName)? #queryName + ' is a member of the ' + Name  : #queryName + ' is not a member of the ' + Name ";
		
		Expression expr = parser.parseExpression(expression);
		String r = expr.getValue(ctx, String.class);
		
		out.printf(" %n%s		%n ==> 	%s%n ",expr.getExpressionString(), r );
	}
	
	public void ternaryOperatorWithExpressionTemplate() {
		//If-then-else
		out.println("******ternaryOperatorWithExpressionTemplate()");
		
		Society soc = Util.getSociety();
	
		ExpressionParser parser = SpELCommon.getParser();
		EvaluationContext ctx = new StandardEvaluationContext(soc);
		
		ctx.setVariable("queryName", "Nikola Tesla");
		
		//TODO: to be Fixed to get output same as ternaryOperator()
		String expression = "#{ isMember(#queryName) } ?  #{#queryName } is a member of the  #{ Name }  : #{#queryName} is not a member of the #{ Name } ";
		
		Expression expr = parser.parseExpression(expression, new TemplateParserContext());
		String r = expr.getValue(ctx, String.class);
		
		out.printf(" %n%s		%n ==> 	%s%n ",expr.getExpressionString(), r );
	}
	
	public void elvisOperator() {
		out.println("\n******ElvisOperator()");
		//String name = "Elvis Presley";
		
		Inventor inventor = Util.getInventors().get(0);
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr =  parser.parseExpression(" Name?: 'Unknown' ");
		String r = expr.getValue(inventor, String.class);
		out.printf(" %n%s ==> %s%n ",expr.getExpressionString(), r );
	}
	
	public static void main(String[] args) {
		
		
		TernaryElvisOperatorDemo app = new TernaryElvisOperatorDemo();
		app.ternaryOperator();
		app.ternaryOperatorWithExpressionTemplate();
		app.elvisOperator();
	}

}
