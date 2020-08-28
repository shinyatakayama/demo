package com.example.demo;

import java.util.Arrays;
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
	}
	
	

}