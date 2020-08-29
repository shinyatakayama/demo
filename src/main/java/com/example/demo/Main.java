package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
		
        Integer[] num = {1, 2, 3, 4, 5};
        List<Integer> l = Arrays.asList(num);
 
        // ラムダ式の記述
        l.forEach(System.out::println);
        
    	List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    	integerList.stream().map(i -> "要素は" + i + "です").forEach(i -> System.out.println(i));

    	List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5);
    	integerList1.stream()
    	        .sorted(Comparator.naturalOrder())
    	        .forEach(i -> System.out.println(i));
	}
	
}