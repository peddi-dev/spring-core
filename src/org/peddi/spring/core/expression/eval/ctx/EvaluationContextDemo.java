package org.peddi.spring.core.expression.eval.ctx;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;

import static java.lang.System.out;

public class EvaluationContextDemo {
	
	public void simleEvalCtxDataBindingPropertiesReadOnlyAccess() {
		
		EvaluationContext ctx = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		
		Simple simple = new Simple();
		simple.getBooleanList().add(true);
		
		ExpressionParser parser = new SpelExpressionParser();
		
		
		// "false" is passed in here as a String. SpEL and the conversion service
		// will recognize that it needs to be a Boolean and convert it accordingly.
		Expression exp = parser.parseExpression("booleanList[0]");
		
		exp.setValue(ctx, simple, "false");
		out.println(simple.getBooleanList().get(0));
	}

	public static void main(String[] args) {
		
		EvaluationContextDemo app = new EvaluationContextDemo();
		app.simleEvalCtxDataBindingPropertiesReadOnlyAccess();
		

	}

}
