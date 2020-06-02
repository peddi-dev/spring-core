package org.peddi.spring.core.expression.spel.langref;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;



import org.springframework.expression.Expression;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
public class VariablesFunctionsBeanRefs {
	
	public void varaibles() {
		
		out.println("******varaibles()");
		
		Inventor inventor = new Inventor("Nikola Tesla", "Serbian");
		EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
		context.setVariable("newName", "Mike Tesla");
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("Name = #newName");
		String r1 = expr.getValue(context, inventor, String.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r1);
		//out.println(inventor.getName());
		
		//#this and #root vairables
		List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17);
		EvaluationContext context2 = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		context2.setVariable("PrimesVar", primes);
		
		// all prime numbers > 10 from the list (using selection ?{...})
		// evaluates to [11, 13, 17]
		expr = parser.parseExpression("#PrimesVar.?[#this>10]");
		@SuppressWarnings("unchecked")
		List<Integer> r2 = (List<Integer>) expr.getValue(context2);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r2);
				
		
	}
	
	public void functions() {
		out.println("******functions()");
		
		
		java.lang.reflect.Method stringReverse = null;
		try {
			
			stringReverse = Util.class.getDeclaredMethod("reverseString", String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExpressionParser parser = SpELCommon.getParser();
		EvaluationContext ctx = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		ctx.setVariable("MyStringReverseFunction", stringReverse);
		Expression expr = parser.parseExpression("#MyStringReverseFunction('Spring Expression Language')");
		String r = expr.getValue(ctx, String.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), r);
		
	}
	
	public static void main(String[] args) {
		VariablesFunctionsBeanRefs app = new VariablesFunctionsBeanRefs();
		//app.varaibles();
		app.functions();
		
	}

}
