package com.corejava.interviews.regularexpression;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args){
		
		// String matchs
		List<String> strList = Arrays.asList("Abd","1","T2","4","3zgb","123131");
		strList.forEach(x->{
			if(x.matches("\\d+")){
				System.out.println(x);
			}
		});
		System.out.println();
		
		// string replaceAll
		strList = Arrays.asList("Abd","1","T2","4","3zgb","123131");
		strList.stream().map(x->{
			return x.replaceAll("\\d","*");
		}).forEach(System.out::println);
		System.out.println();
		
		// pattern matcher
		strList = Arrays.asList("Abd","1","T2","4","3zgb","123131");
		strList.stream().forEach(x->{
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(x);
//			MatchResult result = matcher.toMatchResult();
//			System.out.println(result);
			if(matcher.find()){
				System.out.println(matcher.group());
			}
		});
		System.out.println();
		
		// pattern matcher java 8
		strList = Arrays.asList("Abd","1","T2","4","3zgb","123131");
		Pattern pattern = Pattern.compile("\\d+");
		strList.stream()
		       .map(x->pattern.matcher(x))
		       .filter(Matcher::find)
		       .map(y->y.group())
		       .forEach(System.out::println);
	}
}
