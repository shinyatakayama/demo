package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		Predicate<String> predicate = new Predicate<String>() {
			public boolean test(String s) {
				return s.startsWith("A");
			}
		};

		Function<String, String> function = new Function<String, String>() {
			public String apply(String s) {
				return s.toLowerCase();
			}
		};

		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String s) {
//				System.out.println(s);
			}
		};

		List<String> list = Arrays.asList("AA", "AB", "BC");
		list.stream().filter(predicate).map(function).forEach(consumer);

		List<String> testList = Arrays.asList("AA", "BB", "CC");
		List<String> test = testList.stream().filter(s -> s.equals("AA") || s.endsWith("C")).map(s -> s.toLowerCase())
				.collect(Collectors.toList());
//		test.forEach(s -> System.out.println(s));

		Comparator c = (s1, s2) -> {
			int diff = ((String) s2).length() - ((String) s1).length();
			return diff != 0 ? diff : ((String) s1).compareTo((String) s2);
		};

		List<String> lista = Arrays.asList("BB", "ABCDE", "AA");
		Collections.sort(lista, c);

		System.out.println(list);
	}

}
