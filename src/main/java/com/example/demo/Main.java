package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface InterfaceTest {
	// 抽象メソッド
	public String method(String name, int n);
}

public class Main {

	public static void main(String[] args) {

		// ラムダ式の場合
		InterfaceTest it = (name, n) -> {
			return "Hello " + name + n + "!";
		};
		System.out.println(it.method("Java", 8));

		Integer[] num = { 1, 2, 3, 4, 5 };
		List<Integer> l = Arrays.asList(num);

		// ラムダ式の記述
		l.forEach(System.out::println);

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		integerList.stream().map(i -> "要素は" + i + "です").forEach(i -> System.out.println(i));

		List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5);
		integerList1.stream().sorted(Comparator.naturalOrder()).forEach(i -> System.out.println(i));

		String key = "3";
		// nullの場合は空文字を指定するため、実行結果は0
		System.out.println(getName(key).orElse("").length());

		List<String> list = Arrays.asList("C", "C++", "Java", "Scala", "Ruby");
		long count = list.stream().filter(s -> s.startsWith("C")).mapToInt(s -> s.length()).sum();

		List<Integer> integerList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> aa = integerList2.stream().filter(i -> i % 2 == 0).map(i -> Arrays.asList(i))
				.reduce(new ArrayList<>(), (a, b) -> {
					a.addAll(b);
					return a;
				});
		System.out.println(count);

		List<Integer> numbers = Arrays.asList(3, 1, -4, 1, -5, 9, -2, 6, 5, 3, 5);
		List<Integer> result = numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
		System.out.println(result);

		List<String> strs = Arrays.asList("hoge", "fuga", "bars");

		// ラムダ式
		boolean b = strs.stream().anyMatch(s -> s.equals("fuga"));
		System.out.println(b);

		Set<String> set = new HashSet<String>() {
			{
				add("Windows");
				add("Linux");
				add("macOS");
			}
		};

		for (String str : set) {
			System.out.println(str); // 結果：Linux、Windows、macOS
		}

		Function<String, Integer> function = string -> Integer.parseInt(string);
		System.out.println(function.apply("12345"));

		Function<String, String> wrapDoubleQuotation = str -> "\"" + str + "\"";
		Function<String, String> wrapSingleQuotation = str -> "'" + str + "'";

		String resultFunction = wrapDoubleQuotation.apply("hoge");
		System.out.println(resultFunction);
		String resultFunction1 = wrapDoubleQuotation.apply(wrapSingleQuotation.apply("hoge"));
		System.out.println(resultFunction1);

		Predicate<String> predicate = string -> string.isEmpty();
		System.out.println(predicate.test(""));
		System.out.println(predicate.test("hoge"));

		Predicate<String> checker = s -> s.equals("Java");
		boolean result1 = checker.test("Java");
		System.out.println(result1); // true

		Optional<String> value = Optional.empty();
		String lang = value.orElse("en");
		System.out.println(lang);

	}

	private static Optional<String> getName(String key) {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("1", "suzy");
		dataMap.put("2", "michiya");
		dataMap.put("3", "saya");

		return Optional.ofNullable(dataMap.get(key));
	}

}