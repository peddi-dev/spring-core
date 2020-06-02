package org.peddi.spring.core.expression.spel.langref;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELCommon {
	
	public static ExpressionParser getParser() {
		return new SpelExpressionParser();
	}

}
