package org.peddi.spring.core.expression.spel.langref;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;

public class CollectionSelectionProjection {
	
private Map<String, Integer> getMap() {
	Map<String, Integer> map = new HashMap<>();
	
	map.put("Lang1", 70);
	map.put("Lang2", 80);
	map.put("Lang3", 75);
	map.put("Science", 90);
	map.put("Maths", 95);
	map.put("Social", 85);
	
	return map;
	
	
}

	@SuppressWarnings("unchecked")
	public void collectionSelection() {
		
		out.println("*****collectionSelection()");
		ExpressionParser parser = SpELCommon.getParser();
		// Selection feature .?[selectionExpression]
		Expression expr = parser.parseExpression("Members.?[Nationality == 'Serbian']");
		
		
		List<Inventor> list = (List<Inventor>) expr.getValue(Util.getSociety());
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), list.size());
		
		Map<String, Integer> studMarks = getMap();
		EvaluationContext ctx = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		ctx.setVariable("Marks", studMarks);
		expr = parser.parseExpression("#Marks.?[ Value > 80 ]");
		Map<String, Integer> selection = (Map<String, Integer>) expr.getValue(ctx);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), selection);
		
		expr = parser.parseExpression("#Marks.^[ Value > 80 ]");
		selection = (Map<String, Integer>) expr.getValue(ctx);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), selection);
		
		expr = parser.parseExpression("#Marks.$[ Value > 80 ]");
		selection = (Map<String, Integer>) expr.getValue(ctx);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), selection);
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void collectionProjection() {
		
		out.println("\n*****collectionProjection()");
		ExpressionParser parser = SpELCommon.getParser();
		// Selection feature .?[selectionExpression]
		Expression expr = parser.parseExpression("Members.![PlaceOfBirth.City]");
		List<String> projection = (List<String>) expr.getValue(Util.getSociety());
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), projection);
	}
	

	public static void main(String[] args) {
		CollectionSelectionProjection app = new CollectionSelectionProjection();
		app.collectionSelection();
		app.collectionProjection();
	}

}
