package org.peddi.spring.core.expression.spel.langref;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.peddi.spring.core.expression.spel.langref.samples.Inventor;
import org.peddi.spring.core.expression.spel.langref.samples.Society;
import org.peddi.spring.core.expression.spel.langref.samples.Util;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class PropsArraysListsMapsIndexers {
	
	public void propsArraysListsMaps() {
		
		//Properties
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("Birthdate.year");
		EvaluationContext ctx = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		
		int year = (int) expr.getValue(ctx, Util.getInventors().get(0));
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), year);
		
		expr = parser.parseExpression("placeOfBirth.City");
		String city =  expr.getValue(ctx,Util.getInventors().get(0), String.class );
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), city);
		
		//Arrays
		expr = parser.parseExpression("inventions[1]");
		String invention =  expr.getValue(ctx,Util.getInventors().get(0), String.class );
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), invention);
		
		//Lists
		expr = parser.parseExpression("Members[0].name");
		Society society = Util.getSociety();
		
		EvaluationContext societyContext = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(society).build();
		String name =  expr.getValue(societyContext, String.class );
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), name);
		
		//Maps
		out.println(society.getOfficers().get("president"));
		 
		 expr = parser.parseExpression("Officers['president']");
		 Inventor pupin = expr.getValue(societyContext, Inventor.class);
		 out.printf("%n%s ==> %s%n", expr.getExpressionString(), pupin.getName());
		 
		 expr = parser.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country");
		 String country = expr.getValue(societyContext, String.class);
		 out.printf("%n%s ==> %s%n", expr.getExpressionString(), country);
		
	}
	
	public void inlineLists() {
		// evaluates to a Java list containing the four numbers
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("{10, 20, 30, 40}");
		List<?> numbers = expr.getValue(List.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), numbers);
		
		expr = parser.parseExpression("{ {'x', 'y'}, {'a', 'b', 'c'} }");
		List<?> listOfList =  (List<?>) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), listOfList);
		
		expr = parser.parseExpression("{ }");
		List<?> emptyList = (List<?>) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), emptyList);
		
	}
	
	public void inlineMaps(){
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("{:}");
		Map<?, ?> emptyMap = expr.getValue(Map.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), emptyMap);
		
		expr = parser.parseExpression("{name: 'Nikola Tesla', dob:'10-July-1986'}");
		@SuppressWarnings("unchecked")
		Map<String, String> inventorInfo = expr.getValue(Map.class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), inventorInfo);
		
		expr = parser.parseExpression("{name: {firstName:'Nikola', lastName:'Tesla'}, dob:{day:10, month:'July', year:1986} }");
		Map<?, ?> mapOfMaps = expr.getValue(Map.class);
		out.printf("%n%s ==> %n    %s%n", expr.getExpressionString(), mapOfMaps);
		
	}
	
	public void arrays() {
		
		ExpressionParser parser = SpELCommon.getParser();
		Expression expr = parser.parseExpression("new int[4]");
		int[] nums1 =  expr.getValue(int[].class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), nums1);
		
		 expr = parser.parseExpression("new int[4] {10, 20 , 30 , 40}");
		int[] nums2 =  expr.getValue(int[].class);
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), Arrays.toString(nums2));
		
		 expr = parser.parseExpression("new int[2][2]");
		int[][] matrix =  (int[][]) expr.getValue();
		out.printf("%n%s ==> %s%n", expr.getExpressionString(), matrix);
		
		
	}
	
	public static void main(String[] args) {
		PropsArraysListsMapsIndexers app  = new PropsArraysListsMapsIndexers();
	//	app.propsArraysListsMaps();	
	//	app.inlineLists();
	//	app.inlineMaps();
		app.arrays();
	}

}
