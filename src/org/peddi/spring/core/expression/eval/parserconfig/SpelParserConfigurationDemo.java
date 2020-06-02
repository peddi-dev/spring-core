package org.peddi.spring.core.expression.eval.parserconfig;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Expression;


public class SpelParserConfigurationDemo {
	
	public void spelParserConfigurationDemo() {
		
		SpelParserConfiguration parserConfig = new SpelParserConfiguration(
				true, // autoGrowNullReferences
				true  // autoGrowCollections
				);
		
		ExpressionParser parser = new SpelExpressionParser(parserConfig);
		
		Expression exp = parser.parseExpression("list[3]");
		
		Sample sample = new Sample();
		// expression list[3] gets evaluated and null reference list gets initialized with upto the index 3. 
		exp.getValue(sample);
		
		System.out.printf("List null refrence is initialized with size: %d", sample.getList().size());
	}
	
	public static void main(String[] args) {
		SpelParserConfigurationDemo app = new SpelParserConfigurationDemo();
		app.spelParserConfigurationDemo();
	}

}
