package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		long count = list.stream()
	            .filter(s -> s.startsWith("C"))
	            .mapToInt(s -> s.length())
	            .sum();
		
		System.out.println(count);
	}

	private static Optional<String> getName(String key) {
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("1", "suzy");
		dataMap.put("2", "michiya");
		dataMap.put("3", "saya");

		return Optional.ofNullable(dataMap.get(key));
	}
	


}