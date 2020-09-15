package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sample {
	public static void main(String[] args) {
		System.out.println("test");

		final List<String> numTextList = Arrays.asList("0", "1", null);

		final List<Integer> numList = numTextList.stream().filter(Objects::nonNull).map(Integer::parseInt)
				.collect(Collectors.toList());
		
	    String test = "";
	    test = test.isEmpty() ? null : test.replace("-", "");
	    System.out.println(test);
		
	}
}
